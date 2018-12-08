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

    private var chn_button:TextButton? = null
    private var jap_button:TextButton? = null
    private var kor_button:TextButton? = null

    override fun show() {
//        super.show()
//        stage = Stage(FitViewport(game.screenWidth, game.screenHeight))
//        Gdx.input.setInputProcessor(stage)
        Gdx.input.inputProcessor = stage
        stage.isDebugAll = true
        table = Table(game.uiskin)
        table!!.setSize(game.screenWidth, game.screenHeight)

        eng_style.font = game.uiskin.get("chn-32", BitmapFont::class.java)
        eng_style.up = game.uiskin.getDrawable("button-up")
        eng_style.down = game.uiskin.getDrawable("button-down")
        eng_button = TextButton("", game.uiskin, "default")
        eng_button!!.style = eng_style
        eng_button!!.setText("测试按钮")


        eng_cbox_style.font = game.uiskin.get("chn-32", BitmapFont::class.java)
        eng_cbox_style.checkboxOn = game.uiskin.getDrawable("check-on")
        eng_cbox_style.checkboxOff = game.uiskin.getDrawable("check-off")

        eng_cbox = CheckBox("",game.uiskin)
        eng_cbox!!.style = eng_cbox_style
        eng_cbox!!.setText("测试按钮")

        eng_label_style.font = game.uiskin.get("chn-32", BitmapFont::class.java)
        eng_label_style.background = game.uiskin.getDrawable("label-background")

        eng_label = Label("", game.uiskin)
        eng_label!!.style = eng_label_style
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

        eng_textfield_style.font = game.uiskin.get("eng-32", BitmapFont::class.java)
        eng_textfield_style.fontColor = Color(1f,1f,1f,1f)
        eng_textfield_style.background = game.uiskin.getDrawable("textfield-background")
        eng_textfield_style.focusedBackground = game.uiskin.getDrawable("textfield-focused")
        eng_textfield_style.disabledBackground = game.uiskin.getDrawable("textfield-disabled")
        eng_textfield_style.cursor = game.uiskin.getDrawable("cursor")
        eng_textfield_style.selection = game.uiskin.getDrawable("cursor")

        eng_textfield = TextField("test", game.uiskin)
        eng_textfield!!.style = eng_textfield_style

        eng_textarea = TextArea("test\ntestt\ntesttt",game.uiskin)
//        eng_textarea!!.setPrefRows(4f)
        eng_textarea!!.style = eng_textfield_style


        scroll_style.background = game.uiskin.getDrawable("scroll-background")
        scroll_style.hScroll = game.uiskin.getDrawable("hscroll")
        scroll_style.hScrollKnob = game.uiskin.getDrawable("hscrollknob")
        scroll_style.vScroll = game.uiskin.getDrawable("vscroll")
        scroll_style.vScrollKnob = game.uiskin.getDrawable("vscrollknob")

        scroll = ScrollPane(eng_label, game.uiskin)
        scroll!!.style = scroll_style

        list_style.background = game.uiskin.getDrawable("list-background")
        list_style.selection = game.uiskin.getDrawable("list-selection")
        list_style.down = game.uiskin.getDrawable("list-down")
        list_style.font = game.uiskin.get("eng-32", BitmapFont::class.java)

        list = UIList(game.uiskin)
        list!!.style = list_style
        listArray.add(
                "testttt",
                "testtttt",
                "testttttt",
                "testtttttt"
        )
        list!!.setItems(listArray)

        selectbox_style.font = game.uiskin.get("eng-32", BitmapFont::class.java)
        selectbox_style.fontColor = Color.WHITE
        selectbox_style.listStyle = list_style
        selectbox_style.scrollStyle = scroll_style
        selectbox_style.background = game.uiskin.getDrawable("selectbox-background")

        selectboxArray.add(
                "testttt",
                "testtttt",
                "testttttt",
                "testtttttt"
        )

        selectbox = SelectBox(game.uiskin)
        selectbox!!.setItems(selectboxArray)
        selectbox!!.style = selectbox_style
        selectbox!!.maxListCount = 3

        progress_style.background = game.uiskin.getDrawable("progressbar-background")
        progress_style.knob = game.uiskin.getDrawable("progressbar-knob")
        progress_style.knobBefore = game.uiskin.getDrawable("progressbar-knobbefore")
        progress_style.knobAfter = game.uiskin.getDrawable("progressbar-knobafter")

        progress = ProgressBar(0f,5f,1f,false,game.uiskin)
        progress!!.style = progress_style
        progress!!.value = 3f

        progressv = ProgressBar(0f,5f,1f,true,game.uiskin)
        progressv!!.style = progress_style
        progressv!!.value = 3f

        slider_style.background = game.uiskin.getDrawable("slider-background")
        slider_style.knob = game.uiskin.getDrawable("slider-knob")
        slider_style.knobDown = game.uiskin.getDrawable("slider-knob")
        slider_style.knobOver = game.uiskin.getDrawable("slider-knob")

        slider = Slider(0f,10f,1f,false,game.uiskin)
        slider!!.setStyle(slider_style)

        sliderv = Slider(0f,10f,1f,true,game.uiskin)
        sliderv!!.setStyle(slider_style)

//        table!!.add(eng_label).expandX().expandY()//.fillX().fillY()
//        table!!.add(eng_textarea).expandX().expandY()//.fillX().fillY() //BUGGED

//        table!!.add(eng_button).expandX().expandY()//.fillX().fillY()
//        table!!.add(selectbox).expandX().expandY()
//        table!!.row()
//        table!!.add(eng_textfield).expandX().expandY()//.fillX().fillY()
//        table!!.add(eng_cbox).expandX().expandY()//.fillX().fillY()
//        table!!.row()
//        table!!.add(list).expandX().expandY()
//        table!!.add(scroll).expandX().expandY()//.fillX().fillY()
//        table!!.row()
//        table!!.add(progress).expandX().expandY()
//        table!!.add(progressv).expandX().expandY()
//        table!!.row()
        table!!.add(slider).expandX().expandY()
        table!!.row()
        table!!.add(sliderv).expandX().expandY()

        stage.addActor(table)

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