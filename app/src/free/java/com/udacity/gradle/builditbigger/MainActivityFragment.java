package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private InterstitialAd mInterstitialAd;
    private JokeListener mJokeListener;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        AdView mAdView = root.findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        MobileAds.initialize(getActivity(),
                "YOUR_ADMOB_APP_ID");

        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId("YOUR_ADD_UNIT_ID");
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                if (mInterstitialAd.isLoaded())
                    mInterstitialAd.show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                mJokeListener.readyForJoke();
            }

            @Override
            public void onAdOpened() {

            }

            @Override
            public void onAdLeftApplication() {

            }

            @Override
            public void onAdClosed() {
                mJokeListener.readyForJoke();
            }
        });
        return root;
    }

    public void askForJoke(JokeListener listener) {
        mJokeListener = listener;
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

}
