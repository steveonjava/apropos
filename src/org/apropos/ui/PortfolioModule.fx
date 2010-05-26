/*
 * PlanModule.fx
 *
 * Created on Nov 30, 2009, 10:13:00 PM
 */

package org.apropos.ui;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import org.apropos.model.RallyModel;
import org.apropos.model.Story;
import org.jfxtras.scene.XCustomNode;
import org.jfxtras.scene.control.XPicker;
import org.jfxtras.scene.layout.XHBox;
import org.jfxtras.scene.layout.XGrid;
import org.jfxtras.scene.layout.XGridLayoutInfo;
import org.jfxtras.scene.layout.XGridLayoutInfo.*;

/**
 * @author Stephen Chin
 */
public class PortfolioModule extends XCustomNode {
    def model = bind RallyModel.instance;

    public var selectedView:StoryView;
    package var storyViews:StoryView[] = for (stage in model.stages) StoryView {
        narrowColumns: true
        limitByCount: bind model.limitByCount(indexof stage)
        totalLimit: bind model.getWipLimit(indexof stage)
        overSubLimit: bind model.overSubLimit(indexof stage)
        storyViews: bind storyViews
        storyContainer: stage
    }

    var picker:XPicker = XPicker {
        items: bind ["All", model.packageNames]
        onIndexChange: function(index) {
            model.selectedPackageIndex = index;
        }
    }
    def selectedPackageIndex = bind model.selectedPackageIndex on replace {
        if (picker.selectedIndex != model.selectedPackageIndex) {
            picker.select(model.selectedPackageIndex);
        }
    }

    override function create() {
        XGrid {
            animate: true
            hgap: 10
            rows: bind [
                row(XHBox {
                    spacing: 8
                    content: [
                        Label {
                            text: "Investment Filter:"
                            textFill: Color.WHITE
                        }
                        picker
                    ]
                    layoutInfo: XGridLayoutInfo {hspan: 3}
                }),
                row(storyViews[s|s.visible])
            ]
        }
    }
}
