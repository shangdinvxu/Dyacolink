// Generated code from Butter Knife. Do not modify!
package com.linkloving.dyh08.logic.UI.HeartRate;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class HeartRateActivity$$ViewInjector<T extends com.linkloving.dyh08.logic.UI.HeartRate.HeartRateActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624789, "field 'groupsTime'");
    target.groupsTime = finder.castView(view, 2131624789, "field 'groupsTime'");
    view = finder.findRequiredView(source, 2131624809, "field 'HeartrateDay'");
    target.HeartrateDay = finder.castView(view, 2131624809, "field 'HeartrateDay'");
    view = finder.findRequiredView(source, 2131624810, "field 'HeartrateWeek'");
    target.HeartrateWeek = finder.castView(view, 2131624810, "field 'HeartrateWeek'");
    view = finder.findRequiredView(source, 2131624811, "field 'HeartrateMonth'");
    target.HeartrateMonth = finder.castView(view, 2131624811, "field 'HeartrateMonth'");
    view = finder.findRequiredView(source, 2131624808, "field 'twHeartrateButtom'");
    target.twHeartrateButtom = finder.castView(view, 2131624808, "field 'twHeartrateButtom'");
    view = finder.findRequiredView(source, 2131624805, "field 'restingText'");
    target.restingText = finder.castView(view, 2131624805, "field 'restingText'");
    view = finder.findRequiredView(source, 2131624806, "field 'avgerageText'");
    target.avgerageText = finder.castView(view, 2131624806, "field 'avgerageText'");
    view = finder.findRequiredView(source, 2131624807, "field 'middleFramelayout'");
    target.middleFramelayout = finder.castView(view, 2131624807, "field 'middleFramelayout'");
  }

  @Override public void reset(T target) {
    target.groupsTime = null;
    target.HeartrateDay = null;
    target.HeartrateWeek = null;
    target.HeartrateMonth = null;
    target.twHeartrateButtom = null;
    target.restingText = null;
    target.avgerageText = null;
    target.middleFramelayout = null;
  }
}
