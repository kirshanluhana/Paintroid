package org.catrobat.paintroid.test.integration.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Environment;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import org.catrobat.paintroid.MainActivity;
import org.catrobat.paintroid.MultilanguageActivity;
import org.catrobat.paintroid.R;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.assertion.LayoutAssertions.noEllipsizedText;
import static android.support.test.espresso.assertion.LayoutAssertions.noMultilineButtons;
import static android.support.test.espresso.assertion.LayoutAssertions.noOverlaps;
import static android.support.test.espresso.assertion.PositionAssertions.isRightOf;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by Aiman Ayyal Awwad on 10/29/2015.
 */
//@RunWith(AndroidJUnit4.class)
@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ViewsAssertionLocalizationTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private static MainActivity mActivity;

    public static final String TAG = "PAINTROID.ESPRESSO";

    private String testLanguage = null;

    public ViewsAssertionLocalizationTest(String testLanguage) {

        super(MainActivity.class);
        this.testLanguage = testLanguage;
        Log.d(ViewsAssertionLocalizationTest.TAG, "### constructor ViewsAssertionLocalizationTest() executed: ");

    }

    @Before
     public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        mActivity = getActivity();

// either change language programatically in setUp()
// which is done for every test method execution
//            Locale mLocale = new Locale(testLanguage);
//            Locale.setDefault(mLocale);
//            Context context = mActivity.getApplicationContext();
//            Resources resources = context.getResources();
//            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
//            Configuration conf = resources.getConfiguration();
//            conf.locale = mLocale;
//            conf.setLayoutDirection(mLocale);
//            resources.updateConfiguration(conf, displayMetrics);

    }

    // ... or force test runner to use a certain order of tests, e.g., ascending names
    // so then it is possible to simulate a language change with Espresso framework
    // as the first testCase which is executed and this setting will stay over the lifespan
    // of the test.
    @Test
    public void assertArabicLanguageIsSet() {
        onView(withId(R.id.main_layout)).check(matches(isDisplayed()));
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.menu_language_settings)).perform(click());
        //onView(withId(R.id.ar)).perform(click());
        //onView(withId(testLanguage)).perform(click());
        int resId = mActivity.getResources().getIdentifier(testLanguage, "id", mActivity.getApplicationContext().getPackageName());
        Log.d("PTest:","getIdentifierByName: "+resId);
        onView(withId(resId)).perform(click());
    }

    @Test
    public void assertNoOverlappingForLineStrokeDialog()
    {

        onView(withId(R.id.btn_bottom_attribute1))
                .perform(click());
        onView(withId(R.id.linearlayout1)).check(noOverlaps());
    }

    @Test
     public void assertNoOverlappingForColorPalletDialog()
    {
        onView(withId(R.id.btn_bottom_attribute2))
                .perform(click());
        onView(isRoot()).check(noOverlaps());
    }

    @Test
    public void assertNoOverlappingForToolsDialog()
    {
        onView(withId(R.id.btn_bottom_tools))
                .perform(click());
        onView(withId(R.id.gridview_tools_menu)).check(noOverlaps());
    }

    @Test
    public void assertNoOverLappingForMainActivity()
    {
        onView(withId(R.id.main_layout)).check(noOverlaps());

    }
    @Test
    public void assertNoEllipseizedTextInToolsDialog() {
        onView(withId(R.id.btn_bottom_tools))
                .perform(click());
        onView(withId(R.id.gridview_tools_menu)).check(noEllipsizedText());
    }

    @Test
    public void assertNoEllipseizedTextInStrokeLineDialog()
    {
        onView(withId(R.id.btn_bottom_attribute1))
                .perform(click());
        onView(withId(R.id.stroke_width_shape_text)).check(noEllipsizedText());
    }

    @Test
    public void assertNoEllipseizedTextInColorPallet()
    {
        onView(withId(R.id.btn_bottom_attribute2))
                .perform(click());
        onView(withId(R.id.colorchooser_base_layout)).check(noEllipsizedText());
    }
   @Test
   public void assertNoEllipseizedMainActivity()
   {
       onView(withId(R.id.main_layout)).check(noEllipsizedText());
   }

    @Test
    public void assertIsDisplayedTextForToolsText() {
        onView(withId(R.id.btn_bottom_tools))
                .perform(click());
        onView(withId(R.id.gridview_tools_menu)).check(matches(isDisplayed()));
    }

   @Test
   public void assertIsDisplayedForColorPalletDialog()
   {
    onView(withId(R.id.btn_bottom_attribute2))
            .perform(click());
       onView(withId(R.id.view_colorpicker)).check(matches(isDisplayed()));
   }

    @Test
    public void assertIsDisplayedForStrokeLineDialog()
    {
        onView(withId(R.id.btn_bottom_attribute1))
                .perform(click());
        onView(withId(R.id.stroke_width_shape_text)).check(matches(isDisplayed()));
    }

    @Test
    public void assertNoMultilineButtons() {
        onView(withId(R.id.btn_bottom_tools))
                .perform(click());
        onView(withId(R.id.gridview_tools_menu)).check(noMultilineButtons());
    }


    @Test
    public void assertSeekBarIsRightOfValue() {
        onView(withId(R.id.btn_bottom_attribute1))
                .perform(click());
        onView(withId(R.id.stroke_width_seek_bar)).check(isRightOf(withId(R.id.stroke_width_width_text)));
    }

    @Test
    public void assertSwippingRightforStrokeSeekbar()
    {
        onView(withId(R.id.btn_bottom_attribute1))
                .perform(click());
        onView(withId(R.id.stroke_width_seek_bar)).perform(swipeRight());
    }
    @Test
    public void assertToolsRightOfText()
    {
        onView(withId(R.id.btn_bottom_tools))
                .perform(click());
        onView(allOf(withId(R.id.tool_button_image), hasSibling(
                                                         withText(R.string.button_brush))))
        .check(isRightOf(allOf(withId(R.id.tool_button_text), hasSibling(
                withText(R.string.button_brush)))));
    }
    @Test
    public void assertExistanceForToolsDialog()
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
    public void assertTakeScreenShots() {
        onView(withId(R.id.btn_bottom_tools))
                .perform(click());
        takeScreenshot("screenshot-001",getActivity());
    }

    public static void takeScreenshot(String name,Activity activity)
    {
        // Screenshots are always stored under /Pictures folder
        String path =
                Environment.getExternalStorageDirectory().getAbsolutePath().toString() + "/Pictures/" + name + ".png";
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
    @Parameterized.Parameters(name = "language {index}: {0}")
    public static List<String> differentLanguages() {
        return Arrays.asList(new String[]{"ar", "de", "en"});
    }
}


