// Generated code from Butter Knife. Do not modify!
package com.linkloving.dyh08.logic.UI.main;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class PortalActivity$$ViewInjector<T extends com.linkloving.dyh08.logic.UI.main.PortalActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624736, "field 'userLinerLayout' and method 'setUserLinerLayout'");
    target.userLinerLayout = finder.castView(view, 2131624736, "field 'userLinerLayout'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setUserLinerLayout(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624733, "field 'drawer'");
    target.drawer = finder.castView(view, 2131624733, "field 'drawer'");
    view = finder.findRequiredView(source, 2131624758, "field 'toolbar'");
    target.toolbar = finder.castView(view, 2131624758, "field 'toolbar'");
    view = finder.findRequiredView(source, 2131624737, "field 'menu_RecyclerView'");
    target.menu_RecyclerView = finder.castView(view, 2131624737, "field 'menu_RecyclerView'");
    view = finder.findRequiredView(source, 2131624244, "field 'user_head'");
    target.user_head = finder.castView(view, 2131624244, "field 'user_head'");
    view = finder.findRequiredView(source, 2131624606, "field 'user_name'");
    target.user_name = finder.castView(view, 2131624606, "field 'user_name'");
    view = finder.findRequiredView(source, 2131624746, "field 'stepLayout' and method 'stepLayout'");
    target.stepLayout = finder.castView(view, 2131624746, "field 'stepLayout'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.stepLayout(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624748, "field 'caloriesLayout' and method 'caloriesLayout'");
    target.caloriesLayout = finder.castView(view, 2131624748, "field 'caloriesLayout'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.caloriesLayout(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624753, "field 'sleepLayout' and method 'sleepLayout'");
    target.sleepLayout = finder.castView(view, 2131624753, "field 'sleepLayout'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.sleepLayout(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624750, "field 'distanceLayout' and method 'distanceLayout'");
    target.distanceLayout = finder.castView(view, 2131624750, "field 'distanceLayout'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.distanceLayout(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624827, "field 'main_tv_hour'");
    target.main_tv_hour = finder.castView(view, 2131624827, "field 'main_tv_hour'");
    view = finder.findRequiredView(source, 2131624828, "field 'main_tv_day'");
    target.main_tv_day = finder.castView(view, 2131624828, "field 'main_tv_day'");
    view = finder.findRequiredView(source, 2131624747, "field 'stepView'");
    target.stepView = finder.castView(view, 2131624747, "field 'stepView'");
    view = finder.findRequiredView(source, 2131624749, "field 'calView'");
    target.calView = finder.castView(view, 2131624749, "field 'calView'");
    view = finder.findRequiredView(source, 2131624751, "field 'distanceView'");
    target.distanceView = finder.castView(view, 2131624751, "field 'distanceView'");
    view = finder.findRequiredView(source, 2131624754, "field 'sleepView'");
    target.sleepView = finder.castView(view, 2131624754, "field 'sleepView'");
    view = finder.findRequiredView(source, 2131624752, "field 'distanceUnit'");
    target.distanceUnit = finder.castView(view, 2131624752, "field 'distanceUnit'");
    view = finder.findRequiredView(source, 2131624759, "method 'setTitleRightButton'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setTitleRightButton(p0);
        }
      });
  }

  @Override public void reset(T target) {
    target.userLinerLayout = null;
    target.drawer = null;
    target.toolbar = null;
    target.menu_RecyclerView = null;
    target.user_head = null;
    target.user_name = null;
    target.stepLayout = null;
    target.caloriesLayout = null;
    target.sleepLayout = null;
    target.distanceLayout = null;
    target.main_tv_hour = null;
    target.main_tv_day = null;
    target.stepView = null;
    target.calView = null;
    target.distanceView = null;
    target.sleepView = null;
    target.distanceUnit = null;
  }
}
