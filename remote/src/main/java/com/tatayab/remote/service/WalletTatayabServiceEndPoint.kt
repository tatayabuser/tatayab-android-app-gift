package com.tatayab.remote.service


import com.tatayab.model.requests.*
import com.tatayab.model.responses.*
import com.tatayab.remote.util.Constants
import com.tatayab.remote.util.Constants.Companion.VERSION_1_0
import io.reactivex.Flowable
import retrofit2.http.*

interface WalletTatayabServiceEndPoint {
    @GET(VERSION_1_0.plus(Constants.MY_WALLET_END_POINT))
    fun getMyWallet(
    ): Flowable<WalletResponse>

    @GET(VERSION_1_0.plus(Constants.TRANSACTIONS_HISTORY_END_POINT))
    fun getAllTransactions(
    ): Flowable<TransactionsHistoryResponse>

    @POST(VERSION_1_0.plus(Constants.REDEEM_CODE_END_POINT))
    fun addRedeemCode(
        @Body mRedeemCodeRequest: RedeemCodeRequest
    ): Flowable<RedeemCodeResponse>

    @POST(VERSION_1_0.plus(Constants.INVITE_FRIEND_ENDPOINT))
    fun inviteFriend(
        @Body mInviteFriendRequest: InviteFriendRequest
    ): Flowable<InviteFriendResponse>

    @POST(VERSION_1_0.plus(Constants.CHECK_EARN_ENDPOINT))
    fun checkEarn(
        @Body mInviteFriendRequest: InviteFriendRequest
    ): Flowable<InviteFriendResponse>

    @GET(VERSION_1_0.plus(Constants.CHECK_CASH_BACK_ENDPOINT))
    fun checkCashBack(@Query("order_id") orderId:String): Flowable<CheckCashBackResponse>

}