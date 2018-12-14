package com.kda

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.files.FileHandle
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.scenes.scene2d.ui.Skin

import gui.FantasticPlasticSkin as Fap //trying to create skin class implementation

class KDA : Game() {
    internal var batch: SpriteBatch? = null
    internal var img: Texture? = null

    internal var screenWidth:Float = 0.0f
    internal var screenHeight:Float = 0.0f
    internal var fresh:Boolean = true;

    internal val asMan: AssetManager = AssetManager()
    internal val uiskin:Fap = Fap()

    override fun create() {
        batch = SpriteBatch()
        img = Texture("badlogic.jpg")

        screenWidth = Gdx.graphics.width.toFloat()
        screenHeight = Gdx.graphics.height.toFloat()

//        asMan.load("skin/uiskin.json", Skin::class.java)

//        asMan.load("bmfonts/eng-32.fnt", BitmapFont::class.java)
//        asMan.load("bmfonts/chn-32.fnt", BitmapFont::class.java)
//        asMan.load("bmfonts/jap-32.fnt", BitmapFont::class.java)
//        asMan.load("bmfonts/kor-32.fnt", BitmapFont::class.java)
//        asMan.load("bmfonts/chn-64.fnt", BitmapFont::class.java)
//        asMan.finishLoading()

        uiskin.prepare()
//        uiskin.add("eng-32", asMan.get("bmfonts/eng-32.fnt"), BitmapFont::class.java)
//        uiskin.add("chn-32", asMan.get("bmfonts/chn-32.fnt"), BitmapFont::class.java)
//        uiskin.add("jap-32", asMan.get("bmfonts/jap-32.fnt"), BitmapFont::class.java)
//        uiskin.add("kor-32", asMan.get("bmfonts/kor-32.fnt"), BitmapFont::class.java)
//        uiskin.add("chn-64", asMan.get("bmfonts/chn-64.fnt"), BitmapFont::class.java)
//        uiskin.load(Gdx.files.internal("skin/uiskin.json"))

        //add default libgdx skin
//        uiskin.addRegions(TextureAtlas(Gdx.files.internal("skin/uiskin.atlas")))
        //add fap skin for button
//        uiskin.addRegions(TextureAtlas(Gdx.files.internal("skin/fap.atlas")))


        //load new fonts data into json
        uiskin.load(Gdx.files.internal("skin/uiskin.json"))
    }

    override fun render() {
        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        batch!!.begin()
        batch!!.draw(img, 0f, 0f)
        batch!!.end()

        if (Gdx.input.justTouched() && fresh){
            fresh = false
            setScreen(MainMenuScreen(this))
        }
        super.render()
    }

    override fun dispose() {
        batch!!.dispose()
        img!!.dispose()
    }
}
