package ru.gb.makulin.mypoplibs

class MainPresenter(
    private val view: MainView
) {

    private val model = CountersModel()

    fun counterClick(id: Int) {
        when (id) {
            Button.FIRST.id -> {
                val nextValue = model.increment(0)
                view.setFirstButtonText(nextValue.toString())
            }
            Button.SECOND.id -> {
                val nextValue = model.increment(1)
                view.setSecondButtonText(nextValue.toString())
            }
            Button.THIRD.id -> {
                val nextValue = model.increment(2)
                view.setThirdButtonText(nextValue.toString())
            }
            Button.ERR.id -> error("wrong view")
        }
    }
}