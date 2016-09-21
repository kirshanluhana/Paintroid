package org.catrobat.paintroid.test.integration.dialog;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;

import android.graphics.Bitmap;
import android.os.Environment;
import android.os.RecoverySystem;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.base.RootViewPicker;
import android.support.test.runner.AndroidJUnit4;

import android.test.ActivityInstrumentationTestCase2;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import org.catrobat.paintroid.MainActivity;
import org.catrobat.paintroid.MultilanguageActivity;
import org.catrobat.paintroid.PaintroidApplication;
import org.catrobat.paintroid.R;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.assertion.LayoutAssertions.noEllipsizedText;
import static android.support.test.espresso.assertion.LayoutAssertions.noMultilineButtons;

import static android.support.test.espresso.assertion.LayoutAssertions.noOverlaps;
import static android.support.test.espresso.assertion.PositionAssertions.isLeftOf;
import static android.support.test.espresso.assertion.PositionAssertions.isRightOf;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;

import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by Aiman Ayyal Awwad on 10/29/2015.
 */
@RunWith(AndroidJUnit4.class)
//@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ViewsAssertionLocalizationTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public static final String TAG = "PAINTROID.ESPRESSO";

    private static List<String> rtlLanguageCodes;

    private static MainActivity mActivity;

    private String languageCode = null;

    public ViewsAssertionLocalizationTest() {

        super(MainActivity.class);
    }

//    public ViewsAssertionLocalizationTest(String languageCode) {
//
//        super(MainActivity.class);
//        this.languageCode = languageCode;
//        Log.d(ViewsAssertionLocalizationTest.TAG, "### constructor ViewsAssertionLocalizationTest(param) executed - param: "+languageCode);
//    }

    @Before
     public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        mActivity = getActivity();

        Context context =  PaintroidApplication.applicationContext;

        PackageManager pManager = context.getPackageManager();
        String packageName = context.getApplicationContext().getPackageName();

        ActivityInfo[] list = null;
        try {
            list = pManager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES).activities;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        Intent intent = null;

        if (list != null) {
            for (ActivityInfo activityInfo : list) {
                Log.d(TAG, "###### ActivityInfo = " + activityInfo.name);
            }
        }


