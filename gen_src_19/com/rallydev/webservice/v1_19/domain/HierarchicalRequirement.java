/**
 * HierarchicalRequirement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.rallydev.webservice.v1_19.domain;

public class HierarchicalRequirement  extends com.rallydev.webservice.v1_19.domain.Requirement  implements java.io.Serializable {
    private java.util.Calendar acceptedDate;

    private java.lang.Boolean blocked;

    private com.rallydev.webservice.v1_19.domain.Blocker blocker;

    private com.rallydev.webservice.v1_19.domain.HierarchicalRequirement[] children;

    private com.rallydev.webservice.v1_19.domain.Defect[] defects;

    private com.rallydev.webservice.v1_19.domain.Iteration iteration;

    private com.rallydev.webservice.v1_19.domain.HierarchicalRequirement parent;

    private java.lang.Double planEstimate;

    private com.rallydev.webservice.v1_19.domain.HierarchicalRequirement[] predecessors;

    private java.math.BigDecimal rank;

    private com.rallydev.webservice.v1_19.domain.Release release;

    private java.lang.String scheduleState;

    private com.rallydev.webservice.v1_19.domain.HierarchicalRequirement[] successors;

    private java.lang.Double taskActualTotal;

    private java.lang.Double taskEstimateTotal;

    private java.lang.Double taskRemainingTotal;

    private com.rallydev.webservice.v1_19.domain.Task[] tasks;

    private com.rallydev.webservice.v1_19.domain.TestCase[] testCases;

    private java.lang.String accountingProject;

    private java.lang.String accountingTask;

    private java.lang.String affectedCustomers;

    private java.lang.Boolean capitalizable;

    private com.rallydev.webservice.v1_19.domain.WebLink ideaURL;

    private java.lang.Long ideaVotes;

    private java.lang.String kanbanState;

    private java.lang.Long numberofCases;

    private java.lang.Long numberofRequests;

    private java.lang.String portfolioAllocation;

    private java.lang.String portfolioHierarchy;

    private java.lang.String portfolioKanbanState;

    private java.lang.String portfolioRelease;

    private java.lang.String requestingCustomers;

    private com.rallydev.webservice.v1_19.domain.WebLink salesforceCase;

    private com.rallydev.webservice.v1_19.domain.WebLink salesforceFeature;

    private java.lang.Double score;

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
           com.rallydev.webservice.v1_19.domain.Subscription subscription,
           com.rallydev.webservice.v1_19.domain.Workspace workspace,
           java.lang.String description,
           com.rallydev.webservice.v1_19.domain.ConversationPost[] discussion,
           java.lang.String formattedID,
           java.util.Calendar lastUpdateDate,
           java.lang.String name,
           java.lang.String notes,
           com.rallydev.webservice.v1_19.domain.User owner,
           com.rallydev.webservice.v1_19.domain.Project project,
           com.rallydev.webservice.v1_19.domain.RevisionHistory revisionHistory,
           com.rallydev.webservice.v1_19.domain.Tag[] tags,
           com.rallydev.webservice.v1_19.domain.Attachment[] attachments,
           java.lang.String _package,
           java.util.Calendar acceptedDate,
           java.lang.Boolean blocked,
           com.rallydev.webservice.v1_19.domain.Blocker blocker,
           com.rallydev.webservice.v1_19.domain.HierarchicalRequirement[] children,
           com.rallydev.webservice.v1_19.domain.Defect[] defects,
           com.rallydev.webservice.v1_19.domain.Iteration iteration,
           com.rallydev.webservice.v1_19.domain.HierarchicalRequirement parent,
           java.lang.Double planEstimate,
           com.rallydev.webservice.v1_19.domain.HierarchicalRequirement[] predecessors,
           java.math.BigDecimal rank,
           com.rallydev.webservice.v1_19.domain.Release release,
           java.lang.String scheduleState,
           com.rallydev.webservice.v1_19.domain.HierarchicalRequirement[] successors,
           java.lang.Double taskActualTotal,
           java.lang.Double taskEstimateTotal,
           java.lang.Double taskRemainingTotal,
           com.rallydev.webservice.v1_19.domain.Task[] tasks,
           com.rallydev.webservice.v1_19.domain.TestCase[] testCases,
           java.lang.String accountingProject,
           java.lang.String accountingTask,
           java.lang.String affectedCustomers,
           java.lang.Boolean capitalizable,
           com.rallydev.webservice.v1_19.domain.WebLink ideaURL,
           java.lang.Long ideaVotes,
           java.lang.String kanbanState,
           java.lang.Long numberofCases,
           java.lang.Long numberofRequests,
           java.lang.String portfolioAllocation,
           java.lang.String portfolioHierarchy,
           java.lang.String portfolioKanbanState,
           java.lang.String portfolioRelease,
           java.lang.String requestingCustomers,
           com.rallydev.webservice.v1_19.domain.WebLink salesforceCase,
           com.rallydev.webservice.v1_19.domain.WebLink salesforceFeature,
           java.lang.Double score) {
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
        this.accountingProject = accountingProject;
        this.accountingTask = accountingTask;
        this.affectedCustomers = affectedCustomers;
        this.capitalizable = capitalizable;
        this.ideaURL = ideaURL;
        this.ideaVotes = ideaVotes;
        this.kanbanState = kanbanState;
        this.numberofCases = numberofCases;
        this.numberofRequests = numberofRequests;
        this.portfolioAllocation = portfolioAllocation;
        this.portfolioHierarchy = portfolioHierarchy;
        this.portfolioKanbanState = portfolioKanbanState;
        this.portfolioRelease = portfolioRelease;
        this.requestingCustomers = requestingCustomers;
        this.salesforceCase = salesforceCase;
        this.salesforceFeature = salesforceFeature;
        this.score = score;
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
    public com.rallydev.webservice.v1_19.domain.Blocker getBlocker() {
        return blocker;
    }


    /**
     * Sets the blocker value for this HierarchicalRequirement.
     * 
     * @param blocker
     */
    public void setBlocker(com.rallydev.webservice.v1_19.domain.Blocker blocker) {
        this.blocker = blocker;
    }


    /**
     * Gets the children value for this HierarchicalRequirement.
     * 
     * @return children
     */
    public com.rallydev.webservice.v1_19.domain.HierarchicalRequirement[] getChildren() {
        return children;
    }


    /**
     * Sets the children value for this HierarchicalRequirement.
     * 
     * @param children
     */
    public void setChildren(com.rallydev.webservice.v1_19.domain.HierarchicalRequirement[] children) {
        this.children = children;
    }


    /**
     * Gets the defects value for this HierarchicalRequirement.
     * 
     * @return defects
     */
    public com.rallydev.webservice.v1_19.domain.Defect[] getDefects() {
        return defects;
    }


    /**
     * Sets the defects value for this HierarchicalRequirement.
     * 
     * @param defects
     */
    public void setDefects(com.rallydev.webservice.v1_19.domain.Defect[] defects) {
        this.defects = defects;
    }


    /**
     * Gets the iteration value for this HierarchicalRequirement.
     * 
     * @return iteration
     */
    public com.rallydev.webservice.v1_19.domain.Iteration getIteration() {
        return iteration;
    }


    /**
     * Sets the iteration value for this HierarchicalRequirement.
     * 
     * @param iteration
     */
    public void setIteration(com.rallydev.webservice.v1_19.domain.Iteration iteration) {
        this.iteration = iteration;
    }


    /**
     * Gets the parent value for this HierarchicalRequirement.
     * 
     * @return parent
     */
    public com.rallydev.webservice.v1_19.domain.HierarchicalRequirement getParent() {
        return parent;
    }


    /**
     * Sets the parent value for this HierarchicalRequirement.
     * 
     * @param parent
     */
    public void setParent(com.rallydev.webservice.v1_19.domain.HierarchicalRequirement parent) {
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
    public com.rallydev.webservice.v1_19.domain.HierarchicalRequirement[] getPredecessors() {
        return predecessors;
    }


    /**
     * Sets the predecessors value for this HierarchicalRequirement.
     * 
     * @param predecessors
     */
    public void setPredecessors(com.rallydev.webservice.v1_19.domain.HierarchicalRequirement[] predecessors) {
        this.predecessors = predecessors;
    }


    /**
     * Gets the rank value for this HierarchicalRequirement.
     * 
     * @return rank
     */
    public java.math.BigDecimal getRank() {
        return rank;
    }


    /**
     * Sets the rank value for this HierarchicalRequirement.
     * 
     * @param rank
     */
    public void setRank(java.math.BigDecimal rank) {
        this.rank = rank;
    }


    /**
     * Gets the release value for this HierarchicalRequirement.
     * 
     * @return release
     */
    public com.rallydev.webservice.v1_19.domain.Release getRelease() {
        return release;
    }


    /**
     * Sets the release value for this HierarchicalRequirement.
     * 
     * @param release
     */
    public void setRelease(com.rallydev.webservice.v1_19.domain.Release release) {
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
    public com.rallydev.webservice.v1_19.domain.HierarchicalRequirement[] getSuccessors() {
        return successors;
    }


    /**
     * Sets the successors value for this HierarchicalRequirement.
     * 
     * @param successors
     */
    public void setSuccessors(com.rallydev.webservice.v1_19.domain.HierarchicalRequirement[] successors) {
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
    public com.rallydev.webservice.v1_19.domain.Task[] getTasks() {
        return tasks;
    }


    /**
     * Sets the tasks value for this HierarchicalRequirement.
     * 
     * @param tasks
     */
    public void setTasks(com.rallydev.webservice.v1_19.domain.Task[] tasks) {
        this.tasks = tasks;
    }


    /**
     * Gets the testCases value for this HierarchicalRequirement.
     * 
     * @return testCases
     */
    public com.rallydev.webservice.v1_19.domain.TestCase[] getTestCases() {
        return testCases;
    }


    /**
     * Sets the testCases value for this HierarchicalRequirement.
     * 
     * @param testCases
     */
    public void setTestCases(com.rallydev.webservice.v1_19.domain.TestCase[] testCases) {
        this.testCases = testCases;
    }


    /**
     * Gets the accountingProject value for this HierarchicalRequirement.
     * 
     * @return accountingProject
     */
    public java.lang.String getAccountingProject() {
        return accountingProject;
    }


    /**
     * Sets the accountingProject value for this HierarchicalRequirement.
     * 
     * @param accountingProject
     */
    public void setAccountingProject(java.lang.String accountingProject) {
        this.accountingProject = accountingProject;
    }


    /**
     * Gets the accountingTask value for this HierarchicalRequirement.
     * 
     * @return accountingTask
     */
    public java.lang.String getAccountingTask() {
        return accountingTask;
    }


    /**
     * Sets the accountingTask value for this HierarchicalRequirement.
     * 
     * @param accountingTask
     */
    public void setAccountingTask(java.lang.String accountingTask) {
        this.accountingTask = accountingTask;
    }


    /**
     * Gets the affectedCustomers value for this HierarchicalRequirement.
     * 
     * @return affectedCustomers
     */
    public java.lang.String getAffectedCustomers() {
        return affectedCustomers;
    }


    /**
     * Sets the affectedCustomers value for this HierarchicalRequirement.
     * 
     * @param affectedCustomers
     */
    public void setAffectedCustomers(java.lang.String affectedCustomers) {
        this.affectedCustomers = affectedCustomers;
    }


    /**
     * Gets the capitalizable value for this HierarchicalRequirement.
     * 
     * @return capitalizable
     */
    public java.lang.Boolean getCapitalizable() {
        return capitalizable;
    }


    /**
     * Sets the capitalizable value for this HierarchicalRequirement.
     * 
     * @param capitalizable
     */
    public void setCapitalizable(java.lang.Boolean capitalizable) {
        this.capitalizable = capitalizable;
    }


    /**
     * Gets the ideaURL value for this HierarchicalRequirement.
     * 
     * @return ideaURL
     */
    public com.rallydev.webservice.v1_19.domain.WebLink getIdeaURL() {
        return ideaURL;
    }


    /**
     * Sets the ideaURL value for this HierarchicalRequirement.
     * 
     * @param ideaURL
     */
    public void setIdeaURL(com.rallydev.webservice.v1_19.domain.WebLink ideaURL) {
        this.ideaURL = ideaURL;
    }


    /**
     * Gets the ideaVotes value for this HierarchicalRequirement.
     * 
     * @return ideaVotes
     */
    public java.lang.Long getIdeaVotes() {
        return ideaVotes;
    }


    /**
     * Sets the ideaVotes value for this HierarchicalRequirement.
     * 
     * @param ideaVotes
     */
    public void setIdeaVotes(java.lang.Long ideaVotes) {
        this.ideaVotes = ideaVotes;
    }


    /**
     * Gets the kanbanState value for this HierarchicalRequirement.
     * 
     * @return kanbanState
     */
    public java.lang.String getKanbanState() {
        return kanbanState;
    }


    /**
     * Sets the kanbanState value for this HierarchicalRequirement.
     * 
     * @param kanbanState
     */
    public void setKanbanState(java.lang.String kanbanState) {
        this.kanbanState = kanbanState;
    }


    /**
     * Gets the numberofCases value for this HierarchicalRequirement.
     * 
     * @return numberofCases
     */
    public java.lang.Long getNumberofCases() {
        return numberofCases;
    }


    /**
     * Sets the numberofCases value for this HierarchicalRequirement.
     * 
     * @param numberofCases
     */
    public void setNumberofCases(java.lang.Long numberofCases) {
        this.numberofCases = numberofCases;
    }


    /**
     * Gets the numberofRequests value for this HierarchicalRequirement.
     * 
     * @return numberofRequests
     */
    public java.lang.Long getNumberofRequests() {
        return numberofRequests;
    }


    /**
     * Sets the numberofRequests value for this HierarchicalRequirement.
     * 
     * @param numberofRequests
     */
    public void setNumberofRequests(java.lang.Long numberofRequests) {
        this.numberofRequests = numberofRequests;
    }


    /**
     * Gets the portfolioAllocation value for this HierarchicalRequirement.
     * 
     * @return portfolioAllocation
     */
    public java.lang.String getPortfolioAllocation() {
        return portfolioAllocation;
    }


    /**
     * Sets the portfolioAllocation value for this HierarchicalRequirement.
     * 
     * @param portfolioAllocation
     */
    public void setPortfolioAllocation(java.lang.String portfolioAllocation) {
        this.portfolioAllocation = portfolioAllocation;
    }


    /**
     * Gets the portfolioHierarchy value for this HierarchicalRequirement.
     * 
     * @return portfolioHierarchy
     */
    public java.lang.String getPortfolioHierarchy() {
        return portfolioHierarchy;
    }


    /**
     * Sets the portfolioHierarchy value for this HierarchicalRequirement.
     * 
     * @param portfolioHierarchy
     */
    public void setPortfolioHierarchy(java.lang.String portfolioHierarchy) {
        this.portfolioHierarchy = portfolioHierarchy;
    }


    /**
     * Gets the portfolioKanbanState value for this HierarchicalRequirement.
     * 
     * @return portfolioKanbanState
     */
    public java.lang.String getPortfolioKanbanState() {
        return portfolioKanbanState;
    }


    /**
     * Sets the portfolioKanbanState value for this HierarchicalRequirement.
     * 
     * @param portfolioKanbanState
     */
    public void setPortfolioKanbanState(java.lang.String portfolioKanbanState) {
        this.portfolioKanbanState = portfolioKanbanState;
    }


    /**
     * Gets the portfolioRelease value for this HierarchicalRequirement.
     * 
     * @return portfolioRelease
     */
    public java.lang.String getPortfolioRelease() {
        return portfolioRelease;
    }


    /**
     * Sets the portfolioRelease value for this HierarchicalRequirement.
     * 
     * @param portfolioRelease
     */
    public void setPortfolioRelease(java.lang.String portfolioRelease) {
        this.portfolioRelease = portfolioRelease;
    }


    /**
     * Gets the requestingCustomers value for this HierarchicalRequirement.
     * 
     * @return requestingCustomers
     */
    public java.lang.String getRequestingCustomers() {
        return requestingCustomers;
    }


    /**
     * Sets the requestingCustomers value for this HierarchicalRequirement.
     * 
     * @param requestingCustomers
     */
    public void setRequestingCustomers(java.lang.String requestingCustomers) {
        this.requestingCustomers = requestingCustomers;
    }


    /**
     * Gets the salesforceCase value for this HierarchicalRequirement.
     * 
     * @return salesforceCase
     */
    public com.rallydev.webservice.v1_19.domain.WebLink getSalesforceCase() {
        return salesforceCase;
    }


    /**
     * Sets the salesforceCase value for this HierarchicalRequirement.
     * 
     * @param salesforceCase
     */
    public void setSalesforceCase(com.rallydev.webservice.v1_19.domain.WebLink salesforceCase) {
        this.salesforceCase = salesforceCase;
    }


    /**
     * Gets the salesforceFeature value for this HierarchicalRequirement.
     * 
     * @return salesforceFeature
     */
    public com.rallydev.webservice.v1_19.domain.WebLink getSalesforceFeature() {
        return salesforceFeature;
    }


    /**
     * Sets the salesforceFeature value for this HierarchicalRequirement.
     * 
     * @param salesforceFeature
     */
    public void setSalesforceFeature(com.rallydev.webservice.v1_19.domain.WebLink salesforceFeature) {
        this.salesforceFeature = salesforceFeature;
    }


    /**
     * Gets the score value for this HierarchicalRequirement.
     * 
     * @return score
     */
    public java.lang.Double getScore() {
        return score;
    }


    /**
     * Sets the score value for this HierarchicalRequirement.
     * 
     * @param score
     */
    public void setScore(java.lang.Double score) {
        this.score = score;
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
            ((this.accountingProject==null && other.getAccountingProject()==null) || 
             (this.accountingProject!=null &&
              this.accountingProject.equals(other.getAccountingProject()))) &&
            ((this.accountingTask==null && other.getAccountingTask()==null) || 
             (this.accountingTask!=null &&
              this.accountingTask.equals(other.getAccountingTask()))) &&
            ((this.affectedCustomers==null && other.getAffectedCustomers()==null) || 
             (this.affectedCustomers!=null &&
              this.affectedCustomers.equals(other.getAffectedCustomers()))) &&
            ((this.capitalizable==null && other.getCapitalizable()==null) || 
             (this.capitalizable!=null &&
              this.capitalizable.equals(other.getCapitalizable()))) &&
            ((this.ideaURL==null && other.getIdeaURL()==null) || 
             (this.ideaURL!=null &&
              this.ideaURL.equals(other.getIdeaURL()))) &&
            ((this.ideaVotes==null && other.getIdeaVotes()==null) || 
             (this.ideaVotes!=null &&
              this.ideaVotes.equals(other.getIdeaVotes()))) &&
            ((this.kanbanState==null && other.getKanbanState()==null) || 
             (this.kanbanState!=null &&
              this.kanbanState.equals(other.getKanbanState()))) &&
            ((this.numberofCases==null && other.getNumberofCases()==null) || 
             (this.numberofCases!=null &&
              this.numberofCases.equals(other.getNumberofCases()))) &&
            ((this.numberofRequests==null && other.getNumberofRequests()==null) || 
             (this.numberofRequests!=null &&
              this.numberofRequests.equals(other.getNumberofRequests()))) &&
            ((this.portfolioAllocation==null && other.getPortfolioAllocation()==null) || 
             (this.portfolioAllocation!=null &&
              this.portfolioAllocation.equals(other.getPortfolioAllocation()))) &&
            ((this.portfolioHierarchy==null && other.getPortfolioHierarchy()==null) || 
             (this.portfolioHierarchy!=null &&
              this.portfolioHierarchy.equals(other.getPortfolioHierarchy()))) &&
            ((this.portfolioKanbanState==null && other.getPortfolioKanbanState()==null) || 
             (this.portfolioKanbanState!=null &&
              this.portfolioKanbanState.equals(other.getPortfolioKanbanState()))) &&
            ((this.portfolioRelease==null && other.getPortfolioRelease()==null) || 
             (this.portfolioRelease!=null &&
              this.portfolioRelease.equals(other.getPortfolioRelease()))) &&
            ((this.requestingCustomers==null && other.getRequestingCustomers()==null) || 
             (this.requestingCustomers!=null &&
              this.requestingCustomers.equals(other.getRequestingCustomers()))) &&
            ((this.salesforceCase==null && other.getSalesforceCase()==null) || 
             (this.salesforceCase!=null &&
              this.salesforceCase.equals(other.getSalesforceCase()))) &&
            ((this.salesforceFeature==null && other.getSalesforceFeature()==null) || 
             (this.salesforceFeature!=null &&
              this.salesforceFeature.equals(other.getSalesforceFeature()))) &&
            ((this.score==null && other.getScore()==null) || 
             (this.score!=null &&
              this.score.equals(other.getScore())));
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
        if (getAccountingProject() != null) {
            _hashCode += getAccountingProject().hashCode();
        }
        if (getAccountingTask() != null) {
            _hashCode += getAccountingTask().hashCode();
        }
        if (getAffectedCustomers() != null) {
            _hashCode += getAffectedCustomers().hashCode();
        }
        if (getCapitalizable() != null) {
            _hashCode += getCapitalizable().hashCode();
        }
        if (getIdeaURL() != null) {
            _hashCode += getIdeaURL().hashCode();
        }
        if (getIdeaVotes() != null) {
            _hashCode += getIdeaVotes().hashCode();
        }
        if (getKanbanState() != null) {
            _hashCode += getKanbanState().hashCode();
        }
        if (getNumberofCases() != null) {
            _hashCode += getNumberofCases().hashCode();
        }
        if (getNumberofRequests() != null) {
            _hashCode += getNumberofRequests().hashCode();
        }
        if (getPortfolioAllocation() != null) {
            _hashCode += getPortfolioAllocation().hashCode();
        }
        if (getPortfolioHierarchy() != null) {
            _hashCode += getPortfolioHierarchy().hashCode();
        }
        if (getPortfolioKanbanState() != null) {
            _hashCode += getPortfolioKanbanState().hashCode();
        }
        if (getPortfolioRelease() != null) {
            _hashCode += getPortfolioRelease().hashCode();
        }
        if (getRequestingCustomers() != null) {
            _hashCode += getRequestingCustomers().hashCode();
        }
        if (getSalesforceCase() != null) {
            _hashCode += getSalesforceCase().hashCode();
        }
        if (getSalesforceFeature() != null) {
            _hashCode += getSalesforceFeature().hashCode();
        }
        if (getScore() != null) {
            _hashCode += getScore().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(HierarchicalRequirement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "HierarchicalRequirement"));
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
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "Blocker"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("children");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Children"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "HierarchicalRequirement"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "HierarchicalRequirement"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("defects");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Defects"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "Defect"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "Defect"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("iteration");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Iteration"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "Iteration"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parent");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Parent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "HierarchicalRequirement"));
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
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "HierarchicalRequirement"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "HierarchicalRequirement"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rank");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Rank"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("release");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Release"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "Release"));
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
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "HierarchicalRequirement"));
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
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "Task"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "Task"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("testCases");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TestCases"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "TestCase"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "TestCase"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountingProject");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AccountingProject"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountingTask");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AccountingTask"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("affectedCustomers");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AffectedCustomers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("capitalizable");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Capitalizable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ideaURL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IdeaURL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "WebLink"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ideaVotes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IdeaVotes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("kanbanState");
        elemField.setXmlName(new javax.xml.namespace.QName("", "KanbanState"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberofCases");
        elemField.setXmlName(new javax.xml.namespace.QName("", "NumberofCases"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberofRequests");
        elemField.setXmlName(new javax.xml.namespace.QName("", "NumberofRequests"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("portfolioAllocation");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PortfolioAllocation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("portfolioHierarchy");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PortfolioHierarchy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("portfolioKanbanState");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PortfolioKanbanState"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("portfolioRelease");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PortfolioRelease"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestingCustomers");
        elemField.setXmlName(new javax.xml.namespace.QName("", "RequestingCustomers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesforceCase");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SalesforceCase"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "WebLink"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesforceFeature");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SalesforceFeature"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "WebLink"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("score");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Score"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
