// Generated code from Butter Knife. Do not modify!
package com.linkloving.dyh08.logic.UI.HeartRate;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class DayFragment$$ViewInjector<T extends com.linkloving.dyh08.logic.UI.HeartRate.DayFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624814, "field 'barchartview'");
    target.barchartview = finder.castView(view, 2131624814, "field 'barchartview'");
  }

  @Override public void reset(T target) {
    target.barchartview = null;
  }
}
