package com.niko.hannes.nikomobileapp.ui.home.edit;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.niko.hannes.nikomobileapp.R;
import com.niko.hannes.nikomobileapp.dataService.AvatarDataService;
import com.niko.hannes.nikomobileapp.framework.Logger;
import com.niko.hannes.nikomobileapp.model.Avatar;
import com.niko.hannes.nikomobileapp.ui.home.MenuItemVM;

import java.util.ArrayList;
import java.util.List;

public class AvatarEditActivity  extends AppCompatActivity {


    private Logger mLogger = new Logger(AvatarEditActivity.class.getSimpleName());
    private static final String EXTRA_TITLE = "AvatarEditActivity.extraImage";
    private static final String EXTRA_AVATAR = "AvatarEditActivity.extraAvatar";
    private GridView mAvatarGrid;
    private Avatar mSelectedAvatar;
    private TextView mFirstName;
    private TextView mProfession;
    private FloatingActionButton mAddFab;


    public static void navigate(AppCompatActivity activity, MenuItemVM viewModel) {
        Intent intent = new Intent(activity, AvatarEditActivity.class);
        intent.putExtra(EXTRA_TITLE, viewModel.title);
        intent.putExtra(EXTRA_AVATAR, viewModel.avatar.ordinal());

        ActivityCompat.startActivity(activity, intent, Bundle.EMPTY);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mLogger.Debug("oncreate...");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.avatar_edit_activity);

        int avatarOrdinal = getIntent().getIntExtra(EXTRA_AVATAR, 0);

        mSelectedAvatar = Avatar.values()[avatarOrdinal];
        mFirstName = (TextView) findViewById(R.id.first_name);
        mProfession = (TextView) findViewById(R.id.profession);
        mAddFab = (FloatingActionButton) findViewById(R.id.addFab);


        setUpGridView();
        setUpTextViews();
    }

    private boolean isInEditMode() {
        final Intent intent = getIntent();
        boolean edit = false;
        if (intent != null) {
            edit = intent.getBooleanExtra(EXTRA_TITLE, false);
        }
        return edit;
    }

    private void setUpGridView() {


        mLogger.Debug("setUpGridView...");

        mAvatarGrid = (GridView) findViewById(R.id.avatars);
        mAvatarGrid.setAdapter(new AvatarAdapter(this, AvatarDataService.getInstance().get()));
        mAvatarGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                mSelectedAvatar = Avatar.values()[position];
            }
        });

        mAvatarGrid.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                                                  @Override
                                                  public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                                                      // its possible that the layout is not complete in which case
                                                      // we will get all zero values for the positions, so ignore the event
                                                      if (left == 0 && top == 0 && right == 0 && bottom == 0) {
                                                          return;
                                                      }

                                                      mAvatarGrid.setNumColumns(calculateSpanCount());

                                                  }
                                              }
        );


        mAvatarGrid.setItemChecked(mSelectedAvatar.ordinal(), true);
    }

    private int calculateSpanCount() {
        int avatarSize = getResources().getDimensionPixelSize(R.dimen.size_fab);
        int avatarPadding = getResources().getDimensionPixelSize(R.dimen.spacing_double);
        return mAvatarGrid.getMeasuredWidth() / (avatarSize + avatarPadding);
    }

    private void setUpTextViews(){

        TextWatcher txtWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                mLogger.Debug("onTextChanged...");

                //validate + show add button
                // showing the floating action button if text is entered
                if (mProfession.getText().length() == 0 || mFirstName.getText().length() == 0) {
                    mAddFab.setVisibility(View.GONE);
                } else {
                    mAddFab.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        mFirstName.addTextChangedListener(txtWatcher);
        mProfession.addTextChangedListener(txtWatcher);

    }



}
