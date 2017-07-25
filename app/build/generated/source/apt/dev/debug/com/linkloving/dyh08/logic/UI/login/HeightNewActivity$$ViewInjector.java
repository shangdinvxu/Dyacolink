// Generated code from Butter Knife. Do not modify!
package com.linkloving.dyh08.logic.UI.login;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class HeightNewActivity$$ViewInjector<T extends com.linkloving.dyh08.logic.UI.login.HeightNewActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624743, "field 'heightRulerView'");
    target.heightRulerView = finder.castView(view, 2131624743, "field 'heightRulerView'");
    view = finder.findRequiredView(source, 2131624133, "field 'height'");
    target.height = finder.castView(view, 2131624133, "field 'height'");
    view = finder.findRequiredView(source, 2131623994, "field 'left'");
    target.left = finder.castView(view, 2131623994, "field 'left'");
    view = finder.findRequiredView(source, 2131623995, "field 'right'");
    target.right = finder.castView(view, 2131623995, "field 'right'");
  }

  @Override public void reset(T target) {
    target.heightRulerView = null;
    target.height = null;
    target.left = null;
    target.right = null;
  }
}
