package jp.co.soramitsu.app.main.domain

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import jp.co.soramitsu.app.main.navigation.Destination
import jp.co.soramitsu.feature_account_api.domain.interfaces.AccountRepository

class MainInteractor(
    private val accountRepository: AccountRepository
) {

    fun getInitialDestination(): Single<Destination> {
        return accountRepository.isAccountSelected()
            .subscribeOn(Schedulers.io())
            .map(::determineInitialDestination)
            .observeOn(AndroidSchedulers.mainThread())
    }

    private fun determineInitialDestination(isAccountSelected: Boolean) =
        if (isAccountSelected) Destination.MAIN else Destination.ONBOARDING
}