// Generated code from Butter Knife. Do not modify!
package com.linkloving.dyh08.logic.UI.step;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class StepActivity$$ViewInjector<T extends com.linkloving.dyh08.logic.UI.step.StepActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624873, "field 'step_button_day_im'");
    target.step_button_day_im = finder.castView(view, 2131624873, "field 'step_button_day_im'");
    view = finder.findRequiredView(source, 2131624874, "field 'step_button_week_im'");
    target.step_button_week_im = finder.castView(view, 2131624874, "field 'step_button_week_im'");
    view = finder.findRequiredView(source, 2131624875, "field 'step_button_month_im'");
    target.step_button_month_im = finder.castView(view, 2131624875, "field 'step_button_month_im'");
    view = finder.findRequiredView(source, 2131624876, "field 'step_button_year_im'");
    target.step_button_year_im = finder.castView(view, 2131624876, "field 'step_button_year_im'");
    view = finder.findRequiredView(source, 2131624770, "field 'step_tv_date'");
    target.step_tv_date = finder.castView(view, 2131624770, "field 'step_tv_date'");
    view = finder.findRequiredView(source, 2131624776, "field 'stepCircleView'");
    target.stepCircleView = finder.castView(view, 2131624776, "field 'stepCircleView'");
    view = finder.findRequiredView(source, 2131624779, "field 'step_number'");
    target.step_number = finder.castView(view, 2131624779, "field 'step_number'");
    view = finder.findRequiredView(source, 2131624729, "field 'goalTv'");
    target.goalTv = finder.castView(view, 2131624729, "field 'goalTv'");
    view = finder.findRequiredView(source, 2131624500, "field 'stepTV'");
    target.stepTV = finder.castView(view, 2131624500, "field 'stepTV'");
  }

  @Override public void reset(T target) {
    target.step_button_day_im = null;
    target.step_button_week_im = null;
    target.step_button_month_im = null;
    target.step_button_year_im = null;
    target.step_tv_date = null;
    target.stepCircleView = null;
    target.step_number = null;
    target.goalTv = null;
    target.stepTV = null;
  }
}
