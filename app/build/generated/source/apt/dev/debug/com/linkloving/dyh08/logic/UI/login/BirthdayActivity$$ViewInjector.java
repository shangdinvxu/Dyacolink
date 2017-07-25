// Generated code from Butter Knife. Do not modify!
package com.linkloving.dyh08.logic.UI.login;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class BirthdayActivity$$ViewInjector<T extends com.linkloving.dyh08.logic.UI.login.BirthdayActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624590, "field 'yearET'");
    target.yearET = finder.castView(view, 2131624590, "field 'yearET'");
    view = finder.findRequiredView(source, 2131624592, "field 'monthET'");
    target.monthET = finder.castView(view, 2131624592, "field 'monthET'");
    view = finder.findRequiredView(source, 2131624594, "field 'dayET'");
    target.dayET = finder.castView(view, 2131624594, "field 'dayET'");
    view = finder.findRequiredView(source, 2131623994, "field 'left'");
    target.left = finder.castView(view, 2131623994, "field 'left'");
    view = finder.findRequiredView(source, 2131623995, "field 'right'");
    target.right = finder.castView(view, 2131623995, "field 'right'");
  }

  @Override public void reset(T target) {
    target.yearET = null;
    target.monthET = null;
    target.dayET = null;
    target.left = null;
    target.right = null;
  }
}
