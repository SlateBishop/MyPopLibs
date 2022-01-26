package ru.gb.makulin.mypoplibs

class MainPresenter(
    private val view: MainView
) {

    private val model = CountersModel()

    fun counterClick(id: Int) {
        when (id) {
            Button.FIRST.id -> {
                val nextValue = model.increment(0)
                view.setButtonText(0, nextValue.toString())
            }
            Button.SECOND.id -> {
                val nextValue = model.increment(1)
                view.setButtonText(1, nextValue.toString())
            }
            Button.THIRD.id -> {
                val nextValue = model.increment(2)
                view.setButtonText(2, nextValue.toString())
            }
            Button.ERR.id -> error("wrong view")
        }
    }
}