// either change language programatically in setUp()
// which is done for every test method execution
//            Locale mLocale = new Locale(languageCode);
//            Locale.setDefault(mLocale);
//            Context context = mActivity.getApplicationContext();
//            Resources resources = context.getResources();
//            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
//            Configuration conf = resources.getConfiguration();
//            conf.locale = mLocale;
//            conf.setLayoutDirection(mLocale);
//            resources.updateConfiguration(conf, displayMetrics);

    }

    @Test
    public void theRealFirstTest(){
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withText(R.string.menu_save_image)).perform(click());
        onView(withText(R.string.saved)).inRoot(withDecorView(not(getActivity().getWindow().getDecorView()))).check(matches(isDisplayed()));


        //onView(withText(R.string.saved)).inRoot(withDecorView‌​(not(getActivity().g‌​etWindow().getDecorV‌​iew()))) .check(matches(isDisplayed()));

        // onView(withText(R.string.menu_language_settings)).perform(click());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Espresso.pressBack();
    }

    @Test
    public void theRealSecondTest(){

        FragmentManager fm = mActivity.getFragmentManager();
        Log.d("PTest: ", "#### --- fragmentManager.BackStackEntryCount(: "+fm.getBackStackEntryCount());


        View rootView =  mActivity.findViewById(android.R.id.content).getRootView();
        Log.d("PTest: ", "#### --- rootView: "+rootView.toString());

        ArrayList<View> childViewList = getAllChildrenFromView(rootView);
        Log.d("PTest: ", "#### getAllChildrenFromView(rootView).size(): "+childViewList.size());

        // perform a click on all Children and wait a a second

        for (View childView:childViewList) {
            Log.d("PTest: ", "#### childView.getId(): "+childView.getId()+" | .toString(): "+childView.toString());
            Log.d("PTest: ", "#### fragmentManager.BackStackEntrycount(): "+fm.getBackStackEntryCount());
            onView(withId(childView.getId())).perform(ViewActions.click());
            // onView(withId(childView.getId())).perform(ViewActions.scrollTo()).check(ViewAssertions.matches(isDisplayed()));
            // onView(withId(childView.getId())).check(matches(isDisplayed()));
            Log.d("PTest: ", "#### fragmentManager.BackStackEntrycount(): "+fm.getBackStackEntryCount());



            // only traverse Buttons :D
//            if (childView.toString().contains("ImageButton")){
//                onView(withId(childView.getId())).perform(click());
//                Log.d("PTest: ", "#### fragmentManager.BackStackEntryCount(): "+fm.getBackStackEntryCount());
//
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                if(fm.getBackStackEntryCount()>0){
//                    Espresso.pressBack();
//                }
//
//            }
        }


//        ViewGroup viewGroup = (ViewGroup) ((ViewGroup) mActivity.findViewById(android.R.id.content)).getChildAt(0);
//        Log.d("PTest: ", "#### rootViewGroup.getChildCount() "+viewGroup.getChildCount());
//        View view = null;
//        for (int i = 0 ; i<viewGroup.getChildCount(); i++) {
//            view = viewGroup.getChildAt(i);
//            Log.d("PTest: ", "#### "+i+": rootViewGroup.getChildAt("+i+") "+view);
//            Log.d("PTest: ", "#### "+i+": details: "+view.);
//            //Log.d("PTest: ", "#### ((ViewGroup) rootViewGroup.getChildAt()).getChildCount() "+((ViewGroup) viewGroup.getChildAt(i)).getChildCount());
//        }



    }

    private ArrayList<View> getAllChildrenFromView(View v) {

        ArrayList<View> resultViewList = new ArrayList<View>();

        if (v instanceof ViewGroup) {
            for (int i =0; i<((ViewGroup) v).getChildCount(); i++){
                resultViewList.addAll(getAllChildrenFromView(((ViewGroup) v).getChildAt(i)));
            }
            return resultViewList;
        } else {
            if(v.getId()!=-1) resultViewList.add(v);
            return resultViewList;
        }
    }

    private ArrayList<View> getAllChildrenFromView2(View v) {

        if (!(v instanceof ViewGroup)) {
            ArrayList<View> viewArrayList = new ArrayList<View>();
            if (v.getId()!=-1) viewArrayList.add(v);
            return viewArrayList;
        }

        ArrayList<View> result = new ArrayList<View>();

        ViewGroup vg = (ViewGroup) v;
        for (int i = 0; i < vg.getChildCount(); i++) {

            View child = vg.getChildAt(i);

            ArrayList<View> viewArrayList = new ArrayList<View>();

            viewArrayList.add(v);
            viewArrayList.addAll(getAllChildrenFromView(child));

            result.addAll(viewArrayList);
        }
        return result;
    }

    // ... or force test runner to use a certain order of tests, e.g., ascending names
    // so then it is possible to simulate a language change with Espresso framework
    // as the first testCase which is executed and this setting will stay over the lifespan
    // of the test.
    @Test
    @Ignore
    public void allowSetLanguageForWholeTestSet() {

        onView(withId(R.id.main_layout)).check(matches(isDisplayed()));
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.menu_language_settings)).perform(click());
        // hard coded click onto arabic language
        //onView(withId(R.id.ar)).perform(click());
        //onView(withId(languageCode)).perform(click());

        int resId = mActivity.getResources().getIdentifier(languageCode, "id", mActivity.getApplicationContext().getPackageName());
        Log.d("PTest: ","#### "+languageCode+": getIdentifierByName: "+resId);
        Log.d("PTest: ","#### For "+languageCode+" ID should be: "+getLanguageResourceIdByStringNatively(languageCode));

        onView(withId(resId)).perform(ViewActions.scrollTo()).check(ViewAssertions.matches(isDisplayed()));

        onView(withId(resId)).perform(click());


    }

    @Test
    @Ignore
    public void assertNoOverlappingForLineStrokeDialog()
    {

        onView(withId(R.id.btn_bottom_attribute1))
                .perform(click());
        onView(withId(R.id.linearlayout1)).check(noOverlaps());
    }

    @Test
    @Ignore
    public void assertNoOverlappingForColorPaletteDialog()
    {
        onView(withId(R.id.btn_bottom_attribute2))
                .perform(click());
        onView(isRoot()).check(noOverlaps());
    }

    @Test
    @Ignore
    public void assertNoOverlappingForToolsDialog()
    {
        onView(withId(R.id.btn_bottom_tools))
                .perform(click());
        onView(withId(R.id.gridview_tools_menu)).check(noOverlaps());
    }

    @Test
    @Ignore
    public void assertNoOverlappingForMainActivity()
    {
        onView(withId(R.id.main_layout)).check(noOverlaps());

    }
    @Test
    @Ignore
    public void assertNoEllipseizedTextInToolsDialog() {
        onView(withId(R.id.btn_bottom_tools))
                .perform(click());
        onView(withId(R.id.gridview_tools_menu)).check(noEllipsizedText());
    }

    @Test
    @Ignore
    public void assertNoEllipseizedTextInStrokeLineDialog()
    {
        onView(withId(R.id.btn_bottom_attribute1))
                .perform(click());
        onView(withId(R.id.stroke_width_shape_text)).check(noEllipsizedText());
    }

    @Test
    @Ignore
    public void assertNoEllipseizedTextInColorPalette()
    {
        onView(withId(R.id.btn_bottom_attribute2))
                .perform(click());
        onView(withId(R.id.colorchooser_base_layout)).check(noEllipsizedText());
    }
   @Test
   @Ignore
   public void assertNoEllipseizedMainActivity()
   {
       onView(withId(R.id.main_layout)).check(noEllipsizedText());
   }

    @Test
    @Ignore
    public void assertIsDisplayedTextForToolsText() {
        onView(withId(R.id.btn_bottom_tools))
                .perform(click());
        onView(withId(R.id.gridview_tools_menu)).check(matches(isDisplayed()));
    }

   @Test
   @Ignore
   public void assertIsDisplayedForColorPaletteDialog()
   {
    onView(withId(R.id.btn_bottom_attribute2))
            .perform(click());
       onView(withId(R.id.view_colorpicker)).check(matches(isDisplayed()));
   }

    @Test
    @Ignore
    public void assertIsDisplayedForStrokeLineDialog()
    {
        onView(withId(R.id.btn_bottom_attribute1))
                .perform(click());
        onView(withId(R.id.stroke_width_shape_text)).check(matches(isDisplayed()));
    }

    @Test
    @Ignore
    public void assertNoMultilineButtons() {
        onView(withId(R.id.btn_bottom_tools))
                .perform(click());
        onView(withId(R.id.gridview_tools_menu)).check(noMultilineButtons());
    }


    @Test
    @Ignore
    public void assertSeekBarIsRightOfValueForRtlLanguage() {
        onView(withId(R.id.btn_bottom_attribute1))
                .perform(click());
        if (rtlLanguageCodes.contains(languageCode)) {
            onView(withId(R.id.stroke_width_seek_bar)).check(isRightOf(withId(R.id.stroke_width_width_text)));
        }   else {
            onView(withId(R.id.stroke_width_seek_bar)).check(isLeftOf(withId(R.id.stroke_width_width_text)));
        }

    }

    @Test
    @Ignore
    public void assertSwipingRightForStrokeSeekbar()
    {
        onView(withId(R.id.btn_bottom_attribute1))
                .perform(click());
        onView(withId(R.id.stroke_width_seek_bar)).perform(swipeRight());
    }
    @Test
    @Ignore
    public void assertToolsRightOfTextForRtlLanguages()
    {
        onView(withId(R.id.btn_bottom_tools))
                .perform(click());
        if (rtlLanguageCodes.contains(languageCode)) {
            onView(allOf(withId(R.id.tool_button_image), hasSibling(
                    withText(R.string.button_brush))))
                    .check(isRightOf(allOf(withId(R.id.tool_button_text), hasSibling(
                            withText(R.string.button_brush)))));

        } else {
            onView(allOf(withId(R.id.tool_button_image), hasSibling(
                    withText(R.string.button_brush))))
                    .check(isLeftOf(allOf(withId(R.id.tool_button_text), hasSibling(
                            withText(R.string.button_brush)))));

        }
    }
    @Test
    @Ignore
    public void assertExistenceForToolsDialog()
    {
        onView(withId(R.id.btn_bottom_tools))
                .perform(click());
        try {
            onView(withId(R.id.btn_bottom_tools)).check(matches(isDisplayed()));
            onView(withId(R.id.tool_button_text)).check(matches(isDisplayed()));
        } catch (NoMatchingViewException e) {
        }
    }

    @Test
    @Ignore
    public void assertNoNullValuesForToolsDialog()
    {
        onView(withId(R.id.btn_bottom_tools))
                .perform(click());
        onView(allOf(withId(R.id.tool_button_image), hasSibling(
                withText(R.string.button_brush)))).check(matches(notNullValue()));
        onView(allOf(withId(R.id.tool_button_image), hasSibling(
                withText(R.string.button_resize)))).check(matches(notNullValue()));
        onView(allOf(withId(R.id.tool_button_image), hasSibling(
                withText(R.string.button_cursor)))).check(matches(notNullValue()));
        onView(allOf(withId(R.id.tool_button_image), hasSibling(
                withText(R.string.button_ellipse)))).check(matches(notNullValue()));
        onView(allOf(withId(R.id.tool_button_image), hasSibling(
                withText(R.string.button_fill)))).check(matches(notNullValue()));
        onView(allOf(withId(R.id.tool_button_image), hasSibling(
                withText(R.string.button_fill)))).check(matches(notNullValue()));
        onView(allOf(withId(R.id.tool_button_image), hasSibling(
                withText(R.string.button_line)))).check(matches(notNullValue()));
    }

    @Test
    @Ignore
    public void assertNoEllipseizedForToolsDialog()
    {
        onView(withId(R.id.btn_bottom_tools))
                .perform(click());
        onView(allOf(withId(R.id.tool_button_image), hasSibling(
                withText(R.string.button_brush)))).check(noEllipsizedText());
        onView(allOf(withId(R.id.tool_button_image), hasSibling(
                withText(R.string.button_ellipse)))).check(noEllipsizedText());
        onView(allOf(withId(R.id.tool_button_image), hasSibling(
                withText(R.string.button_fill)))).check(noEllipsizedText());
        onView(allOf(withId(R.id.tool_button_image), hasSibling(
                withText(R.string.button_line)))).check(noEllipsizedText());
        onView(allOf(withId(R.id.tool_button_image), hasSibling(
                withText(R.string.button_cursor)))).check(noEllipsizedText());
        onView(allOf(withId(R.id.tool_button_image), hasSibling(
                withText(R.string.button_import_image)))).check(noEllipsizedText());
        onView(allOf(withId(R.id.tool_button_image), hasSibling(
                withText(R.string.button_resize)))).check(noEllipsizedText());
    }

    @Test
    @Ignore
    public void assertCompletelyDisplayedForToolsDialog()
    {
        onView(withId(R.id.btn_bottom_tools))
                .perform(click());
        onView(allOf(withId(R.id.tool_button_image), hasSibling(
                withText(R.string.button_brush)))).check(matches(isCompletelyDisplayed()));
        onView(allOf(withId(R.id.tool_button_image), hasSibling(
                withText(R.string.button_ellipse)))).check(matches(isCompletelyDisplayed()));
        onView(allOf(withId(R.id.tool_button_image), hasSibling(
                withText(R.string.button_fill)))).check(matches(isCompletelyDisplayed()));
        onView(allOf(withId(R.id.tool_button_image), hasSibling(
                withText(R.string.button_line)))).check(matches(isCompletelyDisplayed()));
        onView(allOf(withId(R.id.tool_button_image), hasSibling(
                withText(R.string.button_cursor)))).check(matches(isCompletelyDisplayed()));
        onView(allOf(withId(R.id.tool_button_image), hasSibling(
                withText(R.string.button_import_image)))).check(matches(isCompletelyDisplayed()));
        onView(allOf(withId(R.id.tool_button_image), hasSibling(
                withText(R.string.button_resize)))).check(matches(isCompletelyDisplayed()));
    }


    public void changeLanguageBeforeStartTesting()
    {
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.menu_language_settings)).perform(click());
        onView(withId(R.id.ar)).perform(click());
    }

    @Test
    @Ignore
    public void takeScreenShot() {
        onView(withId(R.id.btn_bottom_tools))
                .perform(click());
        takeScreenshot("screenshot-001",getActivity());
        Log.d(TAG,"##### screenshot taken...");
    }

    public static void takeScreenshot(String name,Activity activity)
    {
        // Screenshots are always stored under /Pictures folder
        String path =
                Environment.getExternalStorageDirectory().getAbsolutePath().toString() + "/Pictures/" + name + ".png";
        Log.d(TAG,"##### screenshot path: " +path);
        View scrScreenshotView = activity.getWindow().getDecorView().getRootView();
        scrScreenshotView.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(scrScreenshotView.getDrawingCache());
        scrScreenshotView.setDrawingCacheEnabled(false);

        OutputStream out = null;
        File imageFile = new File(path);

        try {
            out = new FileOutputStream(imageFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
        } catch (FileNotFoundException e) {
            // exception
        } catch (IOException e) {
            // exception
        } finally {

            try {
                if (out != null) {
                    out.close();
                }

            } catch (Exception exc) {
            }

        }
    }


    // name attribute is optional, provide an unique name for test
    // multiple parameters, uses Collection<Object[]>
    @Parameterized.Parameters(name = "testrun: {index} | lang-code: {0}")
    public static List<String> differentLanguages() {
        rtlLanguageCodes = Arrays.asList(InstrumentationRegistry.getContext().getResources().getStringArray(org.catrobat.paintroid.test.R.array.rtl_language_codes));
       List<String> languageCodes = Arrays.asList(InstrumentationRegistry.getContext().getResources().getStringArray(org.catrobat.paintroid.test.R.array.language_codes));

        for (String rtllang:rtlLanguageCodes) {
            Log.d(ViewsAssertionLocalizationTest.TAG, "#### rtl-lang-codes: "+rtllang);
        }

        for (String language:languageCodes) {
            Log.d(ViewsAssertionLocalizationTest.TAG, "#### lang-codes: "+language);
        }


        return languageCodes;
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


