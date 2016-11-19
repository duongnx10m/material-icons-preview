package com.duongnx.materialicons;

import android.app.Application;

import com.duongnx.materialicons.models.ItemIcon;

import java.util.ArrayList;

/**
 * Created by duongnx on 11/19/16.
 */

public class GApplication extends Application {
    static GApplication instance;
    private ArrayList<ItemIcon> iconActions = null;

    public static GApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public ArrayList<ItemIcon> getIconActions() {
        if (iconActions == null) {
            iconActions.add(new ItemIcon(R.drawable.ic_3d_rotation_black_160dp, "3D Rotation"));
            iconActions.add(new ItemIcon(R.drawable.ic_access_alarm_black_160dp, "Alarm"));
            iconActions.add(new ItemIcon(R.drawable.ic_access_time_black_160dp, "Time"));
            iconActions.add(new ItemIcon(R.drawable.ic_accessibility_black_120dp, "Accessibility"));
            iconActions.add(new ItemIcon(R.drawable.ic_accessible_black_120dp, "Accessible"));
            iconActions.add(new ItemIcon(R.drawable.ic_account_balance_black_120dp, "Balance"));
            iconActions.add(new ItemIcon(R.drawable.ic_account_balance_wallet_black_120dp, "Wallet"));
            iconActions.add(new ItemIcon(R.drawable.ic_account_box_black_120dp, "Account Box"));
            iconActions.add(new ItemIcon(R.drawable.ic_account_circle_black_120dp, "Account Circle"));
            iconActions.add(new ItemIcon(R.drawable.ic_add_shopping_cart_black_120dp, "Shopping Cart"));
            iconActions.add(new ItemIcon(R.drawable.ic_alarm_add_black_120dp, "Alarm Add"));
            iconActions.add(new ItemIcon(R.drawable.ic_alarm_off_black_120dp, "Alarm Off"));
            iconActions.add(new ItemIcon(R.drawable.ic_alarm_on_black_120dp, "Alarm On"));
            iconActions.add(new ItemIcon(R.drawable.ic_android_black_120dp, "Android"));
            iconActions.add(new ItemIcon(R.drawable.ic_announcement_black_120dp, "Announcement"));
            iconActions.add(new ItemIcon(R.drawable.ic_aspect_ratio_black_120dp, "Aspect Ratio"));
            iconActions.add(new ItemIcon(R.drawable.ic_assessment_black_120dp, "Assessment"));
            iconActions.add(new ItemIcon(R.drawable.ic_assignment_black_120dp, "Assignment"));
            iconActions.add(new ItemIcon(R.drawable.ic_assignment_ind_black_120dp, "Assignment Ind"));
            iconActions.add(new ItemIcon(R.drawable.ic_assignment_late_black_120dp, "Assignment Late"));
            iconActions.add(new ItemIcon(R.drawable.ic_assignment_return_black_120dp, "Assignment Return"));
            iconActions.add(new ItemIcon(R.drawable.ic_assignment_returned_black_120dp, "Assignment Returned"));
            iconActions.add(new ItemIcon(R.drawable.ic_assignment_turned_in_black_120dp, "Assignment Turned"));
            iconActions.add(new ItemIcon(R.drawable.ic_autorenew_black_120dp, "Auto Renew"));
            iconActions.add(new ItemIcon(R.drawable.ic_backup_black_120dp, "Backup"));
            iconActions.add(new ItemIcon(R.drawable.ic_book_black_120dp, "Book"));
            iconActions.add(new ItemIcon(R.drawable.ic_bookmark_border_black_120dp, "Bookmark"));
            iconActions.add(new ItemIcon(R.drawable.ic_bug_report_black_120dp, "Bookmark"));
            iconActions.add(new ItemIcon(R.drawable.ic_build_black_120dp, "Build"));
            iconActions.add(new ItemIcon(R.drawable.ic_cached_black_120dp, "Cached"));
            iconActions.add(new ItemIcon(R.drawable.ic_camera_enhance_black_120dp, "Camera Enhance"));
            iconActions.add(new ItemIcon(R.drawable.ic_card_giftcard_black_120dp, "Card Giftcard"));
            iconActions.add(new ItemIcon(R.drawable.ic_card_membership_black_120dp, "Card Membership"));
            iconActions.add(new ItemIcon(R.drawable.ic_card_travel_black_120dp, "Card Travel"));
            iconActions.add(new ItemIcon(R.drawable.ic_change_history_black_120dp, "Change History"));
            iconActions.add(new ItemIcon(R.drawable.ic_check_circle_black_120dp, "Check Circle"));

            iconActions.add(new ItemIcon(R.drawable.ic_code_black_120dp, "Code"));

        }
        return iconActions;
    }
}
