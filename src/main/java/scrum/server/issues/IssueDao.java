package scrum.server.issues;

import ilarkesto.base.time.DateAndTime;
import ilarkesto.fp.Predicate;

import java.util.Set;

import scrum.server.project.Project;

public class IssueDao extends GIssueDao {

	public Set<Issue> getAcceptedIssues(final Project project) {
		return getEntities(new Predicate<Issue>() {

			@Override
			public boolean test(Issue issue) {
				if (!issue.isProject(project)) return false;
				if (issue.isClosed()) return false;
				return issue.isAccepted();
			}
		});
	}

	public Set<Issue> getClosedIssues(final Project project) {
		return getEntities(new Predicate<Issue>() {

			@Override
			public boolean test(Issue issue) {
				if (!issue.isProject(project)) return false;
				return issue.isClosed();
			}
		});
	}

	public Set<Issue> getOpenIssues(final Project project) {
		return getEntities(new Predicate<Issue>() {

			@Override
			public boolean test(Issue issue) {
				if (!issue.isProject(project)) return false;
				return issue.isOpen();
			}
		});
	}

	public Set<Issue> getPublishedIssues(final Project project) {
		return getEntities(new Predicate<Issue>() {

			@Override
			public boolean test(Issue issue) {
				if (!issue.isProject(project)) return false;
				return issue.isPublished();
			}
		});
	}

	public Set<Issue> getOpenBugs(final Project project) {
		return getEntities(new Predicate<Issue>() {

			@Override
			public boolean test(Issue issue) {
				if (!issue.isProject(project)) return false;
				if (issue.isClosed()) return false;
				return issue.isBug();
			}
		});
	}

	public Set<Issue> getOpenIdeas(final Project project) {
		return getEntities(new Predicate<Issue>() {

			@Override
			public boolean test(Issue issue) {
				if (!issue.isProject(project)) return false;
				if (issue.isClosed()) return false;
				return issue.isIdea();
			}
		});
	}

	public Issue getIssueByNumber(final int number, final Project project) {
		return getEntity(new Predicate<Issue>() {

			@Override
			public boolean test(Issue t) {
				return t.isNumber(number) && t.isProject(project);
			}
		});
	}

	public Issue postIssue(Project project, String label, String text, String issuerName, String issuerEmail,
			boolean publish) {
		Issue issue = newEntityInstance();
		issue.setProject(project);
		issue.setLabel(label);
		issue.setDescription(text);
		issue.setDate(DateAndTime.now());
		issue.setIssuerName(issuerName);
		issue.setIssuerEmail(issuerEmail);
		issue.setPublished(publish);
		issue.updateNumber();
		saveEntity(issue);
		return issue;
	}

	public Issue postIssue(Project project, String label) {
		Issue issue = newEntityInstance();
		issue.setProject(project);
		issue.setLabel(label);
		saveEntity(issue);
		return issue;
	}
}