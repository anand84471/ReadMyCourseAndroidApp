package com.readmycourse.android.activity;

import android.content.Intent;
import android.os.Bundle;
import com.readmycourse.android.R;
import com.facebook.react.modules.core.PermissionListener;
import com.readmycourse.android.services.Concrete.ApplicationPermission;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetActivityDelegate;
import org.jitsi.meet.sdk.JitsiMeetActivityInterface;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;
import org.jitsi.meet.sdk.JitsiMeetView;

import java.net.URL;

public class JitsiMeetingActivity extends ApplicationPermission implements JitsiMeetActivityInterface {
    private JitsiMeetView view;
    private String strRoomName;
    private String strMeetingAccessCode;
    private String strSubject;
    private String strRequestType;
    private boolean iSJoinRequest;
    @Override
    protected void onActivityResult(
            int requestCode,
            int resultCode,
            Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        JitsiMeetActivityDelegate.onActivityResult(
                this, requestCode, resultCode, data);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jitsi_meeting);
        getAllPermissions();
        parseBundleData();
    }

    private void createJitsiMeeting()  {
        try {
            view = new JitsiMeetView(this);
            JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                    .setServerURL(new URL("https://meet.jit.si"))
                    .setRoom(strRoomName)
                    .setAudioMuted(false)
                    .setVideoMuted(false)
                    .setAudioOnly(false)
                    .setWelcomePageEnabled(false)
                    .setSubject(strSubject)
                    .build();
            if(iSJoinRequest){
                JitsiMeetActivity.launch(this, options);
            }
            else {
                JitsiMeetActivity.launch(this, options);
            }

        }
        catch (Exception Ex)
        {

        }
    }
    @Override
    public void requestPermissions(String[] strings, int i, PermissionListener permissionListener) {

    }
    @Override
    public void onBackPressed() {
        JitsiMeetActivityDelegate.onBackPressed();
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        view.dispose();
        view = null;
        JitsiMeetActivityDelegate.onHostDestroy(this);
    }

    @Override
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        JitsiMeetActivityDelegate.onNewIntent(intent);
    }

    @Override
    public void onRequestPermissionsResult(
            final int requestCode,
            final String[] permissions,
            final int[] grantResults) {
        JitsiMeetActivityDelegate.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onResume() {
        super.onResume();

        JitsiMeetActivityDelegate.onHostResume(this);
    }

    @Override
    protected void onStop() {
        super.onStop();

        JitsiMeetActivityDelegate.onHostPause(this);
    }

    private void parseBundleData()
    {
        try {
            Bundle intentData = getIntent().getExtras();
            if(intentData != null){
                strRoomName=intentData.getString("room_name");
                strSubject=intentData.getString("subject");
                strRequestType =intentData.getString("request_type");
                if(strRoomName!=null)
                {
                    iSJoinRequest= !strRequestType.equals("create");
                    createJitsiMeeting();
                }
            }

        }
        catch (Exception Ex)
        {

        }
    }

}
