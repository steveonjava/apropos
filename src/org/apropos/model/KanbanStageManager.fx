/*
 * Copyright (c) 2010, Apropos Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 3. Neither the name Apropos nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package org.apropos.model;

var stages = [
    KanbanStage {
        name: "Propose"
        canDemoteFeature: false
        canPromoteFeature: true
        demoteFeatureMsg: ""
        promoteFeatureMsg: "Moves this Feature to the Analyze column."
    },
    KanbanStage {
        name: "Analyze"
        canDemoteFeature: true
        canPromoteFeature: false
        demoteFeatureMsg: "Moves this Feature to the Propose column."
        promoteFeatureMsg: "To schedule a feature into a release, go the Roadmap tab, and move the feature to the release column."
    },
    KanbanStage {
        name: "Schedule"
        canDemoteFeature: false
        canPromoteFeature: false
        demoteFeatureMsg: "To unschedule a feature, go the Roadmap tab, and move the feature to the backlog."
        promoteFeatureMsg: "Features automatically move to the Develop state when their Rally state is In-Progress or Completed."
    },
    KanbanStage {
        name: "Develop"
        canDemoteFeature: false
        canPromoteFeature: false
        demoteFeatureMsg: "Features automatically move from Develop to Schedule when their Rally state reverts from In-Progress to a prior state (ex: Defined, Backlog)."
        promoteFeatureMsg: "Features automatically move to the Deploy state when their Rally state is Accepted or beyond Accepted."
    },
    KanbanStage {
        name: "Deploy"
        canDemoteFeature: false
        canPromoteFeature: true
        demoteFeatureMsg: "Features move from Deploy to Develop when their Rally state changes from Accepted to either Completed or in-Progress."
        promoteFeatureMsg: "Moves this Feature to the Enable column."
    },
    KanbanStage {
        name: "Enable"
        canDemoteFeature: true
        canPromoteFeature: true
        demoteFeatureMsg: "Moves this Feature to the Deploy column."
        promoteFeatureMsg: "Moves this Feature to the Adopt column."
    },
    KanbanStage {
        name: "Adopt"
        canDemoteFeature: true
        canPromoteFeature: true
        demoteFeatureMsg: "Moves this Feature to the Enable column."
        promoteFeatureMsg: "Moves this Feature to the Validate column."
    },
    KanbanStage {
        name: "Validate"
        canDemoteFeature: true
        canPromoteFeature: false
        demoteFeatureMsg: "Moves this Feature to the Adopt column."
        promoteFeatureMsg: ""
    }
];

function getKanbanStageByName(name:String):KanbanStage {
    var kanbanStage:KanbanStage;
    var matchingStages = for (stage in stages where stage.name == name) stage;
    if (sizeof matchingStages == 1) {
        kanbanStage = matchingStages[0];
    }
    return kanbanStage;
}


public bound function canDemoteFeature(name:String):Boolean {
    return getKanbanStageByName(name).canDemoteFeature;
}

public bound function canPromoteFeature(name:String):Boolean {
    return getKanbanStageByName(name).canPromoteFeature;
}

public bound function getDemoteFeatureMsg(name:String):String {
//    var msg:String;
//    var kanbanStage = getKanbanStageByName(name);
//    if (kanbanStage != null) {
//        msg = kanbanStage.demoteFeatureMsg;
//    }
//    return msg;
    return getKanbanStageByName(name).demoteFeatureMsg;
}

public bound function getPromoteFeatureMsg(name:String):String {
//    var msg:String;
//    var kanbanStage = getKanbanStageByName(name);
//    if (kanbanStage != null) {
//        msg = kanbanStage.promoteFeatureMsg;
//    }
//    return msg;
    return getKanbanStageByName(name).promoteFeatureMsg;
}


/**
 * Encapsulates state and logic associated with Kanban states.
 * Using script-level functions with stage name as argument for now
 * to be minimally invasive into present application logic.
 * TODO: Consider allowing the app to hold references to KanbanStage
 *       instances.
 * @author Jim Weaver
 */
public class KanbanStageManager {

}
