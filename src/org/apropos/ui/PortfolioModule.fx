/*
 * PlanModule.fx
 *
 * Created on Nov 30, 2009, 10:13:00 PM
 */

package org.apropos.ui;

import org.apropos.model.RallyModel;
import org.jfxtras.scene.XCustomNode;
import org.jfxtras.scene.layout.XHBox;
import org.jfxtras.scene.layout.XGrid;
import org.jfxtras.scene.layout.XGridLayoutInfo;
import org.jfxtras.scene.layout.XGridLayoutInfo.*;

/**
 * @author Stephen Chin
 */
public class PortfolioModule extends XCustomNode {
    def model = RallyModel.instance;

    public var selectedView:StoryView;
    package var storyViews:StoryView[] = for (stage in model.stages) StoryView {
        narrowColumns: true
        limitByCount: bind model.limitByCount(indexof stage)
        totalLimit: bind model.getWipLimit(indexof stage)
        overSubLimit: bind model.overSubLimit(indexof stage)
        storyViews: bind storyViews
        storyContainer: stage
    }

    def epicFilter = Filter {name: "Epic", list: bind model.epicNames, selectedIndex: bind model.selectedEpicIndex with inverse}
    def packageFilter = Filter {name: "Package", list: bind model.packageNames, selectedIndex: bind model.selectedPackageIndex with inverse}

    override function create() {
        XGrid {
            animate: true
            hgap: 10
            rows: bind [
                row(XHBox {
                    spacing: 8
                    content: [epicFilter, packageFilter]
                    layoutInfo: XGridLayoutInfo {hspan: 3}
                }),
                row(storyViews[s|s.visible])
            ]
        }
    }
}
