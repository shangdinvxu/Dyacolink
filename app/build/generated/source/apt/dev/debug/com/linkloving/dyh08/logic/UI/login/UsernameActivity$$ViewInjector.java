// Generated code from Butter Knife. Do not modify!
package com.linkloving.dyh08.logic.UI.login;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class UsernameActivity$$ViewInjector<T extends com.linkloving.dyh08.logic.UI.login.UsernameActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624606, "field 'userName'");
    target.userName = finder.castView(view, 2131624606, "field 'userName'");
    view = finder.findRequiredView(source, 2131624142, "field 'next'");
    target.next = finder.castView(view, 2131624142, "field 'next'");
  }

  @Override public void reset(T target) {
    target.userName = null;
    target.next = null;
  }
}
