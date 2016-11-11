package org.catrobat.paintroid;

/**
 * Created by Aiman M. Ayyal Awwad on 6/28/2016.
 */


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Locale;


public class MultilanguageActivity extends Activity {
    public static final String TAG = "MULTILANGACTIVITY";
    Locale mLocale;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.language_settings);
        setTitle(R.string.activity_title);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void Arabic_Lang(View view) {
        mLocale = new Locale("ar");
        setContextLocale(this, mLocale);
    }

    public void English_Lang(View view) {
        mLocale = new Locale("en");
        setContextLocale(this, mLocale);
    }

    public void Bosnian_Lang(View view) {
        mLocale = new Locale("bs");
        setContextLocale(this, mLocale);
    }

    public void Danish_Lang(View view) {
        mLocale = new Locale("da");
        setContextLocale(this, mLocale);
    }

    public void German_Lang(View view) {
        mLocale = new Locale("de");
        setContextLocale(this, mLocale);
    }

    public void English_AU_Lang(View view) {
        mLocale = new Locale("en", "AU");
        setContextLocale(this, mLocale);
    }

    public void English_CA_Lang(View view) {
        mLocale = new Locale("en", "CA");
        setContextLocale(this, mLocale);
    }

    public void English_GB_Lang(View view) {
        mLocale = new Locale("en", "GB");
        setContextLocale(this, mLocale);
    }

    public void Spanish_Lang(View view) {
        mLocale = new Locale("es");
        setContextLocale(this, mLocale);
    }

    public void Farsi_Lang(View view) {
        mLocale = new Locale("fa");
        setContextLocale(this, mLocale);
    }

    public void French_Lang(View view) {
        mLocale = new Locale("fr");
        setContextLocale(this, mLocale);
    }

    public void Gujarati_Lang(View view) {
        mLocale = new Locale("gu");
        setContextLocale(this, mLocale);
    }

    public void Hindi_Lang(View view) {
        mLocale = new Locale("hi");
        setContextLocale(this, mLocale);
    }

    public void Croatian_Lang(View view) {
        mLocale = new Locale("hr");
        setContextLocale(this, mLocale);
    }

    public void Hungarian_Lang(View view) {
        mLocale = new Locale("hu");
        setContextLocale(this, mLocale);
    }

    public void Indonesian_Lang(View view) {
        mLocale = new Locale("id");
        setContextLocale(this, mLocale);
    }

    public void Italian_Lang(View view) {
        mLocale = new Locale("it");
        setContextLocale(this, mLocale);
    }

    public void Japanese_Lang(View view) {
        mLocale = new Locale("ja");
        setContextLocale(this, mLocale);
    }

    public void Korean_Lang(View view) {
        mLocale = new Locale("ko");
        setContextLocale(this, mLocale);
    }

    public void Macedonian_Lang(View view) {
        mLocale = new Locale("mk");
        setContextLocale(this, mLocale);
    }

    public void Malay_Lang(View view) {
        mLocale = new Locale("ms");
        setContextLocale(this, mLocale);
    }

    public void Dutch_Lang(View view) {
        mLocale = new Locale("nl");
        setContextLocale(this, mLocale);
    }

    public void Norwegian_Lang(View view) {
        mLocale = new Locale("nb", "NO");
        setContextLocale(this, mLocale);
    }

    public void Polish_Lang(View view) {
        mLocale = new Locale("pl");
        setContextLocale(this, mLocale);
    }

    public void Pashto_Lang(View view) {
        mLocale = new Locale("ps");
        setContextLocale(this, mLocale);
    }

    public void Portuguese_Lang(View view) {
        mLocale = new Locale("pt");
        setContextLocale(this, mLocale);
    }

    public void Portuguese_Brazil_Lang(View view) {
        mLocale = new Locale("pt", "BR");
        setContextLocale(this, mLocale);
    }

    public void Romanian_Lang(View view) {
        mLocale = new Locale("ro");
        setContextLocale(this, mLocale);
    }

    public void Russian_Lang(View view) {
        mLocale = new Locale("ru");
        setContextLocale(this, mLocale);
    }

    public void Sindhi_Lang(View view) {
        mLocale = new Locale("sd");
        setContextLocale(this, mLocale);
    }

    public void Slovenian_Lang(View view) {
        mLocale = new Locale("sl");
        setContextLocale(this, mLocale);
    }

    public void Serbian_Serbia_Lang(View view) {
        mLocale = new Locale("sr", "SP");
        setContextLocale(this, mLocale);
    }

    public void Serbian_CzechRepublic_Lang(View view) {
        mLocale = new Locale("sr", "CS");
        setContextLocale(this, mLocale);
    }

    public void Serbian_Latin_Lang(View view) {
        //mLocale=new Locale("sr","SP");
        mLocale = new Locale("sr");
        setContextLocale(this, mLocale);
    }

    public void Swedish_Lang(View view) {
        mLocale = new Locale("sv");
        setContextLocale(this, mLocale);
    }

    public void Tamil_Lang(View view) {
        mLocale = new Locale("ta");
        setContextLocale(this, mLocale);
    }

    public void Telugu_Lang(View view) {
        mLocale = new Locale("te");
        setContextLocale(this, mLocale);
    }

    public void Thai_Lang(View view) {
        mLocale = new Locale("th");
        setContextLocale(this, mLocale);
    }

    public void Turkish_Lang(View view) {
        mLocale = new Locale("tr");
        setContextLocale(this, mLocale);
    }

    public void Urdu_Pakistan_Lang(View view) {
        mLocale = new Locale("ur", "PK");
        setContextLocale(this, mLocale);

    }

    public void Vietnamese_Lang(View view) {
        mLocale = new Locale("vi");
        setContextLocale(this, mLocale);
    }

    public void Chinese_China_Lang(View view) {
        mLocale = new Locale("zh", "CN");
        setContextLocale(this, mLocale);
    }

    public void Chinese_Taiwan_Lang(View view) {
        mLocale = new Locale("zh", "TW");
        setContextLocale(this, mLocale);
    }

    //set the locale (lang,country) configurations according to the selected one
    public void setContextLocale(Context context, Locale mLocale) {
        String languageCode = mLocale.getLanguage();
        Log.d(TAG, "#### lang-code:" + languageCode);

        Locale.setDefault(mLocale);
        Resources resources = context.getResources();

        int languageCodeId = resources.getIdentifier(languageCode, "id", context.getPackageName());
        Log.d(TAG, "#### lang-code-ID:" + languageCodeId);
        Log.d(TAG, "#### lang-code-ID (should be): unknown" + getLanguageResourceIdByStringNatively(languageCode));


        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration conf = resources.getConfiguration();
        conf.locale = mLocale;
        conf.setLayoutDirection(mLocale);
        resources.updateConfiguration(conf, displayMetrics);
        RefreshForApp();//Restart the application for loading the new language configuration
    }

    public void RefreshForApp() {
        Intent intent = new Intent(MultilanguageActivity.this, MainActivity.class);
        startActivity(intent);
        finishAffinity();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Multilanguage Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://org.catrobat.paintroid/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Multilanguage Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://org.catrobat.paintroid/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    /**
     * helper method for debugging to determine the language code id from the ressources via R.java
     * @param languageCode which resource id is to be retrieved
     * @return the resource id determined by the passed languageCode string
     */
    private int getLanguageResourceIdByStringNatively(String languageCode){
        if (languageCode.equals("ar")) {
            return R.id.ar;
        } else if (languageCode.equals("sr")){
            return R.id.sr;
        } else if (languageCode.equals("ro")){
            return R.id.ro;
        } else if (languageCode.equals("ru")) {
            return R.id.ru;
        } else if (languageCode.equals("sl")){
            return R.id.sl;
        } else if (languageCode.equals("sv")){
            return R.id.sv;
        } else if (languageCode.equals("tr")){
            return R.id.tr;
        }else if (languageCode.equals("bs")){
            return R.id.bs;
        }else if (languageCode.equals("de")){
            return R.id.de;
        } else if (languageCode.equals("en")){
            return R.id.en;
        } else if (languageCode.equals("es")){
            return R.id.es;
        }else if (languageCode.equals("fa")){
            return R.id.fa;
        }else if (languageCode.equals("fr")){
            return R.id.fr;
        } else if (languageCode.equals("hr")){
            return R.id.hr;
        } else if (languageCode.equals("hu")){
            return R.id.hu;
        } else if (languageCode.equals("it")){
            return R.id.sr;
        }else if (languageCode.equals("ja")){
            return R.id.ja;
        } else if (languageCode.equals("ko")){
            return R.id.ko;
        } else if (languageCode.equals("nl")){
            return R.id.nl;
        } else if (languageCode.equals("no")){
            return R.id.no;
        } else if (languageCode.equals("pl")){
            return R.id.pl;
        } else if (languageCode.equals("pt")){
            return R.id.pt;
        } else {
            return -1;
        }
    }
}





