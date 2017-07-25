// Generated code from Butter Knife. Do not modify!
package com.linkloving.dyh08.logic.UI.Social;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class SocialActivity$$ViewInjector<T extends com.linkloving.dyh08.logic.UI.Social.SocialActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624789, "field 'groupsTime'");
    target.groupsTime = finder.castView(view, 2131624789, "field 'groupsTime'");
    view = finder.findRequiredView(source, 2131624790, "field 'groupsTvStep'");
    target.groupsTvStep = finder.castView(view, 2131624790, "field 'groupsTvStep'");
    view = finder.findRequiredView(source, 2131624746, "field 'RlStep' and method 'sendDB'");
    target.RlStep = finder.castView(view, 2131624746, "field 'RlStep'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.sendDB(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624791, "field 'groupsTvCalories'");
    target.groupsTvCalories = finder.castView(view, 2131624791, "field 'groupsTvCalories'");
    view = finder.findRequiredView(source, 2131624748, "field 'RlCalories' and method 'sendTxt'");
    target.RlCalories = finder.castView(view, 2131624748, "field 'RlCalories'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.sendTxt(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624792, "field 'groupsTvDistance'");
    target.groupsTvDistance = finder.castView(view, 2131624792, "field 'groupsTvDistance'");
    view = finder.findRequiredView(source, 2131624750, "field 'RlDistance'");
    target.RlDistance = finder.castView(view, 2131624750, "field 'RlDistance'");
    view = finder.findRequiredView(source, 2131624793, "field 'mainTvDuration'");
    target.mainTvDuration = finder.castView(view, 2131624793, "field 'mainTvDuration'");
    view = finder.findRequiredView(source, 2131624753, "field 'RlSleep'");
    target.RlSleep = finder.castView(view, 2131624753, "field 'RlSleep'");
    view = finder.findRequiredView(source, 2131624794, "field 'sharebutton'");
    target.sharebutton = finder.castView(view, 2131624794, "field 'sharebutton'");
    view = finder.findRequiredView(source, 2131624847, "field 'shareEditText'");
    target.shareEditText = finder.castView(view, 2131624847, "field 'shareEditText'");
    view = finder.findRequiredView(source, 2131624803, "field 'screenhot'");
    target.screenhot = finder.castView(view, 2131624803, "field 'screenhot'");
  }

  @Override public void reset(T target) {
    target.groupsTime = null;
    target.groupsTvStep = null;
    target.RlStep = null;
    target.groupsTvCalories = null;
    target.RlCalories = null;
    target.groupsTvDistance = null;
    target.RlDistance = null;
    target.mainTvDuration = null;
    target.RlSleep = null;
    target.sharebutton = null;
    target.shareEditText = null;
    target.screenhot = null;
  }
}
