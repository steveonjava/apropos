/*
 * PlanModule.fx
 *
 * Created on Nov 30, 2009, 10:13:00 PM
 */

package org.apropos.ui;

import org.jfxtras.scene.layout.XHBox;
import javafx.scene.Cursor;

/**
 * @author Stephen Chin
 */
public class KanbanModule extends AbstractModulePage {

    public var selectedView:StoryView;
    package var storyViews:StoryView[] = bind for (stage in model.stages) StoryView {
        narrowColumns: true
        limitByCount: bind model.limitByCount(indexof stage)
        totalLimit: bind model.getWipLimit(indexof stage)
        overSubLimit: bind model.overSubLimit(indexof stage)
        storyViews: bind storyViews
        storyContainer: bind stage
        //storyContainerName: bind stage.name //TODO: Find a better way to dynamically update the name on the StoryView
    }

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
        println("------------In KanbanModule init");
        pageToolBar = PageToolBar {
            leftNodes: [
                allocationFilter,
                ownerFilter
            ]
            rightNodes: CostSelectionNode {}
        };
        pageContent = XHBox {
            //animate: bind model.animateLayouts
            animate: false
            spacing: 6
            content: bind storyViews[s|s.visible]
        }
    }

    public override function initPage():Void {
        allocationFilter.selectedIndex = 0;
        ownerFilter.selectedIndex = 0;
    };
}
