// Generated code from Butter Knife. Do not modify!
package com.linkloving.dyh08.logic.UI.login;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class WeightNewActivity$$ViewInjector<T extends com.linkloving.dyh08.logic.UI.login.WeightNewActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624757, "field 'weightRulerView'");
    target.weightRulerView = finder.castView(view, 2131624757, "field 'weightRulerView'");
    view = finder.findRequiredView(source, 2131624136, "field 'weight'");
    target.weight = finder.castView(view, 2131624136, "field 'weight'");
    view = finder.findRequiredView(source, 2131623994, "field 'left'");
    target.left = finder.castView(view, 2131623994, "field 'left'");
    view = finder.findRequiredView(source, 2131623995, "field 'right'");
    target.right = finder.castView(view, 2131623995, "field 'right'");
  }

  @Override public void reset(T target) {
    target.weightRulerView = null;
    target.weight = null;
    target.left = null;
    target.right = null;
  }
}
