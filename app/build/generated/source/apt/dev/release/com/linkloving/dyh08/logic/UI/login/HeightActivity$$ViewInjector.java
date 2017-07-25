// Generated code from Butter Knife. Do not modify!
package com.linkloving.dyh08.logic.UI.login;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class HeightActivity$$ViewInjector<T extends com.linkloving.dyh08.logic.UI.login.HeightActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624602, "field 'heightBar'");
    target.heightBar = finder.castView(view, 2131624602, "field 'heightBar'");
    view = finder.findRequiredView(source, 2131623994, "field 'left'");
    target.left = finder.castView(view, 2131623994, "field 'left'");
    view = finder.findRequiredView(source, 2131623995, "field 'right'");
    target.right = finder.castView(view, 2131623995, "field 'right'");
    view = finder.findRequiredView(source, 2131624603, "field 'heightTV'");
    target.heightTV = finder.castView(view, 2131624603, "field 'heightTV'");
  }

  @Override public void reset(T target) {
    target.heightBar = null;
    target.left = null;
    target.right = null;
    target.heightTV = null;
  }
}
