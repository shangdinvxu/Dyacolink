// Generated code from Butter Knife. Do not modify!
package com.linkloving.dyh08.logic.UI.login;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class LoginFinishActivity$$ViewInjector<T extends com.linkloving.dyh08.logic.UI.login.LoginFinishActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624787, "field 'link' and method 'finishLogin'");
    target.link = finder.castView(view, 2131624787, "field 'link'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.finishLogin(p0);
        }
      });
  }

  @Override public void reset(T target) {
    target.link = null;
  }
}
