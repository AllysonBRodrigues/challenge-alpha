package br.com.hu.allyson.desafiohu.mvp.presenter

import br.com.hu.allyson.desafiohu.domain.Hotels
import br.com.hu.allyson.desafiohu.domain.Result
import br.com.hu.allyson.desafiohu.mvp.interfaces.APIHotels
import br.com.hu.allyson.desafiohu.mvp.model.ModelHotels
import br.com.hu.allyson.desafiohu.network.NetworkHotels

class PresenterHotels : APIHotels.PresenterHotelsImpl{
    lateinit var view: APIHotels.ViewHotelsImpl
    lateinit var repository: NetworkHotels.HotelsRepositoryImpl
    lateinit var model: APIHotels.ModelHotelsImpl
    override fun bind(view: APIHotels.ViewHotelsImpl, repository: NetworkHotels.HotelsRepositoryImpl) {
        this.repository = repository
        this.view = view
        this.model = ModelHotels(repository, this)
    }

    override fun requestHotels() {
        model.requestHotels()
    }

    override fun requestHotelsStart() {
        requestHotels()
    }

    override fun requestHotelsSucess(result: Result) {
        view.requestHotelsSucess(result)
    }

    override fun requestHotelsError() {
        view.requestHotelsError()
    }

    override fun buildListHotels(result: Result): List<Hotels> {
        return result.results.filter { it.isHotel }.sortedByDescending { it.stars }
    }

    override fun buildListPackage(result: Result): List<Hotels> {
        return result.results.filter { it.isPackage }.sortedByDescending { it.stars }
    }
}