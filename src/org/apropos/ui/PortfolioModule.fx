/*
 * PlanModule.fx
 *
 * Created on Nov 30, 2009, 10:13:00 PM
 */

package org.apropos.ui;

import org.apropos.model.RallyModel;
import org.jfxtras.scene.XCustomNode;
import org.jfxtras.scene.layout.XHBox;
import org.jfxtras.scene.layout.XVBox;

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

//    def epicFilter = Filter {name: "Epic", list: bind model.epicNames, selectedIndex: bind model.selectedEpicIndex with inverse}
//    def packageFilter = Filter {name: "Package", list: bind model.packageNames, selectedIndex: bind model.selectedPackageIndex with inverse}
    
    def allocationFilter = Filter {
        name: "Investment Allocation" 
        list: bind model.allocationNames
        selectedIndex: bind model.selectedAllocationIndex with inverse
    };
    def ownerFilter = Filter {
        name: "Owner"
        list: bind for (o in model.owners) o.getDisplayName()
        selectedIndex: bind model.selectedOwnerIndex with inverse
    };

    override function create() {
        XVBox {
            spacing: 8
            content: bind [
                XHBox {
                    animate: true
                    spacing: 8
                    //content: [epicFilter, packageFilter, ownerFilter]
                    content: [allocationFilter, ownerFilter]
                }
                XHBox {
                    animate: true
                    spacing: 10
                    content: storyViews[s|s.visible]
                }
            ]
        }
    }
}
