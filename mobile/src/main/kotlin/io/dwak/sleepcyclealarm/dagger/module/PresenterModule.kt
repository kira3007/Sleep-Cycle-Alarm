package io.dwak.sleepcyclealarm.dagger.module

import dagger.Module
import dagger.Provides
import io.dwak.sleepcyclealarm.base.mvp.PresenterView
import io.dwak.sleepcyclealarm.dagger.component.InteractorComponent
import io.dwak.sleepcyclealarm.ui.options.OptionsPresenterImpl
import io.dwak.sleepcyclealarm.presenter.OptionsPresenter
import io.dwak.sleepcyclealarm.presenter.WakeUpTimesPresenter
import io.dwak.sleepcyclealarm.ui.times.WakeUpTimesPresenterImpl
import io.dwak.sleepcyclealarm.util.PresenterCache
import io.dwak.sleepcyclealarm.view.OptionsView
import io.dwak.sleepcyclealarm.view.WakeUpTimesView

@Module
public open class PresenterModule(val view : PresenterView) {
    @Provides
    fun providesWakeUpTimePresenter(interactorComponent : InteractorComponent) : WakeUpTimesPresenter {
        return wakeUpTimesPresenter(view as WakeUpTimesView, interactorComponent)
    }

    @Provides
    fun providesOptionsPresenter(interactorComponent : InteractorComponent) : OptionsPresenter {
        return optionsPresenter(view as OptionsView, interactorComponent)
    }

    open fun wakeUpTimesPresenter(view : WakeUpTimesView, interactorComponent : InteractorComponent) : WakeUpTimesPresenter
            = (PresenterCache.getPresenter(view)?: WakeUpTimesPresenterImpl(view, interactorComponent)) as WakeUpTimesPresenterImpl

    open fun optionsPresenter(view : OptionsView, interactorComponent : InteractorComponent) : OptionsPresenter
            = (PresenterCache.getPresenter(view)?: OptionsPresenterImpl(view, interactorComponent)) as OptionsPresenterImpl
}