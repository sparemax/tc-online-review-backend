/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.management.phase.autopilot.failuretests;

import com.topcoder.management.project.*;

import com.topcoder.search.builder.filter.Filter;

import java.util.List;


/**
 * A mock class implements <code>ProjectManager</code> interface.
 *
 * @author skatou
 * @version 1.0
 */
public class MockProjectManager implements ProjectManager {
    /** Whether to throw exception in searchProjects method. */
    private static boolean searchProjectsException = false;

    /**
     * Creates a new MockProjectManager object.
     */
    public MockProjectManager() {
    }

    /**
     * Sets the value of searchProjectsException.
     *
     * @param searchProjectsException whether a phase can start.
     */
    public static void setSearchProjectsException(boolean searchProjectsException) {
        MockProjectManager.searchProjectsException = searchProjectsException;
    }

    /**
     * Do nothing.
     *
     * @param project ignore.
     * @param operator ignore.
     *
     * @throws PersistenceException never.
     * @throws ValidationException never.
     */
    public void createProject(Project project, String operator)
        throws PersistenceException, ValidationException {
    }

    /**
     * Do nothing.
     *
     * @param project ignore.
     * @param reason ignore.
     * @param operator ignore.
     *
     * @throws PersistenceException never.
     * @throws ValidationException never.
     */
    public void updateProject(Project project, String reason, String operator)
        throws PersistenceException, ValidationException {
    }

    /**
     * Returns null.
     *
     * @param id ignore.
     *
     * @return null.
     *
     * @throws PersistenceException never.
     */
    public Project getProject(long id) throws PersistenceException {
        return null;
    }

    /**
     * Returns null.
     *
     * @param ids ignore.
     *
     * @return null.
     *
     * @throws PersistenceException never.
     */
    public Project[] getProjects(long[] ids) throws PersistenceException {
        return null;
    }

    /**
     * Returns one project instance in an array.
     *
     * @param filter ignore.
     *
     * @return one project instance in an array.
     *
     * @throws PersistenceException if searchProjectsException is set.
     */
    public Project[] searchProjects(Filter filter) throws PersistenceException {
        if (searchProjectsException) {
            throw new PersistenceException("");
        }

        ProjectCategory category = new ProjectCategory(2, "name", new ProjectType(2, "name"));
        ProjectStatus status = new ProjectStatus(2, "name");

        return new Project[] {new Project(16, category, status) };
    }

    /**
     * Returns null.
     *
     * @param user ignore.
     *
     * @return null.
     *
     * @throws PersistenceException never.
     */
    public Project[] getUserProjects(long user) throws PersistenceException {
        return null;
    }

    /**
     * Returns null.
     *
     * @return null.
     *
     * @throws PersistenceException never.
     */
    public ProjectType[] getAllProjectTypes() throws PersistenceException {
        return null;
    }

    /**
     * Returns null.
     *
     * @return null.
     *
     * @throws PersistenceException never.
     */
    public ProjectCategory[] getAllProjectCategories()
        throws PersistenceException {
        return null;
    }

    /**
     * Returns null.
     *
     * @return null.
     *
     * @throws PersistenceException never.
     */
    public ProjectStatus[] getAllProjectStatuses() throws PersistenceException {
        return null;
    }

    /**
     * Returns null.
     *
     * @return null.
     *
     * @throws PersistenceException never.
     */
    public ProjectPropertyType[] getAllProjectPropertyTypes()
        throws PersistenceException {
        return null;
    }

    @Override
    public Project[] getProjectsByDirectProjectId(long directProjectId) throws PersistenceException {
        return new Project[0];
    }

    @Override
    public FileType[] getProjectFileTypes(long projectId) throws PersistenceException {
        return new FileType[0];
    }

    @Override
    public void updateProjectFileTypes(long projectId, List<FileType> fileTypes, String operator) throws PersistenceException {

    }

    @Override
    public Prize[] getProjectPrizes(long projectId) throws PersistenceException {
        return new Prize[0];
    }

    @Override
    public void updateProjectPrizes(long projectId, List<Prize> prizes, String operator) throws PersistenceException {

    }

    @Override
    public FileType createFileType(FileType fileType, String operator) throws PersistenceException {
        return null;
    }

    @Override
    public void updateFileType(FileType fileType, String operator) throws PersistenceException {

    }

    @Override
    public void removeFileType(FileType fileType, String operator) throws PersistenceException {

    }

    @Override
    public FileType[] getAllFileTypes() throws PersistenceException {
        return new FileType[0];
    }

    @Override
    public PrizeType[] getPrizeTypes() throws PersistenceException {
        return new PrizeType[0];
    }

    @Override
    public Prize createPrize(Prize prize, String operator) throws PersistenceException {
        return null;
    }

    @Override
    public void updatePrize(Prize prize, String operator) throws PersistenceException {

    }

    @Override
    public void removePrize(Prize prize, String operator) throws PersistenceException {

    }

    @Override
    public ProjectStudioSpecification createProjectStudioSpecification(ProjectStudioSpecification spec, String operator) throws PersistenceException {
        return null;
    }

    @Override
    public void updateProjectStudioSpecification(ProjectStudioSpecification spec, String operator) throws PersistenceException {

    }

    @Override
    public void removeProjectStudioSpecification(ProjectStudioSpecification spec, String operator) throws PersistenceException {

    }

    @Override
    public ProjectStudioSpecification getProjectStudioSpecification(long projectId) throws PersistenceException {
        return null;
    }

    @Override
    public void updateStudioSpecificationForProject(ProjectStudioSpecification spec, long projectId, String operator) throws PersistenceException {

    }
}
