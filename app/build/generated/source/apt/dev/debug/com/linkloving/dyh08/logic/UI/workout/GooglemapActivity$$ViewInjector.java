// Generated code from Butter Knife. Do not modify!
package com.linkloving.dyh08.logic.UI.workout;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class GooglemapActivity$$ViewInjector<T extends com.linkloving.dyh08.logic.UI.workout.GooglemapActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131623996, "field 'start'");
    target.start = finder.castView(view, 2131623996, "field 'start'");
    view = finder.findRequiredView(source, 2131624509, "field 'stop'");
    target.stop = finder.castView(view, 2131624509, "field 'stop'");
    view = finder.findRequiredView(source, 2131624469, "field 'OKBtn' and method 'setOKBtn'");
    target.OKBtn = finder.castView(view, 2131624469, "field 'OKBtn'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setOKBtn(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624510, "field 'firstMiddle'");
    target.firstMiddle = finder.castView(view, 2131624510, "field 'firstMiddle'");
    view = finder.findRequiredView(source, 2131624511, "field 'secondMiddle'");
    target.secondMiddle = finder.castView(view, 2131624511, "field 'secondMiddle'");
    view = finder.findRequiredView(source, 2131624512, "field 'chronometer'");
    target.chronometer = finder.castView(view, 2131624512, "field 'chronometer'");
  }

  @Override public void reset(T target) {
    target.start = null;
    target.stop = null;
    target.OKBtn = null;
    target.firstMiddle = null;
    target.secondMiddle = null;
    target.chronometer = null;
  }
}
