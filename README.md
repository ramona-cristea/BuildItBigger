# BuildItBigger

Project was implemented for Android Developer Nanodegree Program from Udacity, for educational purpose only. The project consists of four modules: 

* A Java library that provides jokes
* A Google Cloud Endpoints (GCE) project that serves those jokes
* An Android Library containing an activity for displaying jokes
* An Android app that fetches jokes from the GCE module using an AsyncTask and passes them to the Android Library for display.The app has a paid and a free version, implemented using flavors. In the free version, there is a BannerAd and an IntersitialAd displayed.

In order test the app, one needs to do the following:
* Get an Ad Mob App ID and replace "YOUR_ADMOB_APP_ID" with it
* Get an Ad Unit ID and replace "YOUR_AD_UNIT_ID" with it
* Replace "YOUR_SERVER_IP" with the IP of the configured GCE server
