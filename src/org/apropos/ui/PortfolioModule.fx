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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import org.jfxtras.scene.layout.XLayoutInfo;

/**
 * @author Stephen Chin
 */
public class PortfolioModule extends AbstractModulePage {
    //def model = RallyModel.instance;

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

    init {
        pageToolBar = PageToolBar {
            leftNodes: [
                allocationFilter,
                ownerFilter
            ]
            rightNodes: CostSelectionNode {}
        };
        pageContent = XHBox {
            animate: true
            spacing: 10
            content: storyViews[s|s.visible]
        }
    }



//    override function create() {
//        XVBox {
//            spacing: 8
//            content: bind [
////                PageToolBar {
////                    leftNodes: [
////                        allocationFilter,
////                        ownerFilter
////                    ]
////                    rightNodes: CostSelectionNode {}
////                },
//                XHBox {
//                    animate: true
//                    spacing: 10
//                    content: storyViews[s|s.visible]
//                }
//            ]
//        }
//    }
}
