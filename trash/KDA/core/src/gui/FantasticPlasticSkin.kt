package gui

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox.CheckBoxStyle
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle
import com.badlogic.gdx.scenes.scene2d.ui.List.ListStyle
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar.ProgressBarStyle
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane.ScrollPaneStyle
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox.SelectBoxStyle
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Slider.SliderStyle
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane.SplitPaneStyle
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad.TouchpadStyle
import com.badlogic.gdx.scenes.scene2d.ui.Tree.TreeStyle
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle

class FantasticPlasticSkin : Skin() {
    private val asm:AssetManager = AssetManager()
    private var defaultFont:BitmapFont? = null

    private val scroll: ScrollPaneStyle = ScrollPaneStyle()
    private val split:SplitPaneStyle = SplitPaneStyle()
    private val tree:TreeStyle = TreeStyle()
    private val label: LabelStyle = LabelStyle()
    private val button:ButtonStyle = ButtonStyle()
    private val tbutton:TextButtonStyle = TextButtonStyle()
    private val check:CheckBoxStyle = CheckBoxStyle()
    private val tfield:TextFieldStyle = TextFieldStyle()
    private val tarea:TextFieldStyle = TextFieldStyle()
    private val list:ListStyle = ListStyle()
    private val select:SelectBoxStyle = SelectBoxStyle()
    private val progress:ProgressBarStyle = ProgressBarStyle()
    private val slider:SliderStyle = SliderStyle()
    private val window:WindowStyle = WindowStyle()
    private val tpad:TouchpadStyle = TouchpadStyle()
    private val dialog:WindowStyle = WindowStyle()

    fun prepare(){
        asm.load("bmfonts/chn-64.fnt", BitmapFont::class.java)
        asm.finishLoading()

        addRegions(TextureAtlas(Gdx.files.internal("skin/uiskin.atlas"))) //default ligdx skin from github
        addRegions(TextureAtlas(Gdx.files.internal("skin/fap.atlas"))) //fantastic plastic skin atlas
        add("chn-64", asm.get("bmfonts/chn-64.fnt"), BitmapFont::class.java)
        load(Gdx.files.internal("skin/uiskin.json")) //now chn-64 font can be used
//        defaultFont = get("chn-64" ,  BitmapFont::class.java)
        defaultFont = get("default-font" ,  BitmapFont::class.java)

        scroll.vScrollKnob = getDrawable("fap-vscrollknob")
        scroll.vScroll = getDrawable("fap-vscroll")
        scroll.hScrollKnob = getDrawable("fap-hscrollknob")
        scroll.hScroll = getDrawable("fap-hscroll")

        split.handle = getDrawable("fap-splitpane")

        tree.minus = getDrawable("fap-minus")
        tree.plus = getDrawable("fap-plus")

        label.background = getDrawable("fap-label-background")
        label.font = defaultFont

        button.up = getDrawable("fap-button-up")
        button.down = getDrawable("fap-button-down")

        tbutton.up = getDrawable("fap-button-up")
        tbutton.down = getDrawable("fap-button-down")
        tbutton.font = defaultFont

        check.checkboxOn = getDrawable("fap-check-on")
        check.checkboxOff = getDrawable("fap-check-off")
        check.font = defaultFont

        tfield.cursor = getDrawable("fap-cursor")
        tfield.selection = getDrawable("fap-cursor")
        tfield.background = getDrawable("fap-textfield-background")
        tfield.disabledBackground = getDrawable("fap-textfield-disabled")
        tfield.focusedBackground = getDrawable("fap-textfield-focused")
        tfield.font = defaultFont
        tfield.fontColor = Color.WHITE

        tarea.cursor = getDrawable("fap-cursor")
        tarea.selection = getDrawable("fap-cursor")
        tarea.background = getDrawable("fap-textfield-background")
        tarea.disabledBackground = getDrawable("fap-textfield-disabled")
        tarea.focusedBackground = getDrawable("fap-textfield-focused")
        tarea.font = defaultFont
        tarea.fontColor = Color.WHITE

        list.background = getDrawable("fap-list-background")
        list.selection = getDrawable("fap-list-selection")
        list.down = getDrawable("fap-list-down")
        list.font = defaultFont

        select.listStyle = list
        select.scrollStyle = scroll
        select.background = getDrawable("fap-selectbox-background")
        select.font = defaultFont

        progress.background = getDrawable("fap-progressbar-background")
        progress.knob = getDrawable("fap-progressbar-knob")
        progress.knobAfter = getDrawable("fap-progressbar-knobafter")
        progress.knobBefore = getDrawable("fap-progressbar-knobbefore")

        slider.knob = getDrawable("fap-slider-knob")
        slider.background = getDrawable("fap-slider-background")

        window.background = getDrawable("fap-window-background")
        window.titleFont = defaultFont

        tpad.background = getDrawable("fap-touchpad-background")
        tpad.knob = getDrawable("fap-touchpad-knob")

        dialog.background = getDrawable("fap-window-background")
        dialog.titleFont = defaultFont

        add("fap", scroll)
        add("fap", split)
        add("fap", tree)
        add("fap", label)
        add("fap", button)
        add("fap", tbutton)
        add("fap", check)
        add("fap", tfield)
        add("fap", tarea)
        add("fap", list)
        add("fap", select)
        add("fap", progress)
        add("fap", slider)
        add("fap", window)
        add("fap", tpad)
        add("fap", dialog)

        load(Gdx.files.internal("skin/uiskin.json")) //now new styles can be used
    }
}