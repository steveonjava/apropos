/**
 * HierarchicalRequirement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.apropos.api;

public class HierarchicalRequirement  extends org.apropos.api.Requirement  implements java.io.Serializable {
    private java.util.Calendar acceptedDate;

    private java.lang.Boolean blocked;

    private org.apropos.api.Blocker blocker;

    private org.apropos.api.HierarchicalRequirement[] children;

    private org.apropos.api.Defect[] defects;

    private org.apropos.api.Iteration iteration;

    private org.apropos.api.HierarchicalRequirement parent;

    private java.lang.Double planEstimate;

    private org.apropos.api.HierarchicalRequirement[] predecessors;

    private java.lang.Double rank;

    private org.apropos.api.Release release;

    private java.lang.String scheduleState;

    private org.apropos.api.HierarchicalRequirement[] successors;

    private java.lang.Double taskActualTotal;

    private java.lang.Double taskEstimateTotal;

    private java.lang.Double taskRemainingTotal;

    private org.apropos.api.Task[] tasks;

    private org.apropos.api.TestCase[] testCases;

    private java.lang.Boolean affectsDoc;

    private java.lang.String architecturalTheme;

    private java.lang.String area;

    private java.lang.String customer;

    private java.lang.String detectedIn;

    private java.lang.String groupDetectedBy;

    private java.lang.Long IIR;

    private java.lang.String packagingHierarchy;

    private java.lang.String priority;

    private java.lang.String qualityCenterID;

    private java.lang.String releasePlan;

    private java.lang.Boolean releaseTestNeeded;

    private java.lang.String severity;

    private java.lang.String siebelCR;

    private java.lang.String stage;

    private java.lang.String storySource;

    private java.lang.String submittedBy;

    private java.lang.String targetBuild;

    private java.lang.String UNUSED;

    public HierarchicalRequirement() {
    }

    public HierarchicalRequirement(
           java.lang.String ref,
           long objectVersion,
           java.lang.String type,
           java.lang.String refObjectName,
           long rallyAPIMajor,
           long rallyAPIMinor,
           java.util.Calendar creationDate,
           java.lang.Long objectID,
           org.apropos.api.Subscription subscription,
           org.apropos.api.Workspace workspace,
           java.lang.String description,
           org.apropos.api.ConversationPost[] discussion,
           java.lang.String formattedID,
           java.util.Calendar lastUpdateDate,
           java.lang.String name,
           java.lang.String notes,
           java.lang.String owner,
           org.apropos.api.Project project,
           org.apropos.api.RevisionHistory revisionHistory,
           org.apropos.api.Tag[] tags,
           org.apropos.api.Attachment[] attachments,
           java.lang.String _package,
           java.util.Calendar acceptedDate,
           java.lang.Boolean blocked,
           org.apropos.api.Blocker blocker,
           org.apropos.api.HierarchicalRequirement[] children,
           org.apropos.api.Defect[] defects,
           org.apropos.api.Iteration iteration,
           org.apropos.api.HierarchicalRequirement parent,
           java.lang.Double planEstimate,
           org.apropos.api.HierarchicalRequirement[] predecessors,
           java.lang.Double rank,
           org.apropos.api.Release release,
           java.lang.String scheduleState,
           org.apropos.api.HierarchicalRequirement[] successors,
           java.lang.Double taskActualTotal,
           java.lang.Double taskEstimateTotal,
           java.lang.Double taskRemainingTotal,
           org.apropos.api.Task[] tasks,
           org.apropos.api.TestCase[] testCases,
           java.lang.Boolean affectsDoc,
           java.lang.String architecturalTheme,
           java.lang.String area,
           java.lang.String customer,
           java.lang.String detectedIn,
           java.lang.String groupDetectedBy,
           java.lang.Long IIR,
           java.lang.String packagingHierarchy,
           java.lang.String priority,
           java.lang.String qualityCenterID,
           java.lang.String releasePlan,
           java.lang.Boolean releaseTestNeeded,
           java.lang.String severity,
           java.lang.String siebelCR,
           java.lang.String stage,
           java.lang.String storySource,
           java.lang.String submittedBy,
           java.lang.String targetBuild,
           java.lang.String UNUSED) {
        super(
            ref,
            objectVersion,
            type,
            refObjectName,
            rallyAPIMajor,
            rallyAPIMinor,
            creationDate,
            objectID,
            subscription,
            workspace,
            description,
            discussion,
            formattedID,
            lastUpdateDate,
            name,
            notes,
            owner,
            project,
            revisionHistory,
            tags,
            attachments,
            _package);
        this.acceptedDate = acceptedDate;
        this.blocked = blocked;
        this.blocker = blocker;
        this.children = children;
        this.defects = defects;
        this.iteration = iteration;
        this.parent = parent;
        this.planEstimate = planEstimate;
        this.predecessors = predecessors;
        this.rank = rank;
        this.release = release;
        this.scheduleState = scheduleState;
        this.successors = successors;
        this.taskActualTotal = taskActualTotal;
        this.taskEstimateTotal = taskEstimateTotal;
        this.taskRemainingTotal = taskRemainingTotal;
        this.tasks = tasks;
        this.testCases = testCases;
        this.affectsDoc = affectsDoc;
        this.architecturalTheme = architecturalTheme;
        this.area = area;
        this.customer = customer;
        this.detectedIn = detectedIn;
        this.groupDetectedBy = groupDetectedBy;
        this.IIR = IIR;
        this.packagingHierarchy = packagingHierarchy;
        this.priority = priority;
        this.qualityCenterID = qualityCenterID;
        this.releasePlan = releasePlan;
        this.releaseTestNeeded = releaseTestNeeded;
        this.severity = severity;
        this.siebelCR = siebelCR;
        this.stage = stage;
        this.storySource = storySource;
        this.submittedBy = submittedBy;
        this.targetBuild = targetBuild;
        this.UNUSED = UNUSED;
    }


    /**
     * Gets the acceptedDate value for this HierarchicalRequirement.
     * 
     * @return acceptedDate
     */
    public java.util.Calendar getAcceptedDate() {
        return acceptedDate;
    }


    /**
     * Sets the acceptedDate value for this HierarchicalRequirement.
     * 
     * @param acceptedDate
     */
    public void setAcceptedDate(java.util.Calendar acceptedDate) {
        this.acceptedDate = acceptedDate;
    }


    /**
     * Gets the blocked value for this HierarchicalRequirement.
     * 
     * @return blocked
     */
    public java.lang.Boolean getBlocked() {
        return blocked;
    }


    /**
     * Sets the blocked value for this HierarchicalRequirement.
     * 
     * @param blocked
     */
    public void setBlocked(java.lang.Boolean blocked) {
        this.blocked = blocked;
    }


    /**
     * Gets the blocker value for this HierarchicalRequirement.
     * 
     * @return blocker
     */
    public org.apropos.api.Blocker getBlocker() {
        return blocker;
    }


    /**
     * Sets the blocker value for this HierarchicalRequirement.
     * 
     * @param blocker
     */
    public void setBlocker(org.apropos.api.Blocker blocker) {
        this.blocker = blocker;
    }


    /**
     * Gets the children value for this HierarchicalRequirement.
     * 
     * @return children
     */
    public org.apropos.api.HierarchicalRequirement[] getChildren() {
        return children;
    }


    /**
     * Sets the children value for this HierarchicalRequirement.
     * 
     * @param children
     */
    public void setChildren(org.apropos.api.HierarchicalRequirement[] children) {
        this.children = children;
    }


    /**
     * Gets the defects value for this HierarchicalRequirement.
     * 
     * @return defects
     */
    public org.apropos.api.Defect[] getDefects() {
        return defects;
    }


    /**
     * Sets the defects value for this HierarchicalRequirement.
     * 
     * @param defects
     */
    public void setDefects(org.apropos.api.Defect[] defects) {
        this.defects = defects;
    }


    /**
     * Gets the iteration value for this HierarchicalRequirement.
     * 
     * @return iteration
     */
    public org.apropos.api.Iteration getIteration() {
        return iteration;
    }


    /**
     * Sets the iteration value for this HierarchicalRequirement.
     * 
     * @param iteration
     */
    public void setIteration(org.apropos.api.Iteration iteration) {
        this.iteration = iteration;
    }


    /**
     * Gets the parent value for this HierarchicalRequirement.
     * 
     * @return parent
     */
    public org.apropos.api.HierarchicalRequirement getParent() {
        return parent;
    }


    /**
     * Sets the parent value for this HierarchicalRequirement.
     * 
     * @param parent
     */
    public void setParent(org.apropos.api.HierarchicalRequirement parent) {
        this.parent = parent;
    }


    /**
     * Gets the planEstimate value for this HierarchicalRequirement.
     * 
     * @return planEstimate
     */
    public java.lang.Double getPlanEstimate() {
        return planEstimate;
    }


    /**
     * Sets the planEstimate value for this HierarchicalRequirement.
     * 
     * @param planEstimate
     */
    public void setPlanEstimate(java.lang.Double planEstimate) {
        this.planEstimate = planEstimate;
    }


    /**
     * Gets the predecessors value for this HierarchicalRequirement.
     * 
     * @return predecessors
     */
    public org.apropos.api.HierarchicalRequirement[] getPredecessors() {
        return predecessors;
    }


    /**
     * Sets the predecessors value for this HierarchicalRequirement.
     * 
     * @param predecessors
     */
    public void setPredecessors(org.apropos.api.HierarchicalRequirement[] predecessors) {
        this.predecessors = predecessors;
    }


    /**
     * Gets the rank value for this HierarchicalRequirement.
     * 
     * @return rank
     */
    public java.lang.Double getRank() {
        return rank;
    }


    /**
     * Sets the rank value for this HierarchicalRequirement.
     * 
     * @param rank
     */
    public void setRank(java.lang.Double rank) {
        this.rank = rank;
    }


    /**
     * Gets the release value for this HierarchicalRequirement.
     * 
     * @return release
     */
    public org.apropos.api.Release getRelease() {
        return release;
    }


    /**
     * Sets the release value for this HierarchicalRequirement.
     * 
     * @param release
     */
    public void setRelease(org.apropos.api.Release release) {
        this.release = release;
    }


    /**
     * Gets the scheduleState value for this HierarchicalRequirement.
     * 
     * @return scheduleState
     */
    public java.lang.String getScheduleState() {
        return scheduleState;
    }


    /**
     * Sets the scheduleState value for this HierarchicalRequirement.
     * 
     * @param scheduleState
     */
    public void setScheduleState(java.lang.String scheduleState) {
        this.scheduleState = scheduleState;
    }


    /**
     * Gets the successors value for this HierarchicalRequirement.
     * 
     * @return successors
     */
    public org.apropos.api.HierarchicalRequirement[] getSuccessors() {
        return successors;
    }


    /**
     * Sets the successors value for this HierarchicalRequirement.
     * 
     * @param successors
     */
    public void setSuccessors(org.apropos.api.HierarchicalRequirement[] successors) {
        this.successors = successors;
    }


    /**
     * Gets the taskActualTotal value for this HierarchicalRequirement.
     * 
     * @return taskActualTotal
     */
    public java.lang.Double getTaskActualTotal() {
        return taskActualTotal;
    }


    /**
     * Sets the taskActualTotal value for this HierarchicalRequirement.
     * 
     * @param taskActualTotal
     */
    public void setTaskActualTotal(java.lang.Double taskActualTotal) {
        this.taskActualTotal = taskActualTotal;
    }


    /**
     * Gets the taskEstimateTotal value for this HierarchicalRequirement.
     * 
     * @return taskEstimateTotal
     */
    public java.lang.Double getTaskEstimateTotal() {
        return taskEstimateTotal;
    }


    /**
     * Sets the taskEstimateTotal value for this HierarchicalRequirement.
     * 
     * @param taskEstimateTotal
     */
    public void setTaskEstimateTotal(java.lang.Double taskEstimateTotal) {
        this.taskEstimateTotal = taskEstimateTotal;
    }


    /**
     * Gets the taskRemainingTotal value for this HierarchicalRequirement.
     * 
     * @return taskRemainingTotal
     */
    public java.lang.Double getTaskRemainingTotal() {
        return taskRemainingTotal;
    }


    /**
     * Sets the taskRemainingTotal value for this HierarchicalRequirement.
     * 
     * @param taskRemainingTotal
     */
    public void setTaskRemainingTotal(java.lang.Double taskRemainingTotal) {
        this.taskRemainingTotal = taskRemainingTotal;
    }


    /**
     * Gets the tasks value for this HierarchicalRequirement.
     * 
     * @return tasks
     */
    public org.apropos.api.Task[] getTasks() {
        return tasks;
    }


    /**
     * Sets the tasks value for this HierarchicalRequirement.
     * 
     * @param tasks
     */
    public void setTasks(org.apropos.api.Task[] tasks) {
        this.tasks = tasks;
    }


    /**
     * Gets the testCases value for this HierarchicalRequirement.
     * 
     * @return testCases
     */
    public org.apropos.api.TestCase[] getTestCases() {
        return testCases;
    }


    /**
     * Sets the testCases value for this HierarchicalRequirement.
     * 
     * @param testCases
     */
    public void setTestCases(org.apropos.api.TestCase[] testCases) {
        this.testCases = testCases;
    }


    /**
     * Gets the affectsDoc value for this HierarchicalRequirement.
     * 
     * @return affectsDoc
     */
    public java.lang.Boolean getAffectsDoc() {
        return affectsDoc;
    }


    /**
     * Sets the affectsDoc value for this HierarchicalRequirement.
     * 
     * @param affectsDoc
     */
    public void setAffectsDoc(java.lang.Boolean affectsDoc) {
        this.affectsDoc = affectsDoc;
    }


    /**
     * Gets the architecturalTheme value for this HierarchicalRequirement.
     * 
     * @return architecturalTheme
     */
    public java.lang.String getArchitecturalTheme() {
        return architecturalTheme;
    }


    /**
     * Sets the architecturalTheme value for this HierarchicalRequirement.
     * 
     * @param architecturalTheme
     */
    public void setArchitecturalTheme(java.lang.String architecturalTheme) {
        this.architecturalTheme = architecturalTheme;
    }


    /**
     * Gets the area value for this HierarchicalRequirement.
     * 
     * @return area
     */
    public java.lang.String getArea() {
        return area;
    }


    /**
     * Sets the area value for this HierarchicalRequirement.
     * 
     * @param area
     */
    public void setArea(java.lang.String area) {
        this.area = area;
    }


    /**
     * Gets the customer value for this HierarchicalRequirement.
     * 
     * @return customer
     */
    public java.lang.String getCustomer() {
        return customer;
    }


    /**
     * Sets the customer value for this HierarchicalRequirement.
     * 
     * @param customer
     */
    public void setCustomer(java.lang.String customer) {
        this.customer = customer;
    }


    /**
     * Gets the detectedIn value for this HierarchicalRequirement.
     * 
     * @return detectedIn
     */
    public java.lang.String getDetectedIn() {
        return detectedIn;
    }


    /**
     * Sets the detectedIn value for this HierarchicalRequirement.
     * 
     * @param detectedIn
     */
    public void setDetectedIn(java.lang.String detectedIn) {
        this.detectedIn = detectedIn;
    }


    /**
     * Gets the groupDetectedBy value for this HierarchicalRequirement.
     * 
     * @return groupDetectedBy
     */
    public java.lang.String getGroupDetectedBy() {
        return groupDetectedBy;
    }


    /**
     * Sets the groupDetectedBy value for this HierarchicalRequirement.
     * 
     * @param groupDetectedBy
     */
    public void setGroupDetectedBy(java.lang.String groupDetectedBy) {
        this.groupDetectedBy = groupDetectedBy;
    }


    /**
     * Gets the IIR value for this HierarchicalRequirement.
     * 
     * @return IIR
     */
    public java.lang.Long getIIR() {
        return IIR;
    }


    /**
     * Sets the IIR value for this HierarchicalRequirement.
     * 
     * @param IIR
     */
    public void setIIR(java.lang.Long IIR) {
        this.IIR = IIR;
    }


    /**
     * Gets the packagingHierarchy value for this HierarchicalRequirement.
     * 
     * @return packagingHierarchy
     */
    public java.lang.String getPackagingHierarchy() {
        return packagingHierarchy;
    }


    /**
     * Sets the packagingHierarchy value for this HierarchicalRequirement.
     * 
     * @param packagingHierarchy
     */
    public void setPackagingHierarchy(java.lang.String packagingHierarchy) {
        this.packagingHierarchy = packagingHierarchy;
    }


    /**
     * Gets the priority value for this HierarchicalRequirement.
     * 
     * @return priority
     */
    public java.lang.String getPriority() {
        return priority;
    }


    /**
     * Sets the priority value for this HierarchicalRequirement.
     * 
     * @param priority
     */
    public void setPriority(java.lang.String priority) {
        this.priority = priority;
    }


    /**
     * Gets the qualityCenterID value for this HierarchicalRequirement.
     * 
     * @return qualityCenterID
     */
    public java.lang.String getQualityCenterID() {
        return qualityCenterID;
    }


    /**
     * Sets the qualityCenterID value for this HierarchicalRequirement.
     * 
     * @param qualityCenterID
     */
    public void setQualityCenterID(java.lang.String qualityCenterID) {
        this.qualityCenterID = qualityCenterID;
    }


    /**
     * Gets the releasePlan value for this HierarchicalRequirement.
     * 
     * @return releasePlan
     */
    public java.lang.String getReleasePlan() {
        return releasePlan;
    }


    /**
     * Sets the releasePlan value for this HierarchicalRequirement.
     * 
     * @param releasePlan
     */
    public void setReleasePlan(java.lang.String releasePlan) {
        this.releasePlan = releasePlan;
    }


    /**
     * Gets the releaseTestNeeded value for this HierarchicalRequirement.
     * 
     * @return releaseTestNeeded
     */
    public java.lang.Boolean getReleaseTestNeeded() {
        return releaseTestNeeded;
    }


    /**
     * Sets the releaseTestNeeded value for this HierarchicalRequirement.
     * 
     * @param releaseTestNeeded
     */
    public void setReleaseTestNeeded(java.lang.Boolean releaseTestNeeded) {
        this.releaseTestNeeded = releaseTestNeeded;
    }


    /**
     * Gets the severity value for this HierarchicalRequirement.
     * 
     * @return severity
     */
    public java.lang.String getSeverity() {
        return severity;
    }


    /**
     * Sets the severity value for this HierarchicalRequirement.
     * 
     * @param severity
     */
    public void setSeverity(java.lang.String severity) {
        this.severity = severity;
    }


    /**
     * Gets the siebelCR value for this HierarchicalRequirement.
     * 
     * @return siebelCR
     */
    public java.lang.String getSiebelCR() {
        return siebelCR;
    }


    /**
     * Sets the siebelCR value for this HierarchicalRequirement.
     * 
     * @param siebelCR
     */
    public void setSiebelCR(java.lang.String siebelCR) {
        this.siebelCR = siebelCR;
    }


    /**
     * Gets the stage value for this HierarchicalRequirement.
     * 
     * @return stage
     */
    public java.lang.String getStage() {
        return stage;
    }


    /**
     * Sets the stage value for this HierarchicalRequirement.
     * 
     * @param stage
     */
    public void setStage(java.lang.String stage) {
        this.stage = stage;
    }


    /**
     * Gets the storySource value for this HierarchicalRequirement.
     * 
     * @return storySource
     */
    public java.lang.String getStorySource() {
        return storySource;
    }


    /**
     * Sets the storySource value for this HierarchicalRequirement.
     * 
     * @param storySource
     */
    public void setStorySource(java.lang.String storySource) {
        this.storySource = storySource;
    }


    /**
     * Gets the submittedBy value for this HierarchicalRequirement.
     * 
     * @return submittedBy
     */
    public java.lang.String getSubmittedBy() {
        return submittedBy;
    }


    /**
     * Sets the submittedBy value for this HierarchicalRequirement.
     * 
     * @param submittedBy
     */
    public void setSubmittedBy(java.lang.String submittedBy) {
        this.submittedBy = submittedBy;
    }


    /**
     * Gets the targetBuild value for this HierarchicalRequirement.
     * 
     * @return targetBuild
     */
    public java.lang.String getTargetBuild() {
        return targetBuild;
    }


    /**
     * Sets the targetBuild value for this HierarchicalRequirement.
     * 
     * @param targetBuild
     */
    public void setTargetBuild(java.lang.String targetBuild) {
        this.targetBuild = targetBuild;
    }


    /**
     * Gets the UNUSED value for this HierarchicalRequirement.
     * 
     * @return UNUSED
     */
    public java.lang.String getUNUSED() {
        return UNUSED;
    }


    /**
     * Sets the UNUSED value for this HierarchicalRequirement.
     * 
     * @param UNUSED
     */
    public void setUNUSED(java.lang.String UNUSED) {
        this.UNUSED = UNUSED;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof HierarchicalRequirement)) return false;
        HierarchicalRequirement other = (HierarchicalRequirement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.acceptedDate==null && other.getAcceptedDate()==null) || 
             (this.acceptedDate!=null &&
              this.acceptedDate.equals(other.getAcceptedDate()))) &&
            ((this.blocked==null && other.getBlocked()==null) || 
             (this.blocked!=null &&
              this.blocked.equals(other.getBlocked()))) &&
            ((this.blocker==null && other.getBlocker()==null) || 
             (this.blocker!=null &&
              this.blocker.equals(other.getBlocker()))) &&
            ((this.children==null && other.getChildren()==null) || 
             (this.children!=null &&
              java.util.Arrays.equals(this.children, other.getChildren()))) &&
            ((this.defects==null && other.getDefects()==null) || 
             (this.defects!=null &&
              java.util.Arrays.equals(this.defects, other.getDefects()))) &&
            ((this.iteration==null && other.getIteration()==null) || 
             (this.iteration!=null &&
              this.iteration.equals(other.getIteration()))) &&
            ((this.parent==null && other.getParent()==null) || 
             (this.parent!=null &&
              this.parent.equals(other.getParent()))) &&
            ((this.planEstimate==null && other.getPlanEstimate()==null) || 
             (this.planEstimate!=null &&
              this.planEstimate.equals(other.getPlanEstimate()))) &&
            ((this.predecessors==null && other.getPredecessors()==null) || 
             (this.predecessors!=null &&
              java.util.Arrays.equals(this.predecessors, other.getPredecessors()))) &&
            ((this.rank==null && other.getRank()==null) || 
             (this.rank!=null &&
              this.rank.equals(other.getRank()))) &&
            ((this.release==null && other.getRelease()==null) || 
             (this.release!=null &&
              this.release.equals(other.getRelease()))) &&
            ((this.scheduleState==null && other.getScheduleState()==null) || 
             (this.scheduleState!=null &&
              this.scheduleState.equals(other.getScheduleState()))) &&
            ((this.successors==null && other.getSuccessors()==null) || 
             (this.successors!=null &&
              java.util.Arrays.equals(this.successors, other.getSuccessors()))) &&
            ((this.taskActualTotal==null && other.getTaskActualTotal()==null) || 
             (this.taskActualTotal!=null &&
              this.taskActualTotal.equals(other.getTaskActualTotal()))) &&
            ((this.taskEstimateTotal==null && other.getTaskEstimateTotal()==null) || 
             (this.taskEstimateTotal!=null &&
              this.taskEstimateTotal.equals(other.getTaskEstimateTotal()))) &&
            ((this.taskRemainingTotal==null && other.getTaskRemainingTotal()==null) || 
             (this.taskRemainingTotal!=null &&
              this.taskRemainingTotal.equals(other.getTaskRemainingTotal()))) &&
            ((this.tasks==null && other.getTasks()==null) || 
             (this.tasks!=null &&
              java.util.Arrays.equals(this.tasks, other.getTasks()))) &&
            ((this.testCases==null && other.getTestCases()==null) || 
             (this.testCases!=null &&
              java.util.Arrays.equals(this.testCases, other.getTestCases()))) &&
            ((this.affectsDoc==null && other.getAffectsDoc()==null) || 
             (this.affectsDoc!=null &&
              this.affectsDoc.equals(other.getAffectsDoc()))) &&
            ((this.architecturalTheme==null && other.getArchitecturalTheme()==null) || 
             (this.architecturalTheme!=null &&
              this.architecturalTheme.equals(other.getArchitecturalTheme()))) &&
            ((this.area==null && other.getArea()==null) || 
             (this.area!=null &&
              this.area.equals(other.getArea()))) &&
            ((this.customer==null && other.getCustomer()==null) || 
             (this.customer!=null &&
              this.customer.equals(other.getCustomer()))) &&
            ((this.detectedIn==null && other.getDetectedIn()==null) || 
             (this.detectedIn!=null &&
              this.detectedIn.equals(other.getDetectedIn()))) &&
            ((this.groupDetectedBy==null && other.getGroupDetectedBy()==null) || 
             (this.groupDetectedBy!=null &&
              this.groupDetectedBy.equals(other.getGroupDetectedBy()))) &&
            ((this.IIR==null && other.getIIR()==null) || 
             (this.IIR!=null &&
              this.IIR.equals(other.getIIR()))) &&
            ((this.packagingHierarchy==null && other.getPackagingHierarchy()==null) || 
             (this.packagingHierarchy!=null &&
              this.packagingHierarchy.equals(other.getPackagingHierarchy()))) &&
            ((this.priority==null && other.getPriority()==null) || 
             (this.priority!=null &&
              this.priority.equals(other.getPriority()))) &&
            ((this.qualityCenterID==null && other.getQualityCenterID()==null) || 
             (this.qualityCenterID!=null &&
              this.qualityCenterID.equals(other.getQualityCenterID()))) &&
            ((this.releasePlan==null && other.getReleasePlan()==null) || 
             (this.releasePlan!=null &&
              this.releasePlan.equals(other.getReleasePlan()))) &&
            ((this.releaseTestNeeded==null && other.getReleaseTestNeeded()==null) || 
             (this.releaseTestNeeded!=null &&
              this.releaseTestNeeded.equals(other.getReleaseTestNeeded()))) &&
            ((this.severity==null && other.getSeverity()==null) || 
             (this.severity!=null &&
              this.severity.equals(other.getSeverity()))) &&
            ((this.siebelCR==null && other.getSiebelCR()==null) || 
             (this.siebelCR!=null &&
              this.siebelCR.equals(other.getSiebelCR()))) &&
            ((this.stage==null && other.getStage()==null) || 
             (this.stage!=null &&
              this.stage.equals(other.getStage()))) &&
            ((this.storySource==null && other.getStorySource()==null) || 
             (this.storySource!=null &&
              this.storySource.equals(other.getStorySource()))) &&
            ((this.submittedBy==null && other.getSubmittedBy()==null) || 
             (this.submittedBy!=null &&
              this.submittedBy.equals(other.getSubmittedBy()))) &&
            ((this.targetBuild==null && other.getTargetBuild()==null) || 
             (this.targetBuild!=null &&
              this.targetBuild.equals(other.getTargetBuild()))) &&
            ((this.UNUSED==null && other.getUNUSED()==null) || 
             (this.UNUSED!=null &&
              this.UNUSED.equals(other.getUNUSED())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getAcceptedDate() != null) {
            _hashCode += getAcceptedDate().hashCode();
        }
        if (getBlocked() != null) {
            _hashCode += getBlocked().hashCode();
        }
        if (getBlocker() != null) {
            _hashCode += getBlocker().hashCode();
        }
        if (getChildren() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getChildren());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getChildren(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDefects() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDefects());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDefects(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIteration() != null) {
            _hashCode += getIteration().hashCode();
        }
        if (getParent() != null) {
            _hashCode += getParent().hashCode();
        }
        if (getPlanEstimate() != null) {
            _hashCode += getPlanEstimate().hashCode();
        }
        if (getPredecessors() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPredecessors());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPredecessors(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRank() != null) {
            _hashCode += getRank().hashCode();
        }
        if (getRelease() != null) {
            _hashCode += getRelease().hashCode();
        }
        if (getScheduleState() != null) {
            _hashCode += getScheduleState().hashCode();
        }
        if (getSuccessors() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSuccessors());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSuccessors(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTaskActualTotal() != null) {
            _hashCode += getTaskActualTotal().hashCode();
        }
        if (getTaskEstimateTotal() != null) {
            _hashCode += getTaskEstimateTotal().hashCode();
        }
        if (getTaskRemainingTotal() != null) {
            _hashCode += getTaskRemainingTotal().hashCode();
        }
        if (getTasks() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTasks());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTasks(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTestCases() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTestCases());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTestCases(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAffectsDoc() != null) {
            _hashCode += getAffectsDoc().hashCode();
        }
        if (getArchitecturalTheme() != null) {
            _hashCode += getArchitecturalTheme().hashCode();
        }
        if (getArea() != null) {
            _hashCode += getArea().hashCode();
        }
        if (getCustomer() != null) {
            _hashCode += getCustomer().hashCode();
        }
        if (getDetectedIn() != null) {
            _hashCode += getDetectedIn().hashCode();
        }
        if (getGroupDetectedBy() != null) {
            _hashCode += getGroupDetectedBy().hashCode();
        }
        if (getIIR() != null) {
            _hashCode += getIIR().hashCode();
        }
        if (getPackagingHierarchy() != null) {
            _hashCode += getPackagingHierarchy().hashCode();
        }
        if (getPriority() != null) {
            _hashCode += getPriority().hashCode();
        }
        if (getQualityCenterID() != null) {
            _hashCode += getQualityCenterID().hashCode();
        }
        if (getReleasePlan() != null) {
            _hashCode += getReleasePlan().hashCode();
        }
        if (getReleaseTestNeeded() != null) {
            _hashCode += getReleaseTestNeeded().hashCode();
        }
        if (getSeverity() != null) {
            _hashCode += getSeverity().hashCode();
        }
        if (getSiebelCR() != null) {
            _hashCode += getSiebelCR().hashCode();
        }
        if (getStage() != null) {
            _hashCode += getStage().hashCode();
        }
        if (getStorySource() != null) {
            _hashCode += getStorySource().hashCode();
        }
        if (getSubmittedBy() != null) {
            _hashCode += getSubmittedBy().hashCode();
        }
        if (getTargetBuild() != null) {
            _hashCode += getTargetBuild().hashCode();
        }
        if (getUNUSED() != null) {
            _hashCode += getUNUSED().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(HierarchicalRequirement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "HierarchicalRequirement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("acceptedDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AcceptedDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("blocked");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Blocked"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("blocker");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Blocker"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Blocker"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("children");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Children"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "HierarchicalRequirement"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "HierarchicalRequirement"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("defects");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Defects"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Defect"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "Defect"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("iteration");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Iteration"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Iteration"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parent");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Parent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "HierarchicalRequirement"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("planEstimate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PlanEstimate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("predecessors");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Predecessors"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "HierarchicalRequirement"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "HierarchicalRequirement"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rank");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Rank"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("release");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Release"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Release"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scheduleState");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ScheduleState"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("successors");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Successors"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "HierarchicalRequirement"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "HierarchicalRequirement"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taskActualTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TaskActualTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taskEstimateTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TaskEstimateTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taskRemainingTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TaskRemainingTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tasks");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Tasks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Task"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "Task"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("testCases");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TestCases"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TestCase"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "TestCase"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("affectsDoc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AffectsDoc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("architecturalTheme");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ArchitecturalTheme"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("area");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Area"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Customer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("detectedIn");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DetectedIn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupDetectedBy");
        elemField.setXmlName(new javax.xml.namespace.QName("", "GroupDetectedBy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IIR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IIR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("packagingHierarchy");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PackagingHierarchy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("priority");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Priority"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qualityCenterID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "QualityCenterID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("releasePlan");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ReleasePlan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("releaseTestNeeded");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ReleaseTestNeeded"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("severity");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Severity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("siebelCR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SiebelCR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stage");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Stage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("storySource");
        elemField.setXmlName(new javax.xml.namespace.QName("", "StorySource"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("submittedBy");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SubmittedBy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("targetBuild");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TargetBuild"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UNUSED");
        elemField.setXmlName(new javax.xml.namespace.QName("", "UNUSED"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
