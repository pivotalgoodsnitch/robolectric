package org.robolectric.tester.android.view;

import android.app.ActionBar;
import android.app.Activity;
import android.widget.TextView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.TestRunners;
import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(TestRunners.WithDefaults.class)
public class RoboActionBarTest {

  private final RoboActionBar actionBar = new RoboActionBar();

  @Test
  public void shouldSetTheCustomView() throws Exception {
    TextView textView = new TextView(new Activity());
    actionBar.setCustomView(textView);
    assertThat(actionBar.getCustomView()).isSameAs(textView);
  }

  @Test
  public void setDisplayShowCustomEnabled_shouldWork() throws Exception {
    assertThat(actionBar.getDisplayOptions() & ActionBar.DISPLAY_SHOW_CUSTOM).isEqualTo(0);
    actionBar.setDisplayShowCustomEnabled(true);
    assertThat(actionBar.getDisplayOptions() & ActionBar.DISPLAY_SHOW_CUSTOM).isEqualTo(ActionBar.DISPLAY_SHOW_CUSTOM);
    actionBar.setDisplayShowCustomEnabled(false);
    assertThat(actionBar.getDisplayOptions() & ActionBar.DISPLAY_SHOW_CUSTOM).isEqualTo(0);
  }

  @Test
  public void setDisplayShowTitleEnabled_shouldWork() throws Exception {
    assertThat(actionBar.getDisplayOptions() & ActionBar.DISPLAY_SHOW_TITLE).isEqualTo(ActionBar.DISPLAY_SHOW_TITLE);
    actionBar.setDisplayShowTitleEnabled(false);
    assertThat(actionBar.getDisplayOptions() & ActionBar.DISPLAY_SHOW_TITLE).isEqualTo(0);
    actionBar.setDisplayShowTitleEnabled(true);
    assertThat(actionBar.getDisplayOptions() & ActionBar.DISPLAY_SHOW_TITLE).isEqualTo(ActionBar.DISPLAY_SHOW_TITLE);
  }

  @Test
  public void setTitle_shouldSetTheActionBarTitle() throws Exception {
    actionBar.setTitle("Title");
    assertThat(actionBar.getTitle()).isEqualTo("Title");
  }
}