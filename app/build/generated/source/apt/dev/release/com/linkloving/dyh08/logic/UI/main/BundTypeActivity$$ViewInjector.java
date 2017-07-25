// Generated code from Butter Knife. Do not modify!
package com.linkloving.dyh08.logic.UI.main;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class BundTypeActivity$$ViewInjector<T extends com.linkloving.dyh08.logic.UI.main.BundTypeActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624151, "field 'recyclerView'");
    target.recyclerView = finder.castView(view, 2131624151, "field 'recyclerView'");
  }

  @Override public void reset(T target) {
    target.recyclerView = null;
  }
}
