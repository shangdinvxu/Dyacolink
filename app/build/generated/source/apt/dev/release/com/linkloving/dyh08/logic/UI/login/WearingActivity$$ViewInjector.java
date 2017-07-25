// Generated code from Butter Knife. Do not modify!
package com.linkloving.dyh08.logic.UI.login;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class WearingActivity$$ViewInjector<T extends com.linkloving.dyh08.logic.UI.login.WearingActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624607, "field 'lefthand'");
    target.lefthand = finder.castView(view, 2131624607, "field 'lefthand'");
    view = finder.findRequiredView(source, 2131624608, "field 'righthand'");
    target.righthand = finder.castView(view, 2131624608, "field 'righthand'");
    view = finder.findRequiredView(source, 2131623994, "field 'left'");
    target.left = finder.castView(view, 2131623994, "field 'left'");
    view = finder.findRequiredView(source, 2131623995, "field 'right'");
    target.right = finder.castView(view, 2131623995, "field 'right'");
  }

  @Override public void reset(T target) {
    target.lefthand = null;
    target.righthand = null;
    target.left = null;
    target.right = null;
  }
}
