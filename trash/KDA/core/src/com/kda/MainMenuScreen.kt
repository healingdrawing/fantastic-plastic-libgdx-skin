package com.kda

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.*

import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack.getViewport

import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox.CheckBoxStyle

import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane.ScrollPaneStyle


import com.badlogic.gdx.scenes.scene2d.ui.List as UIList
import com.badlogic.gdx.utils.Array as UIArray
import com.badlogic.gdx.scenes.scene2d.ui.List.ListStyle
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox.SelectBoxStyle
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar.ProgressBarStyle
import com.badlogic.gdx.scenes.scene2d.ui.Slider.SliderStyle
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad.TouchpadStyle
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane.SplitPaneStyle




class MainMenuScreen(private var game: KDA) : ScreenAdapter() {
    private val stage: Stage = Stage(FitViewport(game.screenWidth, game.screenHeight))
    private var table:Table? = null

    private var eng_button:TextButton? = null
    private val eng_style: TextButtonStyle = TextButtonStyle()

    private  var eng_cbox: CheckBox? = null
    private val eng_cbox_style: CheckBoxStyle = CheckBoxStyle()

    private  var eng_label: Label? = null
    private val eng_label_style: LabelStyle = LabelStyle()

    private  var eng_textfield: TextField? = null
    private val eng_textfield_style: TextFieldStyle = TextFieldStyle()
    private  var eng_textarea:TextArea? = null

    private  var scroll:ScrollPane? = null
    private  val scroll_style: ScrollPaneStyle = ScrollPaneStyle()

    private  var listArray:UIArray<String> = UIArray()
    private var list:UIList<String>? = null
    private  val list_style:ListStyle = ListStyle()

    private  var selectboxArray:UIArray<String> = UIArray()
    private var selectbox:SelectBox<String>? = null
    private val selectbox_style:SelectBoxStyle = SelectBoxStyle()

    private var progress:ProgressBar? = null
    private var progressv:ProgressBar? = null
    private val progress_style:ProgressBarStyle = ProgressBarStyle()

    private  var slider:Slider? = null
    private  var sliderv:Slider? = null
    private val slider_style:SliderStyle = SliderStyle()

    private var window:Window? = null
    private val window_style:WindowStyle = WindowStyle()

    private var touchpad:Touchpad? = null
    private val touchpad_style:TouchpadStyle = TouchpadStyle()

    private var splitpane:SplitPane? = null
    private  val splitpane_style:SplitPaneStyle = SplitPaneStyle()

    private var chn_button:TextButton? = null
    private var jap_button:TextButton? = null
    private var kor_button:TextButton? = null

    override fun show() {
//        super.show()
//        stage = Stage(FitViewport(game.screenWidth, game.screenHeight))
//        Gdx.input.setInputProcessor(stage)
        Gdx.input.inputProcessor = stage
//        stage.isDebugAll = true
        table = Table(game.uiskin)
        table!!.setSize(game.screenWidth, game.screenHeight)

        eng_button = TextButton("", game.uiskin, "fap")
        eng_button!!.style.font = game.uiskin.get("chn-64", BitmapFont::class.java)
        eng_button!!.setText("测试按钮")

        eng_cbox = CheckBox("",game.uiskin, "fap")
        eng_cbox!!.style.font = game.uiskin.get("chn-64", BitmapFont::class.java)
        eng_cbox!!.setText("测试按钮")

        eng_label = Label("", game.uiskin, "fap")
        eng_label!!.style.font = game.uiskin.get("chn-64", BitmapFont::class.java)
        eng_label!!.setText("测试按钮\n" +
                "测试按钮测试按钮测试按钮测试按钮\n" +
                "测试按钮测试按钮测试按钮测试按钮\n" +
                "测试按钮测试按钮测试按钮测试按钮\n" +
                "测试按钮测试按钮测试按钮测试按钮\n" +
                "测试按钮测试按钮测试按钮测试按钮\n" +
                "测试按钮测试按钮测试按钮测试按钮\n" +
                "测试按钮\n" +
                "测试按钮\n" +
                "测试按钮\n" +
                "测试按钮\n" +
                "测试按钮\n" +
                "测试按钮\n" +
                "测试按钮\n" +
                "测试按钮\n" +
                "测试按钮\n" +
                "测试按钮\n" +
                "测试按钮")

        eng_textfield = TextField("test", game.uiskin, "fap")
//        eng_textfield!!.style.font = game.uiskin.get("chn-64", BitmapFont::class.java)
//        eng_textfield!!.style.fontColor = Color.WHITE

        eng_textarea = TextArea("test\ntestt\ntesttt",game.uiskin, "fap")
//        eng_textarea!!.setPrefRows(4f)
//        eng_textarea!!.style.font = game.uiskin.get("chn-64", BitmapFont::class.java)

        scroll = ScrollPane(eng_label, game.uiskin, "fap")

        list = UIList(game.uiskin, "fap")
//        list!!.style.font = game.uiskin.get("chn-64", BitmapFont::class.java)
        listArray.add(
                "testttt",
                "testtttt",
                "testttttt",
                "testtttttt"
        )
        list!!.setItems(listArray)

        selectboxArray.add(
                "testttt",
                "testtttt",
                "testttttt",
                "testtttttt"
        )

        selectbox = SelectBox(game.uiskin, "fap")
        selectbox!!.setItems(selectboxArray)
//        selectbox!!.style.font = game.uiskin.get("chn-64", BitmapFont::class.java)
        selectbox!!.maxListCount = 3

        progress = ProgressBar(0f,5f,1f,false,game.uiskin, "fap")
        progress!!.value = 1f

        progressv = ProgressBar(0f,5f,1f,true,game.uiskin, "fap")
        progressv!!.value = 4f

        slider = Slider(0f,10f,1f,false,game.uiskin, "fap")

        sliderv = Slider(0f,10f,1f,true,game.uiskin, "fap")

        touchpad = Touchpad(40f, game.uiskin, "fap")

        splitpane = SplitPane(progress, slider, false, game.uiskin, "fap")

        window = Window("test test test",game.uiskin, "fap")

//        table!!.add(eng_label).expandX().expandY()//.fillX().fillY() //used in scroll

        table!!.add(eng_button).expandX().expandY()//.fillX().fillY()
        table!!.add(selectbox).expandX().expandY()
        table!!.add(eng_textfield).expandX().expandY().fillX()
        table!!.row()
        table!!.add(eng_cbox).expandX().expandY()//.fillX().fillY()

//        table!!.add(progress).expandX().expandY()
//        table!!.add(slider).expandX().expandY().fill() //used in splitpane

        table!!.row()
        table!!.add(touchpad)
        table!!.add(scroll).expandX().expandY()//.fillX().fillY()
        table!!.add(list).expandX().expandY()
        table!!.add(progressv).expandX().expandY()
        table!!.add(sliderv).expandX().expandY().fill()

//        table!!.add(eng_textarea).expandX().expandY()//.fillX().fillY() //BUGGED

        table!!.row()
        table!!.add(splitpane).expand().fill()

        window!!.setFillParent(true)
        window!!.add(table).expand().fill()
        window!!.titleLabel.setAlignment(-1)
        window!!.pad(10f)
        window!!.padTop(68f) //work
        stage.addActor(window)
//        stage.addActor(table)

    }

    override fun resize(width: Int, height: Int) {
        stage.viewport.update(width, height, true)
    }

    override fun render(delta: Float) {
        super.render(delta)
        Gdx.gl.glClearColor(0f, 0.5f, 0.5f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        stage.act(delta);
        stage.draw();
    }
}