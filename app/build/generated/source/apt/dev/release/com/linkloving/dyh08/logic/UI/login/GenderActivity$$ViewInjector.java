// Generated code from Butter Knife. Do not modify!
package com.linkloving.dyh08.logic.UI.login;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class GenderActivity$$ViewInjector<T extends com.linkloving.dyh08.logic.UI.login.GenderActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624599, "field 'man'");
    target.man = finder.castView(view, 2131624599, "field 'man'");
    view = finder.findRequiredView(source, 2131624600, "field 'woman'");
    target.woman = finder.castView(view, 2131624600, "field 'woman'");
    view = finder.findRequiredView(source, 2131623994, "field 'left'");
    target.left = finder.castView(view, 2131623994, "field 'left'");
    view = finder.findRequiredView(source, 2131623995, "field 'right'");
    target.right = finder.castView(view, 2131623995, "field 'right'");
  }

  @Override public void reset(T target) {
    target.man = null;
    target.woman = null;
    target.left = null;
    target.right = null;
  }
}
