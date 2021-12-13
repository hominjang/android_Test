package com.example.preferencefragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragment;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceScreen;

import com.example.preferencefragment.databinding.FragmentFirstBinding;

import static com.example.preferencefragment.MainActivity.TARGET_SETTING_PAGE;

public class FirstFragment extends PreferenceFragment {

    SharedPreferences prefs;

    Preference message;
    Preference vibrate;
    Preference nickname;

    Preference keywordSoundPreference;
    Preference keywordSoundsPreference;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.setting_preference, rootKey);

        if (rootKey == null) {
            // 초기값들이 없다면 이렇게 설정해라

            message = findPreference("message");
            vibrate = findPreference("vibrate");
            nickname = findPreference("nickname");

            keywordSoundPreference = findPreference("keyword_sound_list");
            keywordSoundsPreference = findPreference("keyword_sounds_list");

            prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
            if (rootKey == null) {
                // 초기화작업들 설정해주면됨
                if (!prefs.getString("keyword_sound_list", "").equals("")) {
                }
            }
        }

        prefs.registerOnSharedPreferenceChangeListener(prefListener);

    }

    SharedPreferences.OnSharedPreferenceChangeListener prefListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
            // 설정이 바뀐 순간 sharedPreference로 바로바로 저장된다.
            if (s.equals("message")) { // 바뀐 키를 인식
                if (prefs.getBoolean("message", true)) {
                    // 알다시피 첫번째 인자는 키값, 키값이 널이면 두번째 인자가 호출
                    message.setSummary("확인");
                }else{
                    message.setSummary("아님");
                }
            }

            if(s.equals(nickname)){
                nickname.setSummary(prefs.getString("nickname","없음"));
            }
        }
    };

    @Override
    public void onNavigateToScreen(PreferenceScreen preferenceScreen) {
        super.onNavigateToScreen(preferenceScreen);
        Intent intent = new Intent(getActivity(), MainActivity.class).putExtra(TARGET_SETTING_PAGE, preferenceScreen.getKey());
        startActivity(intent);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }


}