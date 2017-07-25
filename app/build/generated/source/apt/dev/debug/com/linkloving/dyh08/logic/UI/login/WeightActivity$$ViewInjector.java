// Generated code from Butter Knife. Do not modify!
package com.linkloving.dyh08.logic.UI.login;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class WeightActivity$$ViewInjector<T extends com.linkloving.dyh08.logic.UI.login.WeightActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624610, "field 'weightBar'");
    target.weightBar = finder.castView(view, 2131624610, "field 'weightBar'");
    view = finder.findRequiredView(source, 2131623994, "field 'left'");
    target.left = finder.castView(view, 2131623994, "field 'left'");
    view = finder.findRequiredView(source, 2131623995, "field 'right'");
    target.right = finder.castView(view, 2131623995, "field 'right'");
    view = finder.findRequiredView(source, 2131624611, "field 'weightTV'");
    target.weightTV = finder.castView(view, 2131624611, "field 'weightTV'");
  }

  @Override public void reset(T target) {
    target.weightBar = null;
    target.left = null;
    target.right = null;
    target.weightTV = null;
  }
}
