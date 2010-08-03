/**
 * Defect.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.rallydev.webservice.v1_19.domain;

public class Defect  extends com.rallydev.webservice.v1_19.domain.Artifact  implements java.io.Serializable {
    private java.util.Calendar acceptedDate;

    private java.lang.Boolean affectsDoc;

    private com.rallydev.webservice.v1_19.domain.Attachment[] attachments;

    private java.lang.Boolean blocked;

    private com.rallydev.webservice.v1_19.domain.Blocker blocker;

    private java.util.Calendar closedDate;

    private com.rallydev.webservice.v1_19.domain.Defect[] duplicates;

    private java.lang.String environment;

    private java.lang.String fixedInBuild;

    private java.lang.String foundInBuild;

    private com.rallydev.webservice.v1_19.domain.Iteration iteration;

    private java.util.Calendar openedDate;

    private java.lang.String _package;

    private java.lang.Double planEstimate;

    private java.lang.String priority;

    private java.math.BigDecimal rank;

    private com.rallydev.webservice.v1_19.domain.Release release;

    private java.lang.Boolean releaseNote;

    private com.rallydev.webservice.v1_19.domain.Requirement requirement;

    private java.lang.String resolution;

    private java.lang.String salesforceCaseID;

    private java.lang.String salesforceCaseNumber;

    private java.lang.String scheduleState;

    private java.lang.String severity;

    private java.lang.String state;

    private com.rallydev.webservice.v1_19.domain.User submittedBy;

    private java.lang.String targetBuild;

    private java.util.Calendar targetDate;

    private java.lang.Double taskActualTotal;

    private java.lang.Double taskEstimateTotal;

    private java.lang.Double taskRemainingTotal;

    private com.rallydev.webservice.v1_19.domain.Task[] tasks;

    private com.rallydev.webservice.v1_19.domain.TestCase testCase;

    private com.rallydev.webservice.v1_19.domain.TestCaseResult testCaseResult;

    private com.rallydev.webservice.v1_19.domain.TestCase[] testCases;

    private java.lang.String verifiedInBuild;

    private java.lang.String affectedCustomers;

    private com.rallydev.webservice.v1_19.domain.WebLink bugzilla;

    private java.lang.String CQDefectID;

    private java.lang.String customer;

    private com.rallydev.webservice.v1_19.domain.WebLink jira;

    private java.lang.String kanbanState;

    private java.lang.Long numberofCases;

    private java.lang.String QCDefectID;

    private com.rallydev.webservice.v1_19.domain.WebLink salesforceCase;

    public Defect() {
    }

    public Defect(
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
           java.util.Calendar acceptedDate,
           java.lang.Boolean affectsDoc,
           com.rallydev.webservice.v1_19.domain.Attachment[] attachments,
           java.lang.Boolean blocked,
           com.rallydev.webservice.v1_19.domain.Blocker blocker,
           java.util.Calendar closedDate,
           com.rallydev.webservice.v1_19.domain.Defect[] duplicates,
           java.lang.String environment,
           java.lang.String fixedInBuild,
           java.lang.String foundInBuild,
           com.rallydev.webservice.v1_19.domain.Iteration iteration,
           java.util.Calendar openedDate,
           java.lang.String _package,
           java.lang.Double planEstimate,
           java.lang.String priority,
           java.math.BigDecimal rank,
           com.rallydev.webservice.v1_19.domain.Release release,
           java.lang.Boolean releaseNote,
           com.rallydev.webservice.v1_19.domain.Requirement requirement,
           java.lang.String resolution,
           java.lang.String salesforceCaseID,
           java.lang.String salesforceCaseNumber,
           java.lang.String scheduleState,
           java.lang.String severity,
           java.lang.String state,
           com.rallydev.webservice.v1_19.domain.User submittedBy,
           java.lang.String targetBuild,
           java.util.Calendar targetDate,
           java.lang.Double taskActualTotal,
           java.lang.Double taskEstimateTotal,
           java.lang.Double taskRemainingTotal,
           com.rallydev.webservice.v1_19.domain.Task[] tasks,
           com.rallydev.webservice.v1_19.domain.TestCase testCase,
           com.rallydev.webservice.v1_19.domain.TestCaseResult testCaseResult,
           com.rallydev.webservice.v1_19.domain.TestCase[] testCases,
           java.lang.String verifiedInBuild,
           java.lang.String affectedCustomers,
           com.rallydev.webservice.v1_19.domain.WebLink bugzilla,
           java.lang.String CQDefectID,
           java.lang.String customer,
           com.rallydev.webservice.v1_19.domain.WebLink jira,
           java.lang.String kanbanState,
           java.lang.Long numberofCases,
           java.lang.String QCDefectID,
           com.rallydev.webservice.v1_19.domain.WebLink salesforceCase) {
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
            tags);
        this.acceptedDate = acceptedDate;
        this.affectsDoc = affectsDoc;
        this.attachments = attachments;
        this.blocked = blocked;
        this.blocker = blocker;
        this.closedDate = closedDate;
        this.duplicates = duplicates;
        this.environment = environment;
        this.fixedInBuild = fixedInBuild;
        this.foundInBuild = foundInBuild;
        this.iteration = iteration;
        this.openedDate = openedDate;
        this._package = _package;
        this.planEstimate = planEstimate;
        this.priority = priority;
        this.rank = rank;
        this.release = release;
        this.releaseNote = releaseNote;
        this.requirement = requirement;
        this.resolution = resolution;
        this.salesforceCaseID = salesforceCaseID;
        this.salesforceCaseNumber = salesforceCaseNumber;
        this.scheduleState = scheduleState;
        this.severity = severity;
        this.state = state;
        this.submittedBy = submittedBy;
        this.targetBuild = targetBuild;
        this.targetDate = targetDate;
        this.taskActualTotal = taskActualTotal;
        this.taskEstimateTotal = taskEstimateTotal;
        this.taskRemainingTotal = taskRemainingTotal;
        this.tasks = tasks;
        this.testCase = testCase;
        this.testCaseResult = testCaseResult;
        this.testCases = testCases;
        this.verifiedInBuild = verifiedInBuild;
        this.affectedCustomers = affectedCustomers;
        this.bugzilla = bugzilla;
        this.CQDefectID = CQDefectID;
        this.customer = customer;
        this.jira = jira;
        this.kanbanState = kanbanState;
        this.numberofCases = numberofCases;
        this.QCDefectID = QCDefectID;
        this.salesforceCase = salesforceCase;
    }


    /**
     * Gets the acceptedDate value for this Defect.
     * 
     * @return acceptedDate
     */
    public java.util.Calendar getAcceptedDate() {
        return acceptedDate;
    }


    /**
     * Sets the acceptedDate value for this Defect.
     * 
     * @param acceptedDate
     */
    public void setAcceptedDate(java.util.Calendar acceptedDate) {
        this.acceptedDate = acceptedDate;
    }


    /**
     * Gets the affectsDoc value for this Defect.
     * 
     * @return affectsDoc
     */
    public java.lang.Boolean getAffectsDoc() {
        return affectsDoc;
    }


    /**
     * Sets the affectsDoc value for this Defect.
     * 
     * @param affectsDoc
     */
    public void setAffectsDoc(java.lang.Boolean affectsDoc) {
        this.affectsDoc = affectsDoc;
    }


    /**
     * Gets the attachments value for this Defect.
     * 
     * @return attachments
     */
    public com.rallydev.webservice.v1_19.domain.Attachment[] getAttachments() {
        return attachments;
    }


    /**
     * Sets the attachments value for this Defect.
     * 
     * @param attachments
     */
    public void setAttachments(com.rallydev.webservice.v1_19.domain.Attachment[] attachments) {
        this.attachments = attachments;
    }


    /**
     * Gets the blocked value for this Defect.
     * 
     * @return blocked
     */
    public java.lang.Boolean getBlocked() {
        return blocked;
    }


    /**
     * Sets the blocked value for this Defect.
     * 
     * @param blocked
     */
    public void setBlocked(java.lang.Boolean blocked) {
        this.blocked = blocked;
    }


    /**
     * Gets the blocker value for this Defect.
     * 
     * @return blocker
     */
    public com.rallydev.webservice.v1_19.domain.Blocker getBlocker() {
        return blocker;
    }


    /**
     * Sets the blocker value for this Defect.
     * 
     * @param blocker
     */
    public void setBlocker(com.rallydev.webservice.v1_19.domain.Blocker blocker) {
        this.blocker = blocker;
    }


    /**
     * Gets the closedDate value for this Defect.
     * 
     * @return closedDate
     */
    public java.util.Calendar getClosedDate() {
        return closedDate;
    }


    /**
     * Sets the closedDate value for this Defect.
     * 
     * @param closedDate
     */
    public void setClosedDate(java.util.Calendar closedDate) {
        this.closedDate = closedDate;
    }


    /**
     * Gets the duplicates value for this Defect.
     * 
     * @return duplicates
     */
    public com.rallydev.webservice.v1_19.domain.Defect[] getDuplicates() {
        return duplicates;
    }


    /**
     * Sets the duplicates value for this Defect.
     * 
     * @param duplicates
     */
    public void setDuplicates(com.rallydev.webservice.v1_19.domain.Defect[] duplicates) {
        this.duplicates = duplicates;
    }


    /**
     * Gets the environment value for this Defect.
     * 
     * @return environment
     */
    public java.lang.String getEnvironment() {
        return environment;
    }


    /**
     * Sets the environment value for this Defect.
     * 
     * @param environment
     */
    public void setEnvironment(java.lang.String environment) {
        this.environment = environment;
    }


    /**
     * Gets the fixedInBuild value for this Defect.
     * 
     * @return fixedInBuild
     */
    public java.lang.String getFixedInBuild() {
        return fixedInBuild;
    }


    /**
     * Sets the fixedInBuild value for this Defect.
     * 
     * @param fixedInBuild
     */
    public void setFixedInBuild(java.lang.String fixedInBuild) {
        this.fixedInBuild = fixedInBuild;
    }


    /**
     * Gets the foundInBuild value for this Defect.
     * 
     * @return foundInBuild
     */
    public java.lang.String getFoundInBuild() {
        return foundInBuild;
    }


    /**
     * Sets the foundInBuild value for this Defect.
     * 
     * @param foundInBuild
     */
    public void setFoundInBuild(java.lang.String foundInBuild) {
        this.foundInBuild = foundInBuild;
    }


    /**
     * Gets the iteration value for this Defect.
     * 
     * @return iteration
     */
    public com.rallydev.webservice.v1_19.domain.Iteration getIteration() {
        return iteration;
    }


    /**
     * Sets the iteration value for this Defect.
     * 
     * @param iteration
     */
    public void setIteration(com.rallydev.webservice.v1_19.domain.Iteration iteration) {
        this.iteration = iteration;
    }


    /**
     * Gets the openedDate value for this Defect.
     * 
     * @return openedDate
     */
    public java.util.Calendar getOpenedDate() {
        return openedDate;
    }


    /**
     * Sets the openedDate value for this Defect.
     * 
     * @param openedDate
     */
    public void setOpenedDate(java.util.Calendar openedDate) {
        this.openedDate = openedDate;
    }


    /**
     * Gets the _package value for this Defect.
     * 
     * @return _package
     */
    public java.lang.String get_package() {
        return _package;
    }


    /**
     * Sets the _package value for this Defect.
     * 
     * @param _package
     */
    public void set_package(java.lang.String _package) {
        this._package = _package;
    }


    /**
     * Gets the planEstimate value for this Defect.
     * 
     * @return planEstimate
     */
    public java.lang.Double getPlanEstimate() {
        return planEstimate;
    }


    /**
     * Sets the planEstimate value for this Defect.
     * 
     * @param planEstimate
     */
    public void setPlanEstimate(java.lang.Double planEstimate) {
        this.planEstimate = planEstimate;
    }


    /**
     * Gets the priority value for this Defect.
     * 
     * @return priority
     */
    public java.lang.String getPriority() {
        return priority;
    }


    /**
     * Sets the priority value for this Defect.
     * 
     * @param priority
     */
    public void setPriority(java.lang.String priority) {
        this.priority = priority;
    }


    /**
     * Gets the rank value for this Defect.
     * 
     * @return rank
     */
    public java.math.BigDecimal getRank() {
        return rank;
    }


    /**
     * Sets the rank value for this Defect.
     * 
     * @param rank
     */
    public void setRank(java.math.BigDecimal rank) {
        this.rank = rank;
    }


    /**
     * Gets the release value for this Defect.
     * 
     * @return release
     */
    public com.rallydev.webservice.v1_19.domain.Release getRelease() {
        return release;
    }


    /**
     * Sets the release value for this Defect.
     * 
     * @param release
     */
    public void setRelease(com.rallydev.webservice.v1_19.domain.Release release) {
        this.release = release;
    }


    /**
     * Gets the releaseNote value for this Defect.
     * 
     * @return releaseNote
     */
    public java.lang.Boolean getReleaseNote() {
        return releaseNote;
    }


    /**
     * Sets the releaseNote value for this Defect.
     * 
     * @param releaseNote
     */
    public void setReleaseNote(java.lang.Boolean releaseNote) {
        this.releaseNote = releaseNote;
    }


    /**
     * Gets the requirement value for this Defect.
     * 
     * @return requirement
     */
    public com.rallydev.webservice.v1_19.domain.Requirement getRequirement() {
        return requirement;
    }


    /**
     * Sets the requirement value for this Defect.
     * 
     * @param requirement
     */
    public void setRequirement(com.rallydev.webservice.v1_19.domain.Requirement requirement) {
        this.requirement = requirement;
    }


    /**
     * Gets the resolution value for this Defect.
     * 
     * @return resolution
     */
    public java.lang.String getResolution() {
        return resolution;
    }


    /**
     * Sets the resolution value for this Defect.
     * 
     * @param resolution
     */
    public void setResolution(java.lang.String resolution) {
        this.resolution = resolution;
    }


    /**
     * Gets the salesforceCaseID value for this Defect.
     * 
     * @return salesforceCaseID
     */
    public java.lang.String getSalesforceCaseID() {
        return salesforceCaseID;
    }


    /**
     * Sets the salesforceCaseID value for this Defect.
     * 
     * @param salesforceCaseID
     */
    public void setSalesforceCaseID(java.lang.String salesforceCaseID) {
        this.salesforceCaseID = salesforceCaseID;
    }


    /**
     * Gets the salesforceCaseNumber value for this Defect.
     * 
     * @return salesforceCaseNumber
     */
    public java.lang.String getSalesforceCaseNumber() {
        return salesforceCaseNumber;
    }


    /**
     * Sets the salesforceCaseNumber value for this Defect.
     * 
     * @param salesforceCaseNumber
     */
    public void setSalesforceCaseNumber(java.lang.String salesforceCaseNumber) {
        this.salesforceCaseNumber = salesforceCaseNumber;
    }


    /**
     * Gets the scheduleState value for this Defect.
     * 
     * @return scheduleState
     */
    public java.lang.String getScheduleState() {
        return scheduleState;
    }


    /**
     * Sets the scheduleState value for this Defect.
     * 
     * @param scheduleState
     */
    public void setScheduleState(java.lang.String scheduleState) {
        this.scheduleState = scheduleState;
    }


    /**
     * Gets the severity value for this Defect.
     * 
     * @return severity
     */
    public java.lang.String getSeverity() {
        return severity;
    }


    /**
     * Sets the severity value for this Defect.
     * 
     * @param severity
     */
    public void setSeverity(java.lang.String severity) {
        this.severity = severity;
    }


    /**
     * Gets the state value for this Defect.
     * 
     * @return state
     */
    public java.lang.String getState() {
        return state;
    }


    /**
     * Sets the state value for this Defect.
     * 
     * @param state
     */
    public void setState(java.lang.String state) {
        this.state = state;
    }


    /**
     * Gets the submittedBy value for this Defect.
     * 
     * @return submittedBy
     */
    public com.rallydev.webservice.v1_19.domain.User getSubmittedBy() {
        return submittedBy;
    }


    /**
     * Sets the submittedBy value for this Defect.
     * 
     * @param submittedBy
     */
    public void setSubmittedBy(com.rallydev.webservice.v1_19.domain.User submittedBy) {
        this.submittedBy = submittedBy;
    }


    /**
     * Gets the targetBuild value for this Defect.
     * 
     * @return targetBuild
     */
    public java.lang.String getTargetBuild() {
        return targetBuild;
    }


    /**
     * Sets the targetBuild value for this Defect.
     * 
     * @param targetBuild
     */
    public void setTargetBuild(java.lang.String targetBuild) {
        this.targetBuild = targetBuild;
    }


    /**
     * Gets the targetDate value for this Defect.
     * 
     * @return targetDate
     */
    public java.util.Calendar getTargetDate() {
        return targetDate;
    }


    /**
     * Sets the targetDate value for this Defect.
     * 
     * @param targetDate
     */
    public void setTargetDate(java.util.Calendar targetDate) {
        this.targetDate = targetDate;
    }


    /**
     * Gets the taskActualTotal value for this Defect.
     * 
     * @return taskActualTotal
     */
    public java.lang.Double getTaskActualTotal() {
        return taskActualTotal;
    }


    /**
     * Sets the taskActualTotal value for this Defect.
     * 
     * @param taskActualTotal
     */
    public void setTaskActualTotal(java.lang.Double taskActualTotal) {
        this.taskActualTotal = taskActualTotal;
    }


    /**
     * Gets the taskEstimateTotal value for this Defect.
     * 
     * @return taskEstimateTotal
     */
    public java.lang.Double getTaskEstimateTotal() {
        return taskEstimateTotal;
    }


    /**
     * Sets the taskEstimateTotal value for this Defect.
     * 
     * @param taskEstimateTotal
     */
    public void setTaskEstimateTotal(java.lang.Double taskEstimateTotal) {
        this.taskEstimateTotal = taskEstimateTotal;
    }


    /**
     * Gets the taskRemainingTotal value for this Defect.
     * 
     * @return taskRemainingTotal
     */
    public java.lang.Double getTaskRemainingTotal() {
        return taskRemainingTotal;
    }


    /**
     * Sets the taskRemainingTotal value for this Defect.
     * 
     * @param taskRemainingTotal
     */
    public void setTaskRemainingTotal(java.lang.Double taskRemainingTotal) {
        this.taskRemainingTotal = taskRemainingTotal;
    }


    /**
     * Gets the tasks value for this Defect.
     * 
     * @return tasks
     */
    public com.rallydev.webservice.v1_19.domain.Task[] getTasks() {
        return tasks;
    }


    /**
     * Sets the tasks value for this Defect.
     * 
     * @param tasks
     */
    public void setTasks(com.rallydev.webservice.v1_19.domain.Task[] tasks) {
        this.tasks = tasks;
    }


    /**
     * Gets the testCase value for this Defect.
     * 
     * @return testCase
     */
    public com.rallydev.webservice.v1_19.domain.TestCase getTestCase() {
        return testCase;
    }


    /**
     * Sets the testCase value for this Defect.
     * 
     * @param testCase
     */
    public void setTestCase(com.rallydev.webservice.v1_19.domain.TestCase testCase) {
        this.testCase = testCase;
    }


    /**
     * Gets the testCaseResult value for this Defect.
     * 
     * @return testCaseResult
     */
    public com.rallydev.webservice.v1_19.domain.TestCaseResult getTestCaseResult() {
        return testCaseResult;
    }


    /**
     * Sets the testCaseResult value for this Defect.
     * 
     * @param testCaseResult
     */
    public void setTestCaseResult(com.rallydev.webservice.v1_19.domain.TestCaseResult testCaseResult) {
        this.testCaseResult = testCaseResult;
    }


    /**
     * Gets the testCases value for this Defect.
     * 
     * @return testCases
     */
    public com.rallydev.webservice.v1_19.domain.TestCase[] getTestCases() {
        return testCases;
    }


    /**
     * Sets the testCases value for this Defect.
     * 
     * @param testCases
     */
    public void setTestCases(com.rallydev.webservice.v1_19.domain.TestCase[] testCases) {
        this.testCases = testCases;
    }


    /**
     * Gets the verifiedInBuild value for this Defect.
     * 
     * @return verifiedInBuild
     */
    public java.lang.String getVerifiedInBuild() {
        return verifiedInBuild;
    }


    /**
     * Sets the verifiedInBuild value for this Defect.
     * 
     * @param verifiedInBuild
     */
    public void setVerifiedInBuild(java.lang.String verifiedInBuild) {
        this.verifiedInBuild = verifiedInBuild;
    }


    /**
     * Gets the affectedCustomers value for this Defect.
     * 
     * @return affectedCustomers
     */
    public java.lang.String getAffectedCustomers() {
        return affectedCustomers;
    }


    /**
     * Sets the affectedCustomers value for this Defect.
     * 
     * @param affectedCustomers
     */
    public void setAffectedCustomers(java.lang.String affectedCustomers) {
        this.affectedCustomers = affectedCustomers;
    }


    /**
     * Gets the bugzilla value for this Defect.
     * 
     * @return bugzilla
     */
    public com.rallydev.webservice.v1_19.domain.WebLink getBugzilla() {
        return bugzilla;
    }


    /**
     * Sets the bugzilla value for this Defect.
     * 
     * @param bugzilla
     */
    public void setBugzilla(com.rallydev.webservice.v1_19.domain.WebLink bugzilla) {
        this.bugzilla = bugzilla;
    }


    /**
     * Gets the CQDefectID value for this Defect.
     * 
     * @return CQDefectID
     */
    public java.lang.String getCQDefectID() {
        return CQDefectID;
    }


    /**
     * Sets the CQDefectID value for this Defect.
     * 
     * @param CQDefectID
     */
    public void setCQDefectID(java.lang.String CQDefectID) {
        this.CQDefectID = CQDefectID;
    }


    /**
     * Gets the customer value for this Defect.
     * 
     * @return customer
     */
    public java.lang.String getCustomer() {
        return customer;
    }


    /**
     * Sets the customer value for this Defect.
     * 
     * @param customer
     */
    public void setCustomer(java.lang.String customer) {
        this.customer = customer;
    }


    /**
     * Gets the jira value for this Defect.
     * 
     * @return jira
     */
    public com.rallydev.webservice.v1_19.domain.WebLink getJira() {
        return jira;
    }


    /**
     * Sets the jira value for this Defect.
     * 
     * @param jira
     */
    public void setJira(com.rallydev.webservice.v1_19.domain.WebLink jira) {
        this.jira = jira;
    }


    /**
     * Gets the kanbanState value for this Defect.
     * 
     * @return kanbanState
     */
    public java.lang.String getKanbanState() {
        return kanbanState;
    }


    /**
     * Sets the kanbanState value for this Defect.
     * 
     * @param kanbanState
     */
    public void setKanbanState(java.lang.String kanbanState) {
        this.kanbanState = kanbanState;
    }


    /**
     * Gets the numberofCases value for this Defect.
     * 
     * @return numberofCases
     */
    public java.lang.Long getNumberofCases() {
        return numberofCases;
    }


    /**
     * Sets the numberofCases value for this Defect.
     * 
     * @param numberofCases
     */
    public void setNumberofCases(java.lang.Long numberofCases) {
        this.numberofCases = numberofCases;
    }


    /**
     * Gets the QCDefectID value for this Defect.
     * 
     * @return QCDefectID
     */
    public java.lang.String getQCDefectID() {
        return QCDefectID;
    }


    /**
     * Sets the QCDefectID value for this Defect.
     * 
     * @param QCDefectID
     */
    public void setQCDefectID(java.lang.String QCDefectID) {
        this.QCDefectID = QCDefectID;
    }


    /**
     * Gets the salesforceCase value for this Defect.
     * 
     * @return salesforceCase
     */
    public com.rallydev.webservice.v1_19.domain.WebLink getSalesforceCase() {
        return salesforceCase;
    }


    /**
     * Sets the salesforceCase value for this Defect.
     * 
     * @param salesforceCase
     */
    public void setSalesforceCase(com.rallydev.webservice.v1_19.domain.WebLink salesforceCase) {
        this.salesforceCase = salesforceCase;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Defect)) return false;
        Defect other = (Defect) obj;
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
            ((this.affectsDoc==null && other.getAffectsDoc()==null) || 
             (this.affectsDoc!=null &&
              this.affectsDoc.equals(other.getAffectsDoc()))) &&
            ((this.attachments==null && other.getAttachments()==null) || 
             (this.attachments!=null &&
              java.util.Arrays.equals(this.attachments, other.getAttachments()))) &&
            ((this.blocked==null && other.getBlocked()==null) || 
             (this.blocked!=null &&
              this.blocked.equals(other.getBlocked()))) &&
            ((this.blocker==null && other.getBlocker()==null) || 
             (this.blocker!=null &&
              this.blocker.equals(other.getBlocker()))) &&
            ((this.closedDate==null && other.getClosedDate()==null) || 
             (this.closedDate!=null &&
              this.closedDate.equals(other.getClosedDate()))) &&
            ((this.duplicates==null && other.getDuplicates()==null) || 
             (this.duplicates!=null &&
              java.util.Arrays.equals(this.duplicates, other.getDuplicates()))) &&
            ((this.environment==null && other.getEnvironment()==null) || 
             (this.environment!=null &&
              this.environment.equals(other.getEnvironment()))) &&
            ((this.fixedInBuild==null && other.getFixedInBuild()==null) || 
             (this.fixedInBuild!=null &&
              this.fixedInBuild.equals(other.getFixedInBuild()))) &&
            ((this.foundInBuild==null && other.getFoundInBuild()==null) || 
             (this.foundInBuild!=null &&
              this.foundInBuild.equals(other.getFoundInBuild()))) &&
            ((this.iteration==null && other.getIteration()==null) || 
             (this.iteration!=null &&
              this.iteration.equals(other.getIteration()))) &&
            ((this.openedDate==null && other.getOpenedDate()==null) || 
             (this.openedDate!=null &&
              this.openedDate.equals(other.getOpenedDate()))) &&
            ((this._package==null && other.get_package()==null) || 
             (this._package!=null &&
              this._package.equals(other.get_package()))) &&
            ((this.planEstimate==null && other.getPlanEstimate()==null) || 
             (this.planEstimate!=null &&
              this.planEstimate.equals(other.getPlanEstimate()))) &&
            ((this.priority==null && other.getPriority()==null) || 
             (this.priority!=null &&
              this.priority.equals(other.getPriority()))) &&
            ((this.rank==null && other.getRank()==null) || 
             (this.rank!=null &&
              this.rank.equals(other.getRank()))) &&
            ((this.release==null && other.getRelease()==null) || 
             (this.release!=null &&
              this.release.equals(other.getRelease()))) &&
            ((this.releaseNote==null && other.getReleaseNote()==null) || 
             (this.releaseNote!=null &&
              this.releaseNote.equals(other.getReleaseNote()))) &&
            ((this.requirement==null && other.getRequirement()==null) || 
             (this.requirement!=null &&
              this.requirement.equals(other.getRequirement()))) &&
            ((this.resolution==null && other.getResolution()==null) || 
             (this.resolution!=null &&
              this.resolution.equals(other.getResolution()))) &&
            ((this.salesforceCaseID==null && other.getSalesforceCaseID()==null) || 
             (this.salesforceCaseID!=null &&
              this.salesforceCaseID.equals(other.getSalesforceCaseID()))) &&
            ((this.salesforceCaseNumber==null && other.getSalesforceCaseNumber()==null) || 
             (this.salesforceCaseNumber!=null &&
              this.salesforceCaseNumber.equals(other.getSalesforceCaseNumber()))) &&
            ((this.scheduleState==null && other.getScheduleState()==null) || 
             (this.scheduleState!=null &&
              this.scheduleState.equals(other.getScheduleState()))) &&
            ((this.severity==null && other.getSeverity()==null) || 
             (this.severity!=null &&
              this.severity.equals(other.getSeverity()))) &&
            ((this.state==null && other.getState()==null) || 
             (this.state!=null &&
              this.state.equals(other.getState()))) &&
            ((this.submittedBy==null && other.getSubmittedBy()==null) || 
             (this.submittedBy!=null &&
              this.submittedBy.equals(other.getSubmittedBy()))) &&
            ((this.targetBuild==null && other.getTargetBuild()==null) || 
             (this.targetBuild!=null &&
              this.targetBuild.equals(other.getTargetBuild()))) &&
            ((this.targetDate==null && other.getTargetDate()==null) || 
             (this.targetDate!=null &&
              this.targetDate.equals(other.getTargetDate()))) &&
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
            ((this.testCase==null && other.getTestCase()==null) || 
             (this.testCase!=null &&
              this.testCase.equals(other.getTestCase()))) &&
            ((this.testCaseResult==null && other.getTestCaseResult()==null) || 
             (this.testCaseResult!=null &&
              this.testCaseResult.equals(other.getTestCaseResult()))) &&
            ((this.testCases==null && other.getTestCases()==null) || 
             (this.testCases!=null &&
              java.util.Arrays.equals(this.testCases, other.getTestCases()))) &&
            ((this.verifiedInBuild==null && other.getVerifiedInBuild()==null) || 
             (this.verifiedInBuild!=null &&
              this.verifiedInBuild.equals(other.getVerifiedInBuild()))) &&
            ((this.affectedCustomers==null && other.getAffectedCustomers()==null) || 
             (this.affectedCustomers!=null &&
              this.affectedCustomers.equals(other.getAffectedCustomers()))) &&
            ((this.bugzilla==null && other.getBugzilla()==null) || 
             (this.bugzilla!=null &&
              this.bugzilla.equals(other.getBugzilla()))) &&
            ((this.CQDefectID==null && other.getCQDefectID()==null) || 
             (this.CQDefectID!=null &&
              this.CQDefectID.equals(other.getCQDefectID()))) &&
            ((this.customer==null && other.getCustomer()==null) || 
             (this.customer!=null &&
              this.customer.equals(other.getCustomer()))) &&
            ((this.jira==null && other.getJira()==null) || 
             (this.jira!=null &&
              this.jira.equals(other.getJira()))) &&
            ((this.kanbanState==null && other.getKanbanState()==null) || 
             (this.kanbanState!=null &&
              this.kanbanState.equals(other.getKanbanState()))) &&
            ((this.numberofCases==null && other.getNumberofCases()==null) || 
             (this.numberofCases!=null &&
              this.numberofCases.equals(other.getNumberofCases()))) &&
            ((this.QCDefectID==null && other.getQCDefectID()==null) || 
             (this.QCDefectID!=null &&
              this.QCDefectID.equals(other.getQCDefectID()))) &&
            ((this.salesforceCase==null && other.getSalesforceCase()==null) || 
             (this.salesforceCase!=null &&
              this.salesforceCase.equals(other.getSalesforceCase())));
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
        if (getAffectsDoc() != null) {
            _hashCode += getAffectsDoc().hashCode();
        }
        if (getAttachments() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAttachments());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAttachments(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getBlocked() != null) {
            _hashCode += getBlocked().hashCode();
        }
        if (getBlocker() != null) {
            _hashCode += getBlocker().hashCode();
        }
        if (getClosedDate() != null) {
            _hashCode += getClosedDate().hashCode();
        }
        if (getDuplicates() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDuplicates());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDuplicates(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getEnvironment() != null) {
            _hashCode += getEnvironment().hashCode();
        }
        if (getFixedInBuild() != null) {
            _hashCode += getFixedInBuild().hashCode();
        }
        if (getFoundInBuild() != null) {
            _hashCode += getFoundInBuild().hashCode();
        }
        if (getIteration() != null) {
            _hashCode += getIteration().hashCode();
        }
        if (getOpenedDate() != null) {
            _hashCode += getOpenedDate().hashCode();
        }
        if (get_package() != null) {
            _hashCode += get_package().hashCode();
        }
        if (getPlanEstimate() != null) {
            _hashCode += getPlanEstimate().hashCode();
        }
        if (getPriority() != null) {
            _hashCode += getPriority().hashCode();
        }
        if (getRank() != null) {
            _hashCode += getRank().hashCode();
        }
        if (getRelease() != null) {
            _hashCode += getRelease().hashCode();
        }
        if (getReleaseNote() != null) {
            _hashCode += getReleaseNote().hashCode();
        }
        if (getRequirement() != null) {
            _hashCode += getRequirement().hashCode();
        }
        if (getResolution() != null) {
            _hashCode += getResolution().hashCode();
        }
        if (getSalesforceCaseID() != null) {
            _hashCode += getSalesforceCaseID().hashCode();
        }
        if (getSalesforceCaseNumber() != null) {
            _hashCode += getSalesforceCaseNumber().hashCode();
        }
        if (getScheduleState() != null) {
            _hashCode += getScheduleState().hashCode();
        }
        if (getSeverity() != null) {
            _hashCode += getSeverity().hashCode();
        }
        if (getState() != null) {
            _hashCode += getState().hashCode();
        }
        if (getSubmittedBy() != null) {
            _hashCode += getSubmittedBy().hashCode();
        }
        if (getTargetBuild() != null) {
            _hashCode += getTargetBuild().hashCode();
        }
        if (getTargetDate() != null) {
            _hashCode += getTargetDate().hashCode();
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
        if (getTestCase() != null) {
            _hashCode += getTestCase().hashCode();
        }
        if (getTestCaseResult() != null) {
            _hashCode += getTestCaseResult().hashCode();
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
        if (getVerifiedInBuild() != null) {
            _hashCode += getVerifiedInBuild().hashCode();
        }
        if (getAffectedCustomers() != null) {
            _hashCode += getAffectedCustomers().hashCode();
        }
        if (getBugzilla() != null) {
            _hashCode += getBugzilla().hashCode();
        }
        if (getCQDefectID() != null) {
            _hashCode += getCQDefectID().hashCode();
        }
        if (getCustomer() != null) {
            _hashCode += getCustomer().hashCode();
        }
        if (getJira() != null) {
            _hashCode += getJira().hashCode();
        }
        if (getKanbanState() != null) {
            _hashCode += getKanbanState().hashCode();
        }
        if (getNumberofCases() != null) {
            _hashCode += getNumberofCases().hashCode();
        }
        if (getQCDefectID() != null) {
            _hashCode += getQCDefectID().hashCode();
        }
        if (getSalesforceCase() != null) {
            _hashCode += getSalesforceCase().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Defect.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "Defect"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("acceptedDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AcceptedDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("affectsDoc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AffectsDoc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attachments");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Attachments"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "Attachment"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "Attachment"));
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
        elemField.setFieldName("closedDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ClosedDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("duplicates");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Duplicates"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "Defect"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "Defect"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("environment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Environment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fixedInBuild");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FixedInBuild"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("foundInBuild");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FoundInBuild"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("iteration");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Iteration"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "Iteration"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("openedDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OpenedDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("_package");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Package"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("priority");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Priority"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
        elemField.setFieldName("releaseNote");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ReleaseNote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requirement");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Requirement"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "Requirement"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resolution");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Resolution"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesforceCaseID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SalesforceCaseID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesforceCaseNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SalesforceCaseNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("severity");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Severity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("state");
        elemField.setXmlName(new javax.xml.namespace.QName("", "State"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("submittedBy");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SubmittedBy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "User"));
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
        elemField.setFieldName("targetDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TargetDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
        elemField.setFieldName("testCase");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TestCase"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "TestCase"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("testCaseResult");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TestCaseResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "TestCaseResult"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
        elemField.setFieldName("verifiedInBuild");
        elemField.setXmlName(new javax.xml.namespace.QName("", "VerifiedInBuild"));
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
        elemField.setFieldName("bugzilla");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Bugzilla"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "WebLink"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CQDefectID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CQDefectID"));
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
        elemField.setFieldName("jira");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Jira"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "WebLink"));
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
        elemField.setFieldName("QCDefectID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "QCDefectID"));
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
