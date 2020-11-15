package com.github.lusingander.kraphql.github

fun query(init: Query.() -> Unit) = Query().apply(init)
fun mutation(init: Mutation.() -> Unit) = Mutation().apply(init)

typealias ID = String
typealias Date = String
typealias DateTime = String
typealias GitObjectID = String
typealias GitRefname = String
typealias GitSSHRemote = String
typealias GitTimestamp = String
typealias HTML = String
typealias PreciseDateTime = String
typealias URI = String
typealias X509Certificate = String

@DslMarker
annotation class GraphQLMarker

@GraphQLMarker
open class ObjectNode(protected val __name: String) {
    private val children = mutableListOf<ObjectNode>()
    private val argsMap: MutableMap<String, Any?> = mutableMapOf()

    fun <T : ObjectNode> doInit(child: T, init: T.() -> Unit = {}) {
        child.init()
        children.add(child)
    }

    fun addArgs(k: String, v: Any?) = argsMap.put(k, v)

    override fun toString() =
        "$__name${argsStr()} { ${children.joinToString(" ")} }"

    private fun argsStr(): String {
        val filtered = argsMap.filter { (_, v) ->
            v != null
        }
        if (filtered.isEmpty()) {
            return ""
        }
        val str = filtered.map { (k, v) ->
            if (v is String) "$k: \"$v\"" else "$k: $v"
        }.joinToString(separator = ", ")
        return "($str)"
    }
}

open class ScalarNode(__name: String): ObjectNode(__name) {
    override fun toString() = __name
}

open class ScalarWithArgsNode(__name: String, private val args: Map<String, Any?>): ObjectNode(__name) {
    override fun toString(): String {
        val filtered = args.filter { (_, v) ->
            v != null
        }
        if (filtered.isEmpty()) {
            return __name
        }
        val argsStr = filtered.map {
            if (it.value is String) "${it.key}: \"${it.value}\"" else "${it.key}: ${it.value}"
        }.joinToString(separator = ", ")
        return "$__name($argsStr)"
    }
}

enum class AuditLogOrderField {
    CREATED_AT,
    ;
}

enum class CheckAnnotationLevel {
    FAILURE,
    NOTICE,
    WARNING,
    ;
}

enum class CheckConclusionState {
    ACTION_REQUIRED,
    CANCELLED,
    FAILURE,
    NEUTRAL,
    SKIPPED,
    STALE,
    SUCCESS,
    TIMED_OUT,
    ;
}

enum class CheckRunType {
    ALL,
    LATEST,
    ;
}

enum class CheckStatusState {
    COMPLETED,
    IN_PROGRESS,
    QUEUED,
    REQUESTED,
    ;
}

enum class CollaboratorAffiliation {
    ALL,
    DIRECT,
    OUTSIDE,
    ;
}

enum class CommentAuthorAssociation {
    COLLABORATOR,
    CONTRIBUTOR,
    FIRST_TIMER,
    FIRST_TIME_CONTRIBUTOR,
    MANNEQUIN,
    MEMBER,
    NONE,
    OWNER,
    ;
}

enum class CommentCannotUpdateReason {
    ARCHIVED,
    DENIED,
    INSUFFICIENT_ACCESS,
    LOCKED,
    LOGIN_REQUIRED,
    MAINTENANCE,
    VERIFIED_EMAIL_REQUIRED,
    ;
}

enum class CommitContributionOrderField {
    COMMIT_COUNT,
    OCCURRED_AT,
    ;
}

enum class DefaultRepositoryPermissionField {
    ADMIN,
    NONE,
    READ,
    WRITE,
    ;
}

enum class DeploymentOrderField {
    CREATED_AT,
    ;
}

enum class DeploymentState {
    ABANDONED,
    ACTIVE,
    DESTROYED,
    ERROR,
    FAILURE,
    INACTIVE,
    IN_PROGRESS,
    PENDING,
    QUEUED,
    ;
}

enum class DeploymentStatusState {
    ERROR,
    FAILURE,
    INACTIVE,
    IN_PROGRESS,
    PENDING,
    QUEUED,
    SUCCESS,
    ;
}

enum class DiffSide {
    LEFT,
    RIGHT,
    ;
}

enum class EnterpriseAdministratorInvitationOrderField {
    CREATED_AT,
    ;
}

enum class EnterpriseAdministratorRole {
    BILLING_MANAGER,
    OWNER,
    ;
}

enum class EnterpriseDefaultRepositoryPermissionSettingValue {
    ADMIN,
    NONE,
    NO_POLICY,
    READ,
    WRITE,
    ;
}

enum class EnterpriseEnabledDisabledSettingValue {
    DISABLED,
    ENABLED,
    NO_POLICY,
    ;
}

enum class EnterpriseEnabledSettingValue {
    ENABLED,
    NO_POLICY,
    ;
}

enum class EnterpriseMemberOrderField {
    CREATED_AT,
    LOGIN,
    ;
}

enum class EnterpriseMembersCanCreateRepositoriesSettingValue {
    ALL,
    DISABLED,
    NO_POLICY,
    PRIVATE,
    PUBLIC,
    ;
}

enum class EnterpriseMembersCanMakePurchasesSettingValue {
    DISABLED,
    ENABLED,
    ;
}

enum class EnterpriseServerInstallationOrderField {
    CREATED_AT,
    CUSTOMER_NAME,
    HOST_NAME,
    ;
}

enum class EnterpriseServerUserAccountEmailOrderField {
    EMAIL,
    ;
}

enum class EnterpriseServerUserAccountOrderField {
    LOGIN,
    REMOTE_CREATED_AT,
    ;
}

enum class EnterpriseServerUserAccountsUploadOrderField {
    CREATED_AT,
    ;
}

enum class EnterpriseServerUserAccountsUploadSyncState {
    FAILURE,
    PENDING,
    SUCCESS,
    ;
}

enum class EnterpriseUserAccountMembershipRole {
    MEMBER,
    OWNER,
    ;
}

enum class EnterpriseUserDeployment {
    CLOUD,
    SERVER,
    ;
}

enum class FileViewedState {
    DISMISSED,
    UNVIEWED,
    VIEWED,
    ;
}

enum class FundingPlatform {
    COMMUNITY_BRIDGE,
    CUSTOM,
    GITHUB,
    ISSUEHUNT,
    KO_FI,
    LIBERAPAY,
    OPEN_COLLECTIVE,
    OTECHIE,
    PATREON,
    TIDELIFT,
    ;
}

enum class GistOrderField {
    CREATED_AT,
    PUSHED_AT,
    UPDATED_AT,
    ;
}

enum class GistPrivacy {
    ALL,
    PUBLIC,
    SECRET,
    ;
}

enum class GitSignatureState {
    BAD_CERT,
    BAD_EMAIL,
    EXPIRED_KEY,
    GPGVERIFY_ERROR,
    GPGVERIFY_UNAVAILABLE,
    INVALID,
    MALFORMED_SIG,
    NOT_SIGNING_KEY,
    NO_USER,
    OCSP_ERROR,
    OCSP_PENDING,
    OCSP_REVOKED,
    UNKNOWN_KEY,
    UNKNOWN_SIG_TYPE,
    UNSIGNED,
    UNVERIFIED_EMAIL,
    VALID,
    ;
}

enum class IdentityProviderConfigurationState {
    CONFIGURED,
    ENFORCED,
    UNCONFIGURED,
    ;
}

enum class IpAllowListEnabledSettingValue {
    DISABLED,
    ENABLED,
    ;
}

enum class IpAllowListEntryOrderField {
    ALLOW_LIST_VALUE,
    CREATED_AT,
    ;
}

enum class IssueOrderField {
    COMMENTS,
    CREATED_AT,
    UPDATED_AT,
    ;
}

enum class IssueState {
    CLOSED,
    OPEN,
    ;
}

enum class IssueTimelineItemsItemType {
    ADDED_TO_PROJECT_EVENT,
    ASSIGNED_EVENT,
    CLOSED_EVENT,
    COMMENT_DELETED_EVENT,
    CONNECTED_EVENT,
    CONVERTED_NOTE_TO_ISSUE_EVENT,
    CROSS_REFERENCED_EVENT,
    DEMILESTONED_EVENT,
    DISCONNECTED_EVENT,
    ISSUE_COMMENT,
    LABELED_EVENT,
    LOCKED_EVENT,
    MARKED_AS_DUPLICATE_EVENT,
    MENTIONED_EVENT,
    MILESTONED_EVENT,
    MOVED_COLUMNS_IN_PROJECT_EVENT,
    PINNED_EVENT,
    REFERENCED_EVENT,
    REMOVED_FROM_PROJECT_EVENT,
    RENAMED_TITLE_EVENT,
    REOPENED_EVENT,
    SUBSCRIBED_EVENT,
    TRANSFERRED_EVENT,
    UNASSIGNED_EVENT,
    UNLABELED_EVENT,
    UNLOCKED_EVENT,
    UNMARKED_AS_DUPLICATE_EVENT,
    UNPINNED_EVENT,
    UNSUBSCRIBED_EVENT,
    USER_BLOCKED_EVENT,
    ;
}

enum class LabelOrderField {
    CREATED_AT,
    NAME,
    ;
}

enum class LanguageOrderField {
    SIZE,
    ;
}

enum class LockReason {
    OFF_TOPIC,
    RESOLVED,
    SPAM,
    TOO_HEATED,
    ;
}

enum class MergeStateStatus {
    BEHIND,
    BLOCKED,
    CLEAN,
    DIRTY,
    DRAFT,
    HAS_HOOKS,
    UNKNOWN,
    UNSTABLE,
    ;
}

enum class MergeableState {
    CONFLICTING,
    MERGEABLE,
    UNKNOWN,
    ;
}

enum class MilestoneOrderField {
    CREATED_AT,
    DUE_DATE,
    NUMBER,
    UPDATED_AT,
    ;
}

enum class MilestoneState {
    CLOSED,
    OPEN,
    ;
}

enum class OauthApplicationCreateAuditEntryState {
    ACTIVE,
    PENDING_DELETION,
    SUSPENDED,
    ;
}

enum class OperationType {
    ACCESS,
    AUTHENTICATION,
    CREATE,
    MODIFY,
    REMOVE,
    RESTORE,
    TRANSFER,
    ;
}

enum class OrderDirection {
    ASC,
    DESC,
    ;
}

enum class OrgAddMemberAuditEntryPermission {
    ADMIN,
    READ,
    ;
}

enum class OrgCreateAuditEntryBillingPlan {
    BUSINESS,
    BUSINESS_PLUS,
    FREE,
    TIERED_PER_SEAT,
    UNLIMITED,
    ;
}

enum class OrgRemoveBillingManagerAuditEntryReason {
    SAML_EXTERNAL_IDENTITY_MISSING,
    SAML_SSO_ENFORCEMENT_REQUIRES_EXTERNAL_IDENTITY,
    TWO_FACTOR_REQUIREMENT_NON_COMPLIANCE,
    ;
}

enum class OrgRemoveMemberAuditEntryMembershipType {
    ADMIN,
    BILLING_MANAGER,
    DIRECT_MEMBER,
    OUTSIDE_COLLABORATOR,
    UNAFFILIATED,
    ;
}

enum class OrgRemoveMemberAuditEntryReason {
    SAML_EXTERNAL_IDENTITY_MISSING,
    SAML_SSO_ENFORCEMENT_REQUIRES_EXTERNAL_IDENTITY,
    TWO_FACTOR_ACCOUNT_RECOVERY,
    TWO_FACTOR_REQUIREMENT_NON_COMPLIANCE,
    USER_ACCOUNT_DELETED,
    ;
}

enum class OrgRemoveOutsideCollaboratorAuditEntryMembershipType {
    BILLING_MANAGER,
    OUTSIDE_COLLABORATOR,
    UNAFFILIATED,
    ;
}

enum class OrgRemoveOutsideCollaboratorAuditEntryReason {
    SAML_EXTERNAL_IDENTITY_MISSING,
    TWO_FACTOR_REQUIREMENT_NON_COMPLIANCE,
    ;
}

enum class OrgUpdateDefaultRepositoryPermissionAuditEntryPermission {
    ADMIN,
    NONE,
    READ,
    WRITE,
    ;
}

enum class OrgUpdateMemberAuditEntryPermission {
    ADMIN,
    READ,
    ;
}

enum class OrgUpdateMemberRepositoryCreationPermissionAuditEntryVisibility {
    ALL,
    INTERNAL,
    NONE,
    PRIVATE,
    PRIVATE_INTERNAL,
    PUBLIC,
    PUBLIC_INTERNAL,
    PUBLIC_PRIVATE,
    ;
}

enum class OrganizationInvitationRole {
    ADMIN,
    BILLING_MANAGER,
    DIRECT_MEMBER,
    REINSTATE,
    ;
}

enum class OrganizationInvitationType {
    EMAIL,
    USER,
    ;
}

enum class OrganizationMemberRole {
    ADMIN,
    MEMBER,
    ;
}

enum class OrganizationMembersCanCreateRepositoriesSettingValue {
    ALL,
    DISABLED,
    PRIVATE,
    ;
}

enum class OrganizationOrderField {
    CREATED_AT,
    LOGIN,
    ;
}

enum class PackageFileOrderField {
    CREATED_AT,
    ;
}

enum class PackageOrderField {
    CREATED_AT,
    ;
}

enum class PackageType {
    DEBIAN,
    DOCKER,
    MAVEN,
    NPM,
    NUGET,
    PYPI,
    RUBYGEMS,
    ;
}

enum class PackageVersionOrderField {
    CREATED_AT,
    ;
}

enum class PinnableItemType {
    GIST,
    ISSUE,
    ORGANIZATION,
    PROJECT,
    PULL_REQUEST,
    REPOSITORY,
    TEAM,
    USER,
    ;
}

enum class ProjectCardArchivedState {
    ARCHIVED,
    NOT_ARCHIVED,
    ;
}

enum class ProjectCardState {
    CONTENT_ONLY,
    NOTE_ONLY,
    REDACTED,
    ;
}

enum class ProjectColumnPurpose {
    DONE,
    IN_PROGRESS,
    TODO,
    ;
}

enum class ProjectOrderField {
    CREATED_AT,
    NAME,
    UPDATED_AT,
    ;
}

enum class ProjectState {
    CLOSED,
    OPEN,
    ;
}

enum class ProjectTemplate {
    AUTOMATED_KANBAN_V2,
    AUTOMATED_REVIEWS_KANBAN,
    BASIC_KANBAN,
    BUG_TRIAGE,
    ;
}

enum class PullRequestMergeMethod {
    MERGE,
    REBASE,
    SQUASH,
    ;
}

enum class PullRequestOrderField {
    CREATED_AT,
    UPDATED_AT,
    ;
}

enum class PullRequestReviewCommentState {
    PENDING,
    SUBMITTED,
    ;
}

enum class PullRequestReviewDecision {
    APPROVED,
    CHANGES_REQUESTED,
    REVIEW_REQUIRED,
    ;
}

enum class PullRequestReviewEvent {
    APPROVE,
    COMMENT,
    DISMISS,
    REQUEST_CHANGES,
    ;
}

enum class PullRequestReviewState {
    APPROVED,
    CHANGES_REQUESTED,
    COMMENTED,
    DISMISSED,
    PENDING,
    ;
}

enum class PullRequestState {
    CLOSED,
    MERGED,
    OPEN,
    ;
}

enum class PullRequestTimelineItemsItemType {
    ADDED_TO_PROJECT_EVENT,
    ASSIGNED_EVENT,
    AUTOMATIC_BASE_CHANGE_FAILED_EVENT,
    AUTOMATIC_BASE_CHANGE_SUCCEEDED_EVENT,
    BASE_REF_CHANGED_EVENT,
    BASE_REF_DELETED_EVENT,
    BASE_REF_FORCE_PUSHED_EVENT,
    CLOSED_EVENT,
    COMMENT_DELETED_EVENT,
    CONNECTED_EVENT,
    CONVERTED_NOTE_TO_ISSUE_EVENT,
    CONVERT_TO_DRAFT_EVENT,
    CROSS_REFERENCED_EVENT,
    DEMILESTONED_EVENT,
    DEPLOYED_EVENT,
    DEPLOYMENT_ENVIRONMENT_CHANGED_EVENT,
    DISCONNECTED_EVENT,
    HEAD_REF_DELETED_EVENT,
    HEAD_REF_FORCE_PUSHED_EVENT,
    HEAD_REF_RESTORED_EVENT,
    ISSUE_COMMENT,
    LABELED_EVENT,
    LOCKED_EVENT,
    MARKED_AS_DUPLICATE_EVENT,
    MENTIONED_EVENT,
    MERGED_EVENT,
    MILESTONED_EVENT,
    MOVED_COLUMNS_IN_PROJECT_EVENT,
    PINNED_EVENT,
    PULL_REQUEST_COMMIT,
    PULL_REQUEST_COMMIT_COMMENT_THREAD,
    PULL_REQUEST_REVIEW,
    PULL_REQUEST_REVIEW_THREAD,
    PULL_REQUEST_REVISION_MARKER,
    READY_FOR_REVIEW_EVENT,
    REFERENCED_EVENT,
    REMOVED_FROM_PROJECT_EVENT,
    RENAMED_TITLE_EVENT,
    REOPENED_EVENT,
    REVIEW_DISMISSED_EVENT,
    REVIEW_REQUESTED_EVENT,
    REVIEW_REQUEST_REMOVED_EVENT,
    SUBSCRIBED_EVENT,
    TRANSFERRED_EVENT,
    UNASSIGNED_EVENT,
    UNLABELED_EVENT,
    UNLOCKED_EVENT,
    UNMARKED_AS_DUPLICATE_EVENT,
    UNPINNED_EVENT,
    UNSUBSCRIBED_EVENT,
    USER_BLOCKED_EVENT,
    ;
}

enum class PullRequestUpdateState {
    CLOSED,
    OPEN,
    ;
}

enum class ReactionContent {
    CONFUSED,
    EYES,
    HEART,
    HOORAY,
    LAUGH,
    ROCKET,
    THUMBS_DOWN,
    THUMBS_UP,
    ;
}

enum class ReactionOrderField {
    CREATED_AT,
    ;
}

enum class RefOrderField {
    ALPHABETICAL,
    TAG_COMMIT_DATE,
    ;
}

enum class ReleaseOrderField {
    CREATED_AT,
    NAME,
    ;
}

enum class RepoAccessAuditEntryVisibility {
    INTERNAL,
    PRIVATE,
    PUBLIC,
    ;
}

enum class RepoAddMemberAuditEntryVisibility {
    INTERNAL,
    PRIVATE,
    PUBLIC,
    ;
}

enum class RepoArchivedAuditEntryVisibility {
    INTERNAL,
    PRIVATE,
    PUBLIC,
    ;
}

enum class RepoChangeMergeSettingAuditEntryMergeType {
    MERGE,
    REBASE,
    SQUASH,
    ;
}

enum class RepoCreateAuditEntryVisibility {
    INTERNAL,
    PRIVATE,
    PUBLIC,
    ;
}

enum class RepoDestroyAuditEntryVisibility {
    INTERNAL,
    PRIVATE,
    PUBLIC,
    ;
}

enum class RepoRemoveMemberAuditEntryVisibility {
    INTERNAL,
    PRIVATE,
    PUBLIC,
    ;
}

enum class ReportedContentClassifiers {
    ABUSE,
    DUPLICATE,
    OFF_TOPIC,
    OUTDATED,
    RESOLVED,
    SPAM,
    ;
}

enum class RepositoryAffiliation {
    COLLABORATOR,
    ORGANIZATION_MEMBER,
    OWNER,
    ;
}

enum class RepositoryContributionType {
    COMMIT,
    ISSUE,
    PULL_REQUEST,
    PULL_REQUEST_REVIEW,
    REPOSITORY,
    ;
}

enum class RepositoryInvitationOrderField {
    CREATED_AT,
    INVITEE_LOGIN,
    ;
}

enum class RepositoryLockReason {
    BILLING,
    MIGRATING,
    MOVING,
    RENAME,
    ;
}

enum class RepositoryOrderField {
    CREATED_AT,
    NAME,
    PUSHED_AT,
    STARGAZERS,
    UPDATED_AT,
    ;
}

enum class RepositoryPermission {
    ADMIN,
    MAINTAIN,
    READ,
    TRIAGE,
    WRITE,
    ;
}

enum class RepositoryPrivacy {
    PRIVATE,
    PUBLIC,
    ;
}

enum class RepositoryVisibility {
    INTERNAL,
    PRIVATE,
    PUBLIC,
    ;
}

enum class RequestableCheckStatusState {
    COMPLETED,
    IN_PROGRESS,
    QUEUED,
    ;
}

enum class SamlDigestAlgorithm {
    SHA1,
    SHA256,
    SHA384,
    SHA512,
    ;
}

enum class SamlSignatureAlgorithm {
    RSA_SHA1,
    RSA_SHA256,
    RSA_SHA384,
    RSA_SHA512,
    ;
}

enum class SavedReplyOrderField {
    UPDATED_AT,
    ;
}

enum class SearchType {
    ISSUE,
    REPOSITORY,
    USER,
    ;
}

enum class SecurityAdvisoryEcosystem {
    COMPOSER,
    MAVEN,
    NPM,
    NUGET,
    PIP,
    RUBYGEMS,
    ;
}

enum class SecurityAdvisoryIdentifierType {
    CVE,
    GHSA,
    ;
}

enum class SecurityAdvisoryOrderField {
    PUBLISHED_AT,
    UPDATED_AT,
    ;
}

enum class SecurityAdvisorySeverity {
    CRITICAL,
    HIGH,
    LOW,
    MODERATE,
    ;
}

enum class SecurityVulnerabilityOrderField {
    UPDATED_AT,
    ;
}

enum class SponsorsTierOrderField {
    CREATED_AT,
    MONTHLY_PRICE_IN_CENTS,
    ;
}

enum class SponsorshipOrderField {
    CREATED_AT,
    ;
}

enum class SponsorshipPrivacy {
    PRIVATE,
    PUBLIC,
    ;
}

enum class StarOrderField {
    STARRED_AT,
    ;
}

enum class StatusState {
    ERROR,
    EXPECTED,
    FAILURE,
    PENDING,
    SUCCESS,
    ;
}

enum class SubscriptionState {
    IGNORED,
    SUBSCRIBED,
    UNSUBSCRIBED,
    ;
}

enum class TeamDiscussionCommentOrderField {
    NUMBER,
    ;
}

enum class TeamDiscussionOrderField {
    CREATED_AT,
    ;
}

enum class TeamMemberOrderField {
    CREATED_AT,
    LOGIN,
    ;
}

enum class TeamMemberRole {
    MAINTAINER,
    MEMBER,
    ;
}

enum class TeamMembershipType {
    ALL,
    CHILD_TEAM,
    IMMEDIATE,
    ;
}

enum class TeamOrderField {
    NAME,
    ;
}

enum class TeamPrivacy {
    SECRET,
    VISIBLE,
    ;
}

enum class TeamRepositoryOrderField {
    CREATED_AT,
    NAME,
    PERMISSION,
    PUSHED_AT,
    STARGAZERS,
    UPDATED_AT,
    ;
}

enum class TeamReviewAssignmentAlgorithm {
    LOAD_BALANCE,
    ROUND_ROBIN,
    ;
}

enum class TeamRole {
    ADMIN,
    MEMBER,
    ;
}

enum class TopicSuggestionDeclineReason {
    NOT_RELEVANT,
    PERSONAL_PREFERENCE,
    TOO_GENERAL,
    TOO_SPECIFIC,
    ;
}

enum class UserBlockDuration {
    ONE_DAY,
    ONE_MONTH,
    ONE_WEEK,
    PERMANENT,
    THREE_DAYS,
    ;
}

enum class UserStatusOrderField {
    UPDATED_AT,
    ;
}


class AcceptEnterpriseAdministratorInvitationPayload(__name: String = "AcceptEnterpriseAdministratorInvitationPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun invitation(init: EnterpriseAdministratorInvitation.() -> Unit) =
        EnterpriseAdministratorInvitation("invitation").also { doInit(it, init) }
    val message get() =
        ScalarNode("message").also { doInit(it) }
}

class AcceptTopicSuggestionPayload(__name: String = "AcceptTopicSuggestionPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun topic(init: Topic.() -> Unit) =
        Topic("topic").also { doInit(it, init) }
}

class ActorLocation(__name: String = "ActorLocation"): ObjectNode(__name) {
    val city get() =
        ScalarNode("city").also { doInit(it) }
    val country get() =
        ScalarNode("country").also { doInit(it) }
    val countryCode get() =
        ScalarNode("countryCode").also { doInit(it) }
    val region get() =
        ScalarNode("region").also { doInit(it) }
    val regionCode get() =
        ScalarNode("regionCode").also { doInit(it) }
}

class AddAssigneesToAssignablePayload(__name: String = "AddAssigneesToAssignablePayload"): ObjectNode(__name) {
    fun assignable(init: Assignable.() -> Unit) =
        Assignable("assignable").also { doInit(it, init) }
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
}

class AddCommentPayload(__name: String = "AddCommentPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun commentEdge(init: IssueCommentEdge.() -> Unit) =
        IssueCommentEdge("commentEdge").also { doInit(it, init) }
    fun subject(init: Node.() -> Unit) =
        Node("subject").also { doInit(it, init) }
    fun timelineEdge(init: IssueTimelineItemEdge.() -> Unit) =
        IssueTimelineItemEdge("timelineEdge").also { doInit(it, init) }
}

class AddLabelsToLabelablePayload(__name: String = "AddLabelsToLabelablePayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun labelable(init: Labelable.() -> Unit) =
        Labelable("labelable").also { doInit(it, init) }
}

class AddProjectCardPayload(__name: String = "AddProjectCardPayload"): ObjectNode(__name) {
    fun cardEdge(init: ProjectCardEdge.() -> Unit) =
        ProjectCardEdge("cardEdge").also { doInit(it, init) }
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun projectColumn(init: ProjectColumn.() -> Unit) =
        ProjectColumn("projectColumn").also { doInit(it, init) }
}

class AddProjectColumnPayload(__name: String = "AddProjectColumnPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun columnEdge(init: ProjectColumnEdge.() -> Unit) =
        ProjectColumnEdge("columnEdge").also { doInit(it, init) }
    fun project(init: Project.() -> Unit) =
        Project("project").also { doInit(it, init) }
}

class AddPullRequestReviewCommentPayload(__name: String = "AddPullRequestReviewCommentPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun comment(init: PullRequestReviewComment.() -> Unit) =
        PullRequestReviewComment("comment").also { doInit(it, init) }
    fun commentEdge(init: PullRequestReviewCommentEdge.() -> Unit) =
        PullRequestReviewCommentEdge("commentEdge").also { doInit(it, init) }
}

class AddPullRequestReviewPayload(__name: String = "AddPullRequestReviewPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun pullRequestReview(init: PullRequestReview.() -> Unit) =
        PullRequestReview("pullRequestReview").also { doInit(it, init) }
    fun reviewEdge(init: PullRequestReviewEdge.() -> Unit) =
        PullRequestReviewEdge("reviewEdge").also { doInit(it, init) }
}

class AddPullRequestReviewThreadPayload(__name: String = "AddPullRequestReviewThreadPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun thread(init: PullRequestReviewThread.() -> Unit) =
        PullRequestReviewThread("thread").also { doInit(it, init) }
}

class AddReactionPayload(__name: String = "AddReactionPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun reaction(init: Reaction.() -> Unit) =
        Reaction("reaction").also { doInit(it, init) }
    fun subject(init: Reactable.() -> Unit) =
        Reactable("subject").also { doInit(it, init) }
}

class AddStarPayload(__name: String = "AddStarPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun starrable(init: Starrable.() -> Unit) =
        Starrable("starrable").also { doInit(it, init) }
}

class AddedToProjectEvent(__name: String = "AddedToProjectEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun project(init: Project.() -> Unit) =
        Project("project").also { doInit(it, init) }
    fun projectCard(init: ProjectCard.() -> Unit) =
        ProjectCard("projectCard").also { doInit(it, init) }
    val projectColumnName get() =
        ScalarNode("projectColumnName").also { doInit(it) }
}

class App(__name: String = "App"): ObjectNode(__name) {
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val description get() =
        ScalarNode("description").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val logoBackgroundColor get() =
        ScalarNode("logoBackgroundColor").also { doInit(it) }
    fun logoUrl(size: Int? = null) =
        ScalarWithArgsNode("logoUrl", mapOf("size" to size)).also { doInit(it) }
    val logoUrl get() =
        ScalarNode("logoUrl").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    val slug get() =
        ScalarNode("slug").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
}

class ArchiveRepositoryPayload(__name: String = "ArchiveRepositoryPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
}

class AssignedEvent(__name: String = "AssignedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    fun assignable(init: Assignable.() -> Unit) =
        Assignable("assignable").also { doInit(it, init) }
    fun assignee(init: Assignee.() -> Unit) =
        Assignee("assignee").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    @Deprecated("Assignees can now be mannequins. Use the `assignee` field instead. Removal on 2020-01-01 UTC.")
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
}

class AutomaticBaseChangeFailedEvent(__name: String = "AutomaticBaseChangeFailedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val newBase get() =
        ScalarNode("newBase").also { doInit(it) }
    val oldBase get() =
        ScalarNode("oldBase").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
}

class AutomaticBaseChangeSucceededEvent(__name: String = "AutomaticBaseChangeSucceededEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val newBase get() =
        ScalarNode("newBase").also { doInit(it) }
    val oldBase get() =
        ScalarNode("oldBase").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
}

class BaseRefChangedEvent(__name: String = "BaseRefChangedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val currentRefName get() =
        ScalarNode("currentRefName").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val previousRefName get() =
        ScalarNode("previousRefName").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
}

class BaseRefDeletedEvent(__name: String = "BaseRefDeletedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val baseRefName get() =
        ScalarNode("baseRefName").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
}

class BaseRefForcePushedEvent(__name: String = "BaseRefForcePushedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    fun afterCommit(init: Commit.() -> Unit) =
        Commit("afterCommit").also { doInit(it, init) }
    fun beforeCommit(init: Commit.() -> Unit) =
        Commit("beforeCommit").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
    fun ref(init: Ref.() -> Unit) =
        Ref("ref").also { doInit(it, init) }
}

class Blame(__name: String = "Blame"): ObjectNode(__name) {
    fun ranges(init: BlameRange.() -> Unit) =
        BlameRange("ranges").also { doInit(it, init) }
}

class BlameRange(__name: String = "BlameRange"): ObjectNode(__name) {
    val age get() =
        ScalarNode("age").also { doInit(it) }
    fun commit(init: Commit.() -> Unit) =
        Commit("commit").also { doInit(it, init) }
    val endingLine get() =
        ScalarNode("endingLine").also { doInit(it) }
    val startingLine get() =
        ScalarNode("startingLine").also { doInit(it) }
}

class Blob(__name: String = "Blob"): ObjectNode(__name) {
    val abbreviatedOid get() =
        ScalarNode("abbreviatedOid").also { doInit(it) }
    val byteSize get() =
        ScalarNode("byteSize").also { doInit(it) }
    val commitResourcePath get() =
        ScalarNode("commitResourcePath").also { doInit(it) }
    val commitUrl get() =
        ScalarNode("commitUrl").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val isBinary get() =
        ScalarNode("isBinary").also { doInit(it) }
    val isTruncated get() =
        ScalarNode("isTruncated").also { doInit(it) }
    val oid get() =
        ScalarNode("oid").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val text get() =
        ScalarNode("text").also { doInit(it) }
}

class Bot(__name: String = "Bot"): ObjectNode(__name) {
    fun avatarUrl(size: Int? = null) =
        ScalarWithArgsNode("avatarUrl", mapOf("size" to size)).also { doInit(it) }
    val avatarUrl get() =
        ScalarNode("avatarUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val login get() =
        ScalarNode("login").also { doInit(it) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
}

class BranchProtectionRule(__name: String = "BranchProtectionRule"): ObjectNode(__name) {
    val allowsDeletions get() =
        ScalarNode("allowsDeletions").also { doInit(it) }
    val allowsForcePushes get() =
        ScalarNode("allowsForcePushes").also { doInit(it) }
    fun branchProtectionRuleConflicts(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: BranchProtectionRuleConflictConnection.() -> Unit) =
        BranchProtectionRuleConflictConnection("branchProtectionRuleConflicts").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun creator(init: Actor.() -> Unit) =
        Actor("creator").also { doInit(it, init) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val dismissesStaleReviews get() =
        ScalarNode("dismissesStaleReviews").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val isAdminEnforced get() =
        ScalarNode("isAdminEnforced").also { doInit(it) }
    fun matchingRefs(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, query: String? = null, init: RefConnection.() -> Unit) =
        RefConnection("matchingRefs").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("query", query) }.also { doInit(it, init) }
    val pattern get() =
        ScalarNode("pattern").also { doInit(it) }
    fun pushAllowances(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: PushAllowanceConnection.() -> Unit) =
        PushAllowanceConnection("pushAllowances").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val requiredApprovingReviewCount get() =
        ScalarNode("requiredApprovingReviewCount").also { doInit(it) }
    val requiredStatusCheckContexts get() =
        ScalarNode("requiredStatusCheckContexts").also { doInit(it) }
    val requiresApprovingReviews get() =
        ScalarNode("requiresApprovingReviews").also { doInit(it) }
    val requiresCodeOwnerReviews get() =
        ScalarNode("requiresCodeOwnerReviews").also { doInit(it) }
    val requiresCommitSignatures get() =
        ScalarNode("requiresCommitSignatures").also { doInit(it) }
    val requiresLinearHistory get() =
        ScalarNode("requiresLinearHistory").also { doInit(it) }
    val requiresStatusChecks get() =
        ScalarNode("requiresStatusChecks").also { doInit(it) }
    val requiresStrictStatusChecks get() =
        ScalarNode("requiresStrictStatusChecks").also { doInit(it) }
    val restrictsPushes get() =
        ScalarNode("restrictsPushes").also { doInit(it) }
    val restrictsReviewDismissals get() =
        ScalarNode("restrictsReviewDismissals").also { doInit(it) }
    fun reviewDismissalAllowances(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: ReviewDismissalAllowanceConnection.() -> Unit) =
        ReviewDismissalAllowanceConnection("reviewDismissalAllowances").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
}

class BranchProtectionRuleConflict(__name: String = "BranchProtectionRuleConflict"): ObjectNode(__name) {
    fun branchProtectionRule(init: BranchProtectionRule.() -> Unit) =
        BranchProtectionRule("branchProtectionRule").also { doInit(it, init) }
    fun conflictingBranchProtectionRule(init: BranchProtectionRule.() -> Unit) =
        BranchProtectionRule("conflictingBranchProtectionRule").also { doInit(it, init) }
    fun ref(init: Ref.() -> Unit) =
        Ref("ref").also { doInit(it, init) }
}

class BranchProtectionRuleConflictConnection(__name: String = "BranchProtectionRuleConflictConnection"): ObjectNode(__name) {
    fun edges(init: BranchProtectionRuleConflictEdge.() -> Unit) =
        BranchProtectionRuleConflictEdge("edges").also { doInit(it, init) }
    fun nodes(init: BranchProtectionRuleConflict.() -> Unit) =
        BranchProtectionRuleConflict("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class BranchProtectionRuleConflictEdge(__name: String = "BranchProtectionRuleConflictEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: BranchProtectionRuleConflict.() -> Unit) =
        BranchProtectionRuleConflict("node").also { doInit(it, init) }
}

class BranchProtectionRuleConnection(__name: String = "BranchProtectionRuleConnection"): ObjectNode(__name) {
    fun edges(init: BranchProtectionRuleEdge.() -> Unit) =
        BranchProtectionRuleEdge("edges").also { doInit(it, init) }
    fun nodes(init: BranchProtectionRule.() -> Unit) =
        BranchProtectionRule("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class BranchProtectionRuleEdge(__name: String = "BranchProtectionRuleEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: BranchProtectionRule.() -> Unit) =
        BranchProtectionRule("node").also { doInit(it, init) }
}

class CancelEnterpriseAdminInvitationPayload(__name: String = "CancelEnterpriseAdminInvitationPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun invitation(init: EnterpriseAdministratorInvitation.() -> Unit) =
        EnterpriseAdministratorInvitation("invitation").also { doInit(it, init) }
    val message get() =
        ScalarNode("message").also { doInit(it) }
}

class ChangeUserStatusPayload(__name: String = "ChangeUserStatusPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun status(init: UserStatus.() -> Unit) =
        UserStatus("status").also { doInit(it, init) }
}

class CheckAnnotation(__name: String = "CheckAnnotation"): ObjectNode(__name) {
    val annotationLevel get() =
        ScalarNode("annotationLevel").also { doInit(it) }
    val blobUrl get() =
        ScalarNode("blobUrl").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    fun location(init: CheckAnnotationSpan.() -> Unit) =
        CheckAnnotationSpan("location").also { doInit(it, init) }
    val message get() =
        ScalarNode("message").also { doInit(it) }
    val path get() =
        ScalarNode("path").also { doInit(it) }
    val rawDetails get() =
        ScalarNode("rawDetails").also { doInit(it) }
    val title get() =
        ScalarNode("title").also { doInit(it) }
}

class CheckAnnotationConnection(__name: String = "CheckAnnotationConnection"): ObjectNode(__name) {
    fun edges(init: CheckAnnotationEdge.() -> Unit) =
        CheckAnnotationEdge("edges").also { doInit(it, init) }
    fun nodes(init: CheckAnnotation.() -> Unit) =
        CheckAnnotation("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class CheckAnnotationEdge(__name: String = "CheckAnnotationEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: CheckAnnotation.() -> Unit) =
        CheckAnnotation("node").also { doInit(it, init) }
}

class CheckAnnotationPosition(__name: String = "CheckAnnotationPosition"): ObjectNode(__name) {
    val column get() =
        ScalarNode("column").also { doInit(it) }
    val line get() =
        ScalarNode("line").also { doInit(it) }
}

class CheckAnnotationSpan(__name: String = "CheckAnnotationSpan"): ObjectNode(__name) {
    fun end(init: CheckAnnotationPosition.() -> Unit) =
        CheckAnnotationPosition("end").also { doInit(it, init) }
    fun start(init: CheckAnnotationPosition.() -> Unit) =
        CheckAnnotationPosition("start").also { doInit(it, init) }
}

class CheckRun(__name: String = "CheckRun"): ObjectNode(__name) {
    fun annotations(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: CheckAnnotationConnection.() -> Unit) =
        CheckAnnotationConnection("annotations").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun checkSuite(init: CheckSuite.() -> Unit) =
        CheckSuite("checkSuite").also { doInit(it, init) }
    val completedAt get() =
        ScalarNode("completedAt").also { doInit(it) }
    val conclusion get() =
        ScalarNode("conclusion").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val detailsUrl get() =
        ScalarNode("detailsUrl").also { doInit(it) }
    val externalId get() =
        ScalarNode("externalId").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    val permalink get() =
        ScalarNode("permalink").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val startedAt get() =
        ScalarNode("startedAt").also { doInit(it) }
    val status get() =
        ScalarNode("status").also { doInit(it) }
    val summary get() =
        ScalarNode("summary").also { doInit(it) }
    val text get() =
        ScalarNode("text").also { doInit(it) }
    val title get() =
        ScalarNode("title").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
}

class CheckRunConnection(__name: String = "CheckRunConnection"): ObjectNode(__name) {
    fun edges(init: CheckRunEdge.() -> Unit) =
        CheckRunEdge("edges").also { doInit(it, init) }
    fun nodes(init: CheckRun.() -> Unit) =
        CheckRun("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class CheckRunEdge(__name: String = "CheckRunEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: CheckRun.() -> Unit) =
        CheckRun("node").also { doInit(it, init) }
}

class CheckSuite(__name: String = "CheckSuite"): ObjectNode(__name) {
    fun app(init: App.() -> Unit) =
        App("app").also { doInit(it, init) }
    fun branch(init: Ref.() -> Unit) =
        Ref("branch").also { doInit(it, init) }
    fun checkRuns(after: String? = null, before: String? = null, filterBy: CheckRunFilter? = null, first: Int? = null, last: Int? = null, init: CheckRunConnection.() -> Unit) =
        CheckRunConnection("checkRuns").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("filterBy", filterBy) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun commit(init: Commit.() -> Unit) =
        Commit("commit").also { doInit(it, init) }
    val conclusion get() =
        ScalarNode("conclusion").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun matchingPullRequests(after: String? = null, baseRefName: String? = null, before: String? = null, first: Int? = null, headRefName: String? = null, labels: String? = null, last: Int? = null, orderBy: IssueOrder? = null, states: PullRequestState? = null, init: PullRequestConnection.() -> Unit) =
        PullRequestConnection("matchingPullRequests").apply { addArgs("after", after) }.apply { addArgs("baseRefName", baseRefName) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("headRefName", headRefName) }.apply { addArgs("labels", labels) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("states", states) }.also { doInit(it, init) }
    fun push(init: Push.() -> Unit) =
        Push("push").also { doInit(it, init) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val status get() =
        ScalarNode("status").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
}

class CheckSuiteConnection(__name: String = "CheckSuiteConnection"): ObjectNode(__name) {
    fun edges(init: CheckSuiteEdge.() -> Unit) =
        CheckSuiteEdge("edges").also { doInit(it, init) }
    fun nodes(init: CheckSuite.() -> Unit) =
        CheckSuite("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class CheckSuiteEdge(__name: String = "CheckSuiteEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: CheckSuite.() -> Unit) =
        CheckSuite("node").also { doInit(it, init) }
}

class ClearLabelsFromLabelablePayload(__name: String = "ClearLabelsFromLabelablePayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun labelable(init: Labelable.() -> Unit) =
        Labelable("labelable").also { doInit(it, init) }
}

class CloneProjectPayload(__name: String = "CloneProjectPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    val jobStatusId get() =
        ScalarNode("jobStatusId").also { doInit(it) }
    fun project(init: Project.() -> Unit) =
        Project("project").also { doInit(it, init) }
}

class CloneTemplateRepositoryPayload(__name: String = "CloneTemplateRepositoryPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
}

class CloseIssuePayload(__name: String = "CloseIssuePayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun issue(init: Issue.() -> Unit) =
        Issue("issue").also { doInit(it, init) }
}

class ClosePullRequestPayload(__name: String = "ClosePullRequestPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
}

class ClosedEvent(__name: String = "ClosedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    fun closable(init: Closable.() -> Unit) =
        Closable("closable").also { doInit(it, init) }
    fun closer(init: Closer.() -> Unit) =
        Closer("closer").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
}

class CodeOfConduct(__name: String = "CodeOfConduct"): ObjectNode(__name) {
    val body get() =
        ScalarNode("body").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val key get() =
        ScalarNode("key").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
}

class CommentDeletedEvent(__name: String = "CommentDeletedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    fun deletedCommentAuthor(init: Actor.() -> Unit) =
        Actor("deletedCommentAuthor").also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
}

class Commit(__name: String = "Commit"): ObjectNode(__name) {
    val abbreviatedOid get() =
        ScalarNode("abbreviatedOid").also { doInit(it) }
    val additions get() =
        ScalarNode("additions").also { doInit(it) }
    fun associatedPullRequests(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: PullRequestOrder? = null, init: PullRequestConnection.() -> Unit) =
        PullRequestConnection("associatedPullRequests").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun author(init: GitActor.() -> Unit) =
        GitActor("author").also { doInit(it, init) }
    val authoredByCommitter get() =
        ScalarNode("authoredByCommitter").also { doInit(it) }
    val authoredDate get() =
        ScalarNode("authoredDate").also { doInit(it) }
    fun authors(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: GitActorConnection.() -> Unit) =
        GitActorConnection("authors").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun blame(path: String, init: Blame.() -> Unit) =
        Blame("blame").apply { addArgs("path", path) }.also { doInit(it, init) }
    val changedFiles get() =
        ScalarNode("changedFiles").also { doInit(it) }
    fun checkSuites(after: String? = null, before: String? = null, filterBy: CheckSuiteFilter? = null, first: Int? = null, last: Int? = null, init: CheckSuiteConnection.() -> Unit) =
        CheckSuiteConnection("checkSuites").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("filterBy", filterBy) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun comments(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: CommitCommentConnection.() -> Unit) =
        CommitCommentConnection("comments").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val commitResourcePath get() =
        ScalarNode("commitResourcePath").also { doInit(it) }
    val commitUrl get() =
        ScalarNode("commitUrl").also { doInit(it) }
    val committedDate get() =
        ScalarNode("committedDate").also { doInit(it) }
    val committedViaWeb get() =
        ScalarNode("committedViaWeb").also { doInit(it) }
    fun committer(init: GitActor.() -> Unit) =
        GitActor("committer").also { doInit(it, init) }
    val deletions get() =
        ScalarNode("deletions").also { doInit(it) }
    fun deployments(after: String? = null, before: String? = null, environments: String? = null, first: Int? = null, last: Int? = null, orderBy: DeploymentOrder? = null, init: DeploymentConnection.() -> Unit) =
        DeploymentConnection("deployments").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("environments", environments) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun file(path: String, init: TreeEntry.() -> Unit) =
        TreeEntry("file").apply { addArgs("path", path) }.also { doInit(it, init) }
    fun history(after: String? = null, author: CommitAuthor? = null, before: String? = null, first: Int? = null, last: Int? = null, path: String? = null, since: GitTimestamp? = null, until: GitTimestamp? = null, init: CommitHistoryConnection.() -> Unit) =
        CommitHistoryConnection("history").apply { addArgs("after", after) }.apply { addArgs("author", author) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("path", path) }.apply { addArgs("since", since) }.apply { addArgs("until", until) }.also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val message get() =
        ScalarNode("message").also { doInit(it) }
    val messageBody get() =
        ScalarNode("messageBody").also { doInit(it) }
    val messageBodyHTML get() =
        ScalarNode("messageBodyHTML").also { doInit(it) }
    val messageHeadline get() =
        ScalarNode("messageHeadline").also { doInit(it) }
    val messageHeadlineHTML get() =
        ScalarNode("messageHeadlineHTML").also { doInit(it) }
    val oid get() =
        ScalarNode("oid").also { doInit(it) }
    fun onBehalfOf(init: Organization.() -> Unit) =
        Organization("onBehalfOf").also { doInit(it, init) }
    fun parents(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: CommitConnection.() -> Unit) =
        CommitConnection("parents").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val pushedDate get() =
        ScalarNode("pushedDate").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    fun signature(init: GitSignature.() -> Unit) =
        GitSignature("signature").also { doInit(it, init) }
    fun status(init: Status.() -> Unit) =
        Status("status").also { doInit(it, init) }
    fun statusCheckRollup(init: StatusCheckRollup.() -> Unit) =
        StatusCheckRollup("statusCheckRollup").also { doInit(it, init) }
    fun submodules(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: SubmoduleConnection.() -> Unit) =
        SubmoduleConnection("submodules").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val tarballUrl get() =
        ScalarNode("tarballUrl").also { doInit(it) }
    fun tree(init: Tree.() -> Unit) =
        Tree("tree").also { doInit(it, init) }
    val treeResourcePath get() =
        ScalarNode("treeResourcePath").also { doInit(it) }
    val treeUrl get() =
        ScalarNode("treeUrl").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    val viewerCanSubscribe get() =
        ScalarNode("viewerCanSubscribe").also { doInit(it) }
    val viewerSubscription get() =
        ScalarNode("viewerSubscription").also { doInit(it) }
    val zipballUrl get() =
        ScalarNode("zipballUrl").also { doInit(it) }
}

class CommitComment(__name: String = "CommitComment"): ObjectNode(__name) {
    fun author(init: Actor.() -> Unit) =
        Actor("author").also { doInit(it, init) }
    val authorAssociation get() =
        ScalarNode("authorAssociation").also { doInit(it) }
    val body get() =
        ScalarNode("body").also { doInit(it) }
    val bodyHTML get() =
        ScalarNode("bodyHTML").also { doInit(it) }
    val bodyText get() =
        ScalarNode("bodyText").also { doInit(it) }
    fun commit(init: Commit.() -> Unit) =
        Commit("commit").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val createdViaEmail get() =
        ScalarNode("createdViaEmail").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    fun editor(init: Actor.() -> Unit) =
        Actor("editor").also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val includesCreatedEdit get() =
        ScalarNode("includesCreatedEdit").also { doInit(it) }
    val isMinimized get() =
        ScalarNode("isMinimized").also { doInit(it) }
    val lastEditedAt get() =
        ScalarNode("lastEditedAt").also { doInit(it) }
    val minimizedReason get() =
        ScalarNode("minimizedReason").also { doInit(it) }
    val path get() =
        ScalarNode("path").also { doInit(it) }
    val position get() =
        ScalarNode("position").also { doInit(it) }
    val publishedAt get() =
        ScalarNode("publishedAt").also { doInit(it) }
    fun reactionGroups(init: ReactionGroup.() -> Unit) =
        ReactionGroup("reactionGroups").also { doInit(it, init) }
    fun reactions(after: String? = null, before: String? = null, content: ReactionContent? = null, first: Int? = null, last: Int? = null, orderBy: ReactionOrder? = null, init: ReactionConnection.() -> Unit) =
        ReactionConnection("reactions").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("content", content) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    fun userContentEdits(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: UserContentEditConnection.() -> Unit) =
        UserContentEditConnection("userContentEdits").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val viewerCanDelete get() =
        ScalarNode("viewerCanDelete").also { doInit(it) }
    val viewerCanMinimize get() =
        ScalarNode("viewerCanMinimize").also { doInit(it) }
    val viewerCanReact get() =
        ScalarNode("viewerCanReact").also { doInit(it) }
    val viewerCanUpdate get() =
        ScalarNode("viewerCanUpdate").also { doInit(it) }
    val viewerCannotUpdateReasons get() =
        ScalarNode("viewerCannotUpdateReasons").also { doInit(it) }
    val viewerDidAuthor get() =
        ScalarNode("viewerDidAuthor").also { doInit(it) }
}

class CommitCommentConnection(__name: String = "CommitCommentConnection"): ObjectNode(__name) {
    fun edges(init: CommitCommentEdge.() -> Unit) =
        CommitCommentEdge("edges").also { doInit(it, init) }
    fun nodes(init: CommitComment.() -> Unit) =
        CommitComment("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class CommitCommentEdge(__name: String = "CommitCommentEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: CommitComment.() -> Unit) =
        CommitComment("node").also { doInit(it, init) }
}

class CommitCommentThread(__name: String = "CommitCommentThread"): ObjectNode(__name) {
    fun comments(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: CommitCommentConnection.() -> Unit) =
        CommitCommentConnection("comments").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun commit(init: Commit.() -> Unit) =
        Commit("commit").also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val path get() =
        ScalarNode("path").also { doInit(it) }
    val position get() =
        ScalarNode("position").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
}

class CommitConnection(__name: String = "CommitConnection"): ObjectNode(__name) {
    fun edges(init: CommitEdge.() -> Unit) =
        CommitEdge("edges").also { doInit(it, init) }
    fun nodes(init: Commit.() -> Unit) =
        Commit("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class CommitContributionsByRepository(__name: String = "CommitContributionsByRepository"): ObjectNode(__name) {
    fun contributions(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: CommitContributionOrder? = null, init: CreatedCommitContributionConnection.() -> Unit) =
        CreatedCommitContributionConnection("contributions").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
}

class CommitEdge(__name: String = "CommitEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: Commit.() -> Unit) =
        Commit("node").also { doInit(it, init) }
}

class CommitHistoryConnection(__name: String = "CommitHistoryConnection"): ObjectNode(__name) {
    fun edges(init: CommitEdge.() -> Unit) =
        CommitEdge("edges").also { doInit(it, init) }
    fun nodes(init: Commit.() -> Unit) =
        Commit("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class ConnectedEvent(__name: String = "ConnectedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val isCrossRepository get() =
        ScalarNode("isCrossRepository").also { doInit(it) }
    fun source(init: ReferencedSubject.() -> Unit) =
        ReferencedSubject("source").also { doInit(it, init) }
    fun subject(init: ReferencedSubject.() -> Unit) =
        ReferencedSubject("subject").also { doInit(it, init) }
}

class ContentAttachment(__name: String = "ContentAttachment"): ObjectNode(__name) {
    val body get() =
        ScalarNode("body").also { doInit(it) }
    fun contentReference(init: ContentReference.() -> Unit) =
        ContentReference("contentReference").also { doInit(it, init) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val title get() =
        ScalarNode("title").also { doInit(it) }
}

class ContentReference(__name: String = "ContentReference"): ObjectNode(__name) {
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val reference get() =
        ScalarNode("reference").also { doInit(it) }
}

class ContributionCalendar(__name: String = "ContributionCalendar"): ObjectNode(__name) {
    val colors get() =
        ScalarNode("colors").also { doInit(it) }
    val isHalloween get() =
        ScalarNode("isHalloween").also { doInit(it) }
    fun months(init: ContributionCalendarMonth.() -> Unit) =
        ContributionCalendarMonth("months").also { doInit(it, init) }
    val totalContributions get() =
        ScalarNode("totalContributions").also { doInit(it) }
    fun weeks(init: ContributionCalendarWeek.() -> Unit) =
        ContributionCalendarWeek("weeks").also { doInit(it, init) }
}

class ContributionCalendarDay(__name: String = "ContributionCalendarDay"): ObjectNode(__name) {
    val color get() =
        ScalarNode("color").also { doInit(it) }
    val contributionCount get() =
        ScalarNode("contributionCount").also { doInit(it) }
    val date get() =
        ScalarNode("date").also { doInit(it) }
    val weekday get() =
        ScalarNode("weekday").also { doInit(it) }
}

class ContributionCalendarMonth(__name: String = "ContributionCalendarMonth"): ObjectNode(__name) {
    val firstDay get() =
        ScalarNode("firstDay").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    val totalWeeks get() =
        ScalarNode("totalWeeks").also { doInit(it) }
    val year get() =
        ScalarNode("year").also { doInit(it) }
}

class ContributionCalendarWeek(__name: String = "ContributionCalendarWeek"): ObjectNode(__name) {
    fun contributionDays(init: ContributionCalendarDay.() -> Unit) =
        ContributionCalendarDay("contributionDays").also { doInit(it, init) }
    val firstDay get() =
        ScalarNode("firstDay").also { doInit(it) }
}

class ContributionsCollection(__name: String = "ContributionsCollection"): ObjectNode(__name) {
    fun commitContributionsByRepository(maxRepositories: Int? = null, init: CommitContributionsByRepository.() -> Unit) =
        CommitContributionsByRepository("commitContributionsByRepository").apply { addArgs("maxRepositories", maxRepositories) }.also { doInit(it, init) }
    fun contributionCalendar(init: ContributionCalendar.() -> Unit) =
        ContributionCalendar("contributionCalendar").also { doInit(it, init) }
    val contributionYears get() =
        ScalarNode("contributionYears").also { doInit(it) }
    val doesEndInCurrentMonth get() =
        ScalarNode("doesEndInCurrentMonth").also { doInit(it) }
    val earliestRestrictedContributionDate get() =
        ScalarNode("earliestRestrictedContributionDate").also { doInit(it) }
    val endedAt get() =
        ScalarNode("endedAt").also { doInit(it) }
    fun firstIssueContribution(init: CreatedIssueOrRestrictedContribution.() -> Unit) =
        CreatedIssueOrRestrictedContribution("firstIssueContribution").also { doInit(it, init) }
    fun firstPullRequestContribution(init: CreatedPullRequestOrRestrictedContribution.() -> Unit) =
        CreatedPullRequestOrRestrictedContribution("firstPullRequestContribution").also { doInit(it, init) }
    fun firstRepositoryContribution(init: CreatedRepositoryOrRestrictedContribution.() -> Unit) =
        CreatedRepositoryOrRestrictedContribution("firstRepositoryContribution").also { doInit(it, init) }
    val hasActivityInThePast get() =
        ScalarNode("hasActivityInThePast").also { doInit(it) }
    val hasAnyContributions get() =
        ScalarNode("hasAnyContributions").also { doInit(it) }
    val hasAnyRestrictedContributions get() =
        ScalarNode("hasAnyRestrictedContributions").also { doInit(it) }
    val isSingleDay get() =
        ScalarNode("isSingleDay").also { doInit(it) }
    fun issueContributions(after: String? = null, before: String? = null, excludeFirst: Boolean? = null, excludePopular: Boolean? = null, first: Int? = null, last: Int? = null, orderBy: ContributionOrder? = null, init: CreatedIssueContributionConnection.() -> Unit) =
        CreatedIssueContributionConnection("issueContributions").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("excludeFirst", excludeFirst) }.apply { addArgs("excludePopular", excludePopular) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun issueContributionsByRepository(excludeFirst: Boolean? = null, excludePopular: Boolean? = null, maxRepositories: Int? = null, init: IssueContributionsByRepository.() -> Unit) =
        IssueContributionsByRepository("issueContributionsByRepository").apply { addArgs("excludeFirst", excludeFirst) }.apply { addArgs("excludePopular", excludePopular) }.apply { addArgs("maxRepositories", maxRepositories) }.also { doInit(it, init) }
    fun joinedGitHubContribution(init: JoinedGitHubContribution.() -> Unit) =
        JoinedGitHubContribution("joinedGitHubContribution").also { doInit(it, init) }
    val latestRestrictedContributionDate get() =
        ScalarNode("latestRestrictedContributionDate").also { doInit(it) }
    fun mostRecentCollectionWithActivity(init: ContributionsCollection.() -> Unit) =
        ContributionsCollection("mostRecentCollectionWithActivity").also { doInit(it, init) }
    fun mostRecentCollectionWithoutActivity(init: ContributionsCollection.() -> Unit) =
        ContributionsCollection("mostRecentCollectionWithoutActivity").also { doInit(it, init) }
    fun popularIssueContribution(init: CreatedIssueContribution.() -> Unit) =
        CreatedIssueContribution("popularIssueContribution").also { doInit(it, init) }
    fun popularPullRequestContribution(init: CreatedPullRequestContribution.() -> Unit) =
        CreatedPullRequestContribution("popularPullRequestContribution").also { doInit(it, init) }
    fun pullRequestContributions(after: String? = null, before: String? = null, excludeFirst: Boolean? = null, excludePopular: Boolean? = null, first: Int? = null, last: Int? = null, orderBy: ContributionOrder? = null, init: CreatedPullRequestContributionConnection.() -> Unit) =
        CreatedPullRequestContributionConnection("pullRequestContributions").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("excludeFirst", excludeFirst) }.apply { addArgs("excludePopular", excludePopular) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun pullRequestContributionsByRepository(excludeFirst: Boolean? = null, excludePopular: Boolean? = null, maxRepositories: Int? = null, init: PullRequestContributionsByRepository.() -> Unit) =
        PullRequestContributionsByRepository("pullRequestContributionsByRepository").apply { addArgs("excludeFirst", excludeFirst) }.apply { addArgs("excludePopular", excludePopular) }.apply { addArgs("maxRepositories", maxRepositories) }.also { doInit(it, init) }
    fun pullRequestReviewContributions(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: ContributionOrder? = null, init: CreatedPullRequestReviewContributionConnection.() -> Unit) =
        CreatedPullRequestReviewContributionConnection("pullRequestReviewContributions").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun pullRequestReviewContributionsByRepository(maxRepositories: Int? = null, init: PullRequestReviewContributionsByRepository.() -> Unit) =
        PullRequestReviewContributionsByRepository("pullRequestReviewContributionsByRepository").apply { addArgs("maxRepositories", maxRepositories) }.also { doInit(it, init) }
    fun repositoryContributions(after: String? = null, before: String? = null, excludeFirst: Boolean? = null, first: Int? = null, last: Int? = null, orderBy: ContributionOrder? = null, init: CreatedRepositoryContributionConnection.() -> Unit) =
        CreatedRepositoryContributionConnection("repositoryContributions").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("excludeFirst", excludeFirst) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    val restrictedContributionsCount get() =
        ScalarNode("restrictedContributionsCount").also { doInit(it) }
    val startedAt get() =
        ScalarNode("startedAt").also { doInit(it) }
    val totalCommitContributions get() =
        ScalarNode("totalCommitContributions").also { doInit(it) }
    fun totalIssueContributions(excludeFirst: Boolean? = null, excludePopular: Boolean? = null) =
        ScalarWithArgsNode("totalIssueContributions", mapOf("excludeFirst" to excludeFirst, "excludePopular" to excludePopular)).also { doInit(it) }
    val totalIssueContributions get() =
        ScalarNode("totalIssueContributions").also { doInit(it) }
    fun totalPullRequestContributions(excludeFirst: Boolean? = null, excludePopular: Boolean? = null) =
        ScalarWithArgsNode("totalPullRequestContributions", mapOf("excludeFirst" to excludeFirst, "excludePopular" to excludePopular)).also { doInit(it) }
    val totalPullRequestContributions get() =
        ScalarNode("totalPullRequestContributions").also { doInit(it) }
    val totalPullRequestReviewContributions get() =
        ScalarNode("totalPullRequestReviewContributions").also { doInit(it) }
    val totalRepositoriesWithContributedCommits get() =
        ScalarNode("totalRepositoriesWithContributedCommits").also { doInit(it) }
    fun totalRepositoriesWithContributedIssues(excludeFirst: Boolean? = null, excludePopular: Boolean? = null) =
        ScalarWithArgsNode("totalRepositoriesWithContributedIssues", mapOf("excludeFirst" to excludeFirst, "excludePopular" to excludePopular)).also { doInit(it) }
    val totalRepositoriesWithContributedIssues get() =
        ScalarNode("totalRepositoriesWithContributedIssues").also { doInit(it) }
    val totalRepositoriesWithContributedPullRequestReviews get() =
        ScalarNode("totalRepositoriesWithContributedPullRequestReviews").also { doInit(it) }
    fun totalRepositoriesWithContributedPullRequests(excludeFirst: Boolean? = null, excludePopular: Boolean? = null) =
        ScalarWithArgsNode("totalRepositoriesWithContributedPullRequests", mapOf("excludeFirst" to excludeFirst, "excludePopular" to excludePopular)).also { doInit(it) }
    val totalRepositoriesWithContributedPullRequests get() =
        ScalarNode("totalRepositoriesWithContributedPullRequests").also { doInit(it) }
    fun totalRepositoryContributions(excludeFirst: Boolean? = null) =
        ScalarWithArgsNode("totalRepositoryContributions", mapOf("excludeFirst" to excludeFirst)).also { doInit(it) }
    val totalRepositoryContributions get() =
        ScalarNode("totalRepositoryContributions").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
}

class ConvertProjectCardNoteToIssuePayload(__name: String = "ConvertProjectCardNoteToIssuePayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun projectCard(init: ProjectCard.() -> Unit) =
        ProjectCard("projectCard").also { doInit(it, init) }
}

class ConvertToDraftEvent(__name: String = "ConvertToDraftEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
}

class ConvertedNoteToIssueEvent(__name: String = "ConvertedNoteToIssueEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun project(init: Project.() -> Unit) =
        Project("project").also { doInit(it, init) }
    fun projectCard(init: ProjectCard.() -> Unit) =
        ProjectCard("projectCard").also { doInit(it, init) }
    val projectColumnName get() =
        ScalarNode("projectColumnName").also { doInit(it) }
}

class CreateBranchProtectionRulePayload(__name: String = "CreateBranchProtectionRulePayload"): ObjectNode(__name) {
    fun branchProtectionRule(init: BranchProtectionRule.() -> Unit) =
        BranchProtectionRule("branchProtectionRule").also { doInit(it, init) }
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
}

class CreateCheckRunPayload(__name: String = "CreateCheckRunPayload"): ObjectNode(__name) {
    fun checkRun(init: CheckRun.() -> Unit) =
        CheckRun("checkRun").also { doInit(it, init) }
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
}

class CreateCheckSuitePayload(__name: String = "CreateCheckSuitePayload"): ObjectNode(__name) {
    fun checkSuite(init: CheckSuite.() -> Unit) =
        CheckSuite("checkSuite").also { doInit(it, init) }
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
}

class CreateContentAttachmentPayload(__name: String = "CreateContentAttachmentPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun contentAttachment(init: ContentAttachment.() -> Unit) =
        ContentAttachment("contentAttachment").also { doInit(it, init) }
}

class CreateDeploymentPayload(__name: String = "CreateDeploymentPayload"): ObjectNode(__name) {
    val autoMerged get() =
        ScalarNode("autoMerged").also { doInit(it) }
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun deployment(init: Deployment.() -> Unit) =
        Deployment("deployment").also { doInit(it, init) }
}

class CreateDeploymentStatusPayload(__name: String = "CreateDeploymentStatusPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun deploymentStatus(init: DeploymentStatus.() -> Unit) =
        DeploymentStatus("deploymentStatus").also { doInit(it, init) }
}

class CreateEnterpriseOrganizationPayload(__name: String = "CreateEnterpriseOrganizationPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun enterprise(init: Enterprise.() -> Unit) =
        Enterprise("enterprise").also { doInit(it, init) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
}

class CreateIpAllowListEntryPayload(__name: String = "CreateIpAllowListEntryPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun ipAllowListEntry(init: IpAllowListEntry.() -> Unit) =
        IpAllowListEntry("ipAllowListEntry").also { doInit(it, init) }
}

class CreateIssuePayload(__name: String = "CreateIssuePayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun issue(init: Issue.() -> Unit) =
        Issue("issue").also { doInit(it, init) }
}

class CreateLabelPayload(__name: String = "CreateLabelPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun label(init: Label.() -> Unit) =
        Label("label").also { doInit(it, init) }
}

class CreateProjectPayload(__name: String = "CreateProjectPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun project(init: Project.() -> Unit) =
        Project("project").also { doInit(it, init) }
}

class CreatePullRequestPayload(__name: String = "CreatePullRequestPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
}

class CreateRefPayload(__name: String = "CreateRefPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun ref(init: Ref.() -> Unit) =
        Ref("ref").also { doInit(it, init) }
}

class CreateRepositoryPayload(__name: String = "CreateRepositoryPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
}

class CreateTeamDiscussionCommentPayload(__name: String = "CreateTeamDiscussionCommentPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun teamDiscussionComment(init: TeamDiscussionComment.() -> Unit) =
        TeamDiscussionComment("teamDiscussionComment").also { doInit(it, init) }
}

class CreateTeamDiscussionPayload(__name: String = "CreateTeamDiscussionPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun teamDiscussion(init: TeamDiscussion.() -> Unit) =
        TeamDiscussion("teamDiscussion").also { doInit(it, init) }
}

class CreatedCommitContribution(__name: String = "CreatedCommitContribution"): ObjectNode(__name) {
    val commitCount get() =
        ScalarNode("commitCount").also { doInit(it) }
    val isRestricted get() =
        ScalarNode("isRestricted").also { doInit(it) }
    val occurredAt get() =
        ScalarNode("occurredAt").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
}

class CreatedCommitContributionConnection(__name: String = "CreatedCommitContributionConnection"): ObjectNode(__name) {
    fun edges(init: CreatedCommitContributionEdge.() -> Unit) =
        CreatedCommitContributionEdge("edges").also { doInit(it, init) }
    fun nodes(init: CreatedCommitContribution.() -> Unit) =
        CreatedCommitContribution("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class CreatedCommitContributionEdge(__name: String = "CreatedCommitContributionEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: CreatedCommitContribution.() -> Unit) =
        CreatedCommitContribution("node").also { doInit(it, init) }
}

class CreatedIssueContribution(__name: String = "CreatedIssueContribution"): ObjectNode(__name) {
    val isRestricted get() =
        ScalarNode("isRestricted").also { doInit(it) }
    fun issue(init: Issue.() -> Unit) =
        Issue("issue").also { doInit(it, init) }
    val occurredAt get() =
        ScalarNode("occurredAt").also { doInit(it) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
}

class CreatedIssueContributionConnection(__name: String = "CreatedIssueContributionConnection"): ObjectNode(__name) {
    fun edges(init: CreatedIssueContributionEdge.() -> Unit) =
        CreatedIssueContributionEdge("edges").also { doInit(it, init) }
    fun nodes(init: CreatedIssueContribution.() -> Unit) =
        CreatedIssueContribution("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class CreatedIssueContributionEdge(__name: String = "CreatedIssueContributionEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: CreatedIssueContribution.() -> Unit) =
        CreatedIssueContribution("node").also { doInit(it, init) }
}

class CreatedPullRequestContribution(__name: String = "CreatedPullRequestContribution"): ObjectNode(__name) {
    val isRestricted get() =
        ScalarNode("isRestricted").also { doInit(it) }
    val occurredAt get() =
        ScalarNode("occurredAt").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
}

class CreatedPullRequestContributionConnection(__name: String = "CreatedPullRequestContributionConnection"): ObjectNode(__name) {
    fun edges(init: CreatedPullRequestContributionEdge.() -> Unit) =
        CreatedPullRequestContributionEdge("edges").also { doInit(it, init) }
    fun nodes(init: CreatedPullRequestContribution.() -> Unit) =
        CreatedPullRequestContribution("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class CreatedPullRequestContributionEdge(__name: String = "CreatedPullRequestContributionEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: CreatedPullRequestContribution.() -> Unit) =
        CreatedPullRequestContribution("node").also { doInit(it, init) }
}

class CreatedPullRequestReviewContribution(__name: String = "CreatedPullRequestReviewContribution"): ObjectNode(__name) {
    val isRestricted get() =
        ScalarNode("isRestricted").also { doInit(it) }
    val occurredAt get() =
        ScalarNode("occurredAt").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
    fun pullRequestReview(init: PullRequestReview.() -> Unit) =
        PullRequestReview("pullRequestReview").also { doInit(it, init) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
}

class CreatedPullRequestReviewContributionConnection(__name: String = "CreatedPullRequestReviewContributionConnection"): ObjectNode(__name) {
    fun edges(init: CreatedPullRequestReviewContributionEdge.() -> Unit) =
        CreatedPullRequestReviewContributionEdge("edges").also { doInit(it, init) }
    fun nodes(init: CreatedPullRequestReviewContribution.() -> Unit) =
        CreatedPullRequestReviewContribution("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class CreatedPullRequestReviewContributionEdge(__name: String = "CreatedPullRequestReviewContributionEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: CreatedPullRequestReviewContribution.() -> Unit) =
        CreatedPullRequestReviewContribution("node").also { doInit(it, init) }
}

class CreatedRepositoryContribution(__name: String = "CreatedRepositoryContribution"): ObjectNode(__name) {
    val isRestricted get() =
        ScalarNode("isRestricted").also { doInit(it) }
    val occurredAt get() =
        ScalarNode("occurredAt").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
}

class CreatedRepositoryContributionConnection(__name: String = "CreatedRepositoryContributionConnection"): ObjectNode(__name) {
    fun edges(init: CreatedRepositoryContributionEdge.() -> Unit) =
        CreatedRepositoryContributionEdge("edges").also { doInit(it, init) }
    fun nodes(init: CreatedRepositoryContribution.() -> Unit) =
        CreatedRepositoryContribution("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class CreatedRepositoryContributionEdge(__name: String = "CreatedRepositoryContributionEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: CreatedRepositoryContribution.() -> Unit) =
        CreatedRepositoryContribution("node").also { doInit(it, init) }
}

class CrossReferencedEvent(__name: String = "CrossReferencedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val isCrossRepository get() =
        ScalarNode("isCrossRepository").also { doInit(it) }
    val referencedAt get() =
        ScalarNode("referencedAt").also { doInit(it) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    fun source(init: ReferencedSubject.() -> Unit) =
        ReferencedSubject("source").also { doInit(it, init) }
    fun target(init: ReferencedSubject.() -> Unit) =
        ReferencedSubject("target").also { doInit(it, init) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    val willCloseTarget get() =
        ScalarNode("willCloseTarget").also { doInit(it) }
}

class DeclineTopicSuggestionPayload(__name: String = "DeclineTopicSuggestionPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun topic(init: Topic.() -> Unit) =
        Topic("topic").also { doInit(it, init) }
}

class DeleteBranchProtectionRulePayload(__name: String = "DeleteBranchProtectionRulePayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
}

class DeleteDeploymentPayload(__name: String = "DeleteDeploymentPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
}

class DeleteIpAllowListEntryPayload(__name: String = "DeleteIpAllowListEntryPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun ipAllowListEntry(init: IpAllowListEntry.() -> Unit) =
        IpAllowListEntry("ipAllowListEntry").also { doInit(it, init) }
}

class DeleteIssueCommentPayload(__name: String = "DeleteIssueCommentPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
}

class DeleteIssuePayload(__name: String = "DeleteIssuePayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
}

class DeleteLabelPayload(__name: String = "DeleteLabelPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
}

class DeletePackageVersionPayload(__name: String = "DeletePackageVersionPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    val success get() =
        ScalarNode("success").also { doInit(it) }
}

class DeleteProjectCardPayload(__name: String = "DeleteProjectCardPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun column(init: ProjectColumn.() -> Unit) =
        ProjectColumn("column").also { doInit(it, init) }
    val deletedCardId get() =
        ScalarNode("deletedCardId").also { doInit(it) }
}

class DeleteProjectColumnPayload(__name: String = "DeleteProjectColumnPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    val deletedColumnId get() =
        ScalarNode("deletedColumnId").also { doInit(it) }
    fun project(init: Project.() -> Unit) =
        Project("project").also { doInit(it, init) }
}

class DeleteProjectPayload(__name: String = "DeleteProjectPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun owner(init: ProjectOwner.() -> Unit) =
        ProjectOwner("owner").also { doInit(it, init) }
}

class DeletePullRequestReviewCommentPayload(__name: String = "DeletePullRequestReviewCommentPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun pullRequestReview(init: PullRequestReview.() -> Unit) =
        PullRequestReview("pullRequestReview").also { doInit(it, init) }
}

class DeletePullRequestReviewPayload(__name: String = "DeletePullRequestReviewPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun pullRequestReview(init: PullRequestReview.() -> Unit) =
        PullRequestReview("pullRequestReview").also { doInit(it, init) }
}

class DeleteRefPayload(__name: String = "DeleteRefPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
}

class DeleteTeamDiscussionCommentPayload(__name: String = "DeleteTeamDiscussionCommentPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
}

class DeleteTeamDiscussionPayload(__name: String = "DeleteTeamDiscussionPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
}

class DemilestonedEvent(__name: String = "DemilestonedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val milestoneTitle get() =
        ScalarNode("milestoneTitle").also { doInit(it) }
    fun subject(init: MilestoneItem.() -> Unit) =
        MilestoneItem("subject").also { doInit(it, init) }
}

class DependencyGraphDependency(__name: String = "DependencyGraphDependency"): ObjectNode(__name) {
    val hasDependencies get() =
        ScalarNode("hasDependencies").also { doInit(it) }
    val packageManager get() =
        ScalarNode("packageManager").also { doInit(it) }
    val packageName get() =
        ScalarNode("packageName").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val requirements get() =
        ScalarNode("requirements").also { doInit(it) }
}

class DependencyGraphDependencyConnection(__name: String = "DependencyGraphDependencyConnection"): ObjectNode(__name) {
    fun edges(init: DependencyGraphDependencyEdge.() -> Unit) =
        DependencyGraphDependencyEdge("edges").also { doInit(it, init) }
    fun nodes(init: DependencyGraphDependency.() -> Unit) =
        DependencyGraphDependency("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class DependencyGraphDependencyEdge(__name: String = "DependencyGraphDependencyEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: DependencyGraphDependency.() -> Unit) =
        DependencyGraphDependency("node").also { doInit(it, init) }
}

class DependencyGraphManifest(__name: String = "DependencyGraphManifest"): ObjectNode(__name) {
    val blobPath get() =
        ScalarNode("blobPath").also { doInit(it) }
    fun dependencies(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: DependencyGraphDependencyConnection.() -> Unit) =
        DependencyGraphDependencyConnection("dependencies").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val dependenciesCount get() =
        ScalarNode("dependenciesCount").also { doInit(it) }
    val exceedsMaxSize get() =
        ScalarNode("exceedsMaxSize").also { doInit(it) }
    val filename get() =
        ScalarNode("filename").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val parseable get() =
        ScalarNode("parseable").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
}

class DependencyGraphManifestConnection(__name: String = "DependencyGraphManifestConnection"): ObjectNode(__name) {
    fun edges(init: DependencyGraphManifestEdge.() -> Unit) =
        DependencyGraphManifestEdge("edges").also { doInit(it, init) }
    fun nodes(init: DependencyGraphManifest.() -> Unit) =
        DependencyGraphManifest("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class DependencyGraphManifestEdge(__name: String = "DependencyGraphManifestEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: DependencyGraphManifest.() -> Unit) =
        DependencyGraphManifest("node").also { doInit(it, init) }
}

class DeployKey(__name: String = "DeployKey"): ObjectNode(__name) {
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val key get() =
        ScalarNode("key").also { doInit(it) }
    val readOnly get() =
        ScalarNode("readOnly").also { doInit(it) }
    val title get() =
        ScalarNode("title").also { doInit(it) }
    val verified get() =
        ScalarNode("verified").also { doInit(it) }
}

class DeployKeyConnection(__name: String = "DeployKeyConnection"): ObjectNode(__name) {
    fun edges(init: DeployKeyEdge.() -> Unit) =
        DeployKeyEdge("edges").also { doInit(it, init) }
    fun nodes(init: DeployKey.() -> Unit) =
        DeployKey("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class DeployKeyEdge(__name: String = "DeployKeyEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: DeployKey.() -> Unit) =
        DeployKey("node").also { doInit(it, init) }
}

class DeployedEvent(__name: String = "DeployedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    fun deployment(init: Deployment.() -> Unit) =
        Deployment("deployment").also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
    fun ref(init: Ref.() -> Unit) =
        Ref("ref").also { doInit(it, init) }
}

class Deployment(__name: String = "Deployment"): ObjectNode(__name) {
    fun commit(init: Commit.() -> Unit) =
        Commit("commit").also { doInit(it, init) }
    val commitOid get() =
        ScalarNode("commitOid").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    fun creator(init: Actor.() -> Unit) =
        Actor("creator").also { doInit(it, init) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val description get() =
        ScalarNode("description").also { doInit(it) }
    val environment get() =
        ScalarNode("environment").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val latestEnvironment get() =
        ScalarNode("latestEnvironment").also { doInit(it) }
    fun latestStatus(init: DeploymentStatus.() -> Unit) =
        DeploymentStatus("latestStatus").also { doInit(it, init) }
    val originalEnvironment get() =
        ScalarNode("originalEnvironment").also { doInit(it) }
    val payload get() =
        ScalarNode("payload").also { doInit(it) }
    fun ref(init: Ref.() -> Unit) =
        Ref("ref").also { doInit(it, init) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val state get() =
        ScalarNode("state").also { doInit(it) }
    fun statuses(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: DeploymentStatusConnection.() -> Unit) =
        DeploymentStatusConnection("statuses").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val task get() =
        ScalarNode("task").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
}

class DeploymentConnection(__name: String = "DeploymentConnection"): ObjectNode(__name) {
    fun edges(init: DeploymentEdge.() -> Unit) =
        DeploymentEdge("edges").also { doInit(it, init) }
    fun nodes(init: Deployment.() -> Unit) =
        Deployment("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class DeploymentEdge(__name: String = "DeploymentEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: Deployment.() -> Unit) =
        Deployment("node").also { doInit(it, init) }
}

class DeploymentEnvironmentChangedEvent(__name: String = "DeploymentEnvironmentChangedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    fun deploymentStatus(init: DeploymentStatus.() -> Unit) =
        DeploymentStatus("deploymentStatus").also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
}

class DeploymentStatus(__name: String = "DeploymentStatus"): ObjectNode(__name) {
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    fun creator(init: Actor.() -> Unit) =
        Actor("creator").also { doInit(it, init) }
    fun deployment(init: Deployment.() -> Unit) =
        Deployment("deployment").also { doInit(it, init) }
    val description get() =
        ScalarNode("description").also { doInit(it) }
    val environment get() =
        ScalarNode("environment").also { doInit(it) }
    val environmentUrl get() =
        ScalarNode("environmentUrl").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val logUrl get() =
        ScalarNode("logUrl").also { doInit(it) }
    val state get() =
        ScalarNode("state").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
}

class DeploymentStatusConnection(__name: String = "DeploymentStatusConnection"): ObjectNode(__name) {
    fun edges(init: DeploymentStatusEdge.() -> Unit) =
        DeploymentStatusEdge("edges").also { doInit(it, init) }
    fun nodes(init: DeploymentStatus.() -> Unit) =
        DeploymentStatus("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class DeploymentStatusEdge(__name: String = "DeploymentStatusEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: DeploymentStatus.() -> Unit) =
        DeploymentStatus("node").also { doInit(it, init) }
}

class DisconnectedEvent(__name: String = "DisconnectedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val isCrossRepository get() =
        ScalarNode("isCrossRepository").also { doInit(it) }
    fun source(init: ReferencedSubject.() -> Unit) =
        ReferencedSubject("source").also { doInit(it, init) }
    fun subject(init: ReferencedSubject.() -> Unit) =
        ReferencedSubject("subject").also { doInit(it, init) }
}

class DismissPullRequestReviewPayload(__name: String = "DismissPullRequestReviewPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun pullRequestReview(init: PullRequestReview.() -> Unit) =
        PullRequestReview("pullRequestReview").also { doInit(it, init) }
}

class Enterprise(__name: String = "Enterprise"): ObjectNode(__name) {
    fun avatarUrl(size: Int? = null) =
        ScalarWithArgsNode("avatarUrl", mapOf("size" to size)).also { doInit(it) }
    val avatarUrl get() =
        ScalarNode("avatarUrl").also { doInit(it) }
    fun billingInfo(init: EnterpriseBillingInfo.() -> Unit) =
        EnterpriseBillingInfo("billingInfo").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val description get() =
        ScalarNode("description").also { doInit(it) }
    val descriptionHTML get() =
        ScalarNode("descriptionHTML").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val location get() =
        ScalarNode("location").also { doInit(it) }
    fun members(after: String? = null, before: String? = null, deployment: EnterpriseUserDeployment? = null, first: Int? = null, last: Int? = null, orderBy: EnterpriseMemberOrder? = null, organizationLogins: String? = null, query: String? = null, role: EnterpriseUserAccountMembershipRole? = null, init: EnterpriseMemberConnection.() -> Unit) =
        EnterpriseMemberConnection("members").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("deployment", deployment) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("organizationLogins", organizationLogins) }.apply { addArgs("query", query) }.apply { addArgs("role", role) }.also { doInit(it, init) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    fun organizations(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: OrganizationOrder? = null, query: String? = null, init: OrganizationConnection.() -> Unit) =
        OrganizationConnection("organizations").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("query", query) }.also { doInit(it, init) }
    fun ownerInfo(init: EnterpriseOwnerInfo.() -> Unit) =
        EnterpriseOwnerInfo("ownerInfo").also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val slug get() =
        ScalarNode("slug").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    fun userAccounts(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: EnterpriseUserAccountConnection.() -> Unit) =
        EnterpriseUserAccountConnection("userAccounts").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val viewerIsAdmin get() =
        ScalarNode("viewerIsAdmin").also { doInit(it) }
    val websiteUrl get() =
        ScalarNode("websiteUrl").also { doInit(it) }
}

class EnterpriseAdministratorConnection(__name: String = "EnterpriseAdministratorConnection"): ObjectNode(__name) {
    fun edges(init: EnterpriseAdministratorEdge.() -> Unit) =
        EnterpriseAdministratorEdge("edges").also { doInit(it, init) }
    fun nodes(init: User.() -> Unit) =
        User("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class EnterpriseAdministratorEdge(__name: String = "EnterpriseAdministratorEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: User.() -> Unit) =
        User("node").also { doInit(it, init) }
    val role get() =
        ScalarNode("role").also { doInit(it) }
}

class EnterpriseAdministratorInvitation(__name: String = "EnterpriseAdministratorInvitation"): ObjectNode(__name) {
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val email get() =
        ScalarNode("email").also { doInit(it) }
    fun enterprise(init: Enterprise.() -> Unit) =
        Enterprise("enterprise").also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun invitee(init: User.() -> Unit) =
        User("invitee").also { doInit(it, init) }
    fun inviter(init: User.() -> Unit) =
        User("inviter").also { doInit(it, init) }
    val role get() =
        ScalarNode("role").also { doInit(it) }
}

class EnterpriseAdministratorInvitationConnection(__name: String = "EnterpriseAdministratorInvitationConnection"): ObjectNode(__name) {
    fun edges(init: EnterpriseAdministratorInvitationEdge.() -> Unit) =
        EnterpriseAdministratorInvitationEdge("edges").also { doInit(it, init) }
    fun nodes(init: EnterpriseAdministratorInvitation.() -> Unit) =
        EnterpriseAdministratorInvitation("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class EnterpriseAdministratorInvitationEdge(__name: String = "EnterpriseAdministratorInvitationEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: EnterpriseAdministratorInvitation.() -> Unit) =
        EnterpriseAdministratorInvitation("node").also { doInit(it, init) }
}

class EnterpriseBillingInfo(__name: String = "EnterpriseBillingInfo"): ObjectNode(__name) {
    val allLicensableUsersCount get() =
        ScalarNode("allLicensableUsersCount").also { doInit(it) }
    val assetPacks get() =
        ScalarNode("assetPacks").also { doInit(it) }
    @Deprecated("`availableSeats` will be replaced with `totalAvailableLicenses` to provide more clarity on the value being returned Use EnterpriseBillingInfo.totalAvailableLicenses instead. Removal on 2020-01-01 UTC.")
    val availableSeats get() =
        ScalarNode("availableSeats").also { doInit(it) }
    val bandwidthQuota get() =
        ScalarNode("bandwidthQuota").also { doInit(it) }
    val bandwidthUsage get() =
        ScalarNode("bandwidthUsage").also { doInit(it) }
    val bandwidthUsagePercentage get() =
        ScalarNode("bandwidthUsagePercentage").also { doInit(it) }
    @Deprecated("`seats` will be replaced with `totalLicenses` to provide more clarity on the value being returned Use EnterpriseBillingInfo.totalLicenses instead. Removal on 2020-01-01 UTC.")
    val seats get() =
        ScalarNode("seats").also { doInit(it) }
    val storageQuota get() =
        ScalarNode("storageQuota").also { doInit(it) }
    val storageUsage get() =
        ScalarNode("storageUsage").also { doInit(it) }
    val storageUsagePercentage get() =
        ScalarNode("storageUsagePercentage").also { doInit(it) }
    val totalAvailableLicenses get() =
        ScalarNode("totalAvailableLicenses").also { doInit(it) }
    val totalLicenses get() =
        ScalarNode("totalLicenses").also { doInit(it) }
}

class EnterpriseIdentityProvider(__name: String = "EnterpriseIdentityProvider"): ObjectNode(__name) {
    val digestMethod get() =
        ScalarNode("digestMethod").also { doInit(it) }
    fun enterprise(init: Enterprise.() -> Unit) =
        Enterprise("enterprise").also { doInit(it, init) }
    fun externalIdentities(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: ExternalIdentityConnection.() -> Unit) =
        ExternalIdentityConnection("externalIdentities").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val idpCertificate get() =
        ScalarNode("idpCertificate").also { doInit(it) }
    val issuer get() =
        ScalarNode("issuer").also { doInit(it) }
    val recoveryCodes get() =
        ScalarNode("recoveryCodes").also { doInit(it) }
    val signatureMethod get() =
        ScalarNode("signatureMethod").also { doInit(it) }
    val ssoUrl get() =
        ScalarNode("ssoUrl").also { doInit(it) }
}

class EnterpriseMemberConnection(__name: String = "EnterpriseMemberConnection"): ObjectNode(__name) {
    fun edges(init: EnterpriseMemberEdge.() -> Unit) =
        EnterpriseMemberEdge("edges").also { doInit(it, init) }
    fun nodes(init: EnterpriseMember.() -> Unit) =
        EnterpriseMember("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class EnterpriseMemberEdge(__name: String = "EnterpriseMemberEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    @Deprecated("All members consume a license Removal on 2021-01-01 UTC.")
    val isUnlicensed get() =
        ScalarNode("isUnlicensed").also { doInit(it) }
    fun node(init: EnterpriseMember.() -> Unit) =
        EnterpriseMember("node").also { doInit(it, init) }
}

class EnterpriseOrganizationMembershipConnection(__name: String = "EnterpriseOrganizationMembershipConnection"): ObjectNode(__name) {
    fun edges(init: EnterpriseOrganizationMembershipEdge.() -> Unit) =
        EnterpriseOrganizationMembershipEdge("edges").also { doInit(it, init) }
    fun nodes(init: Organization.() -> Unit) =
        Organization("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class EnterpriseOrganizationMembershipEdge(__name: String = "EnterpriseOrganizationMembershipEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: Organization.() -> Unit) =
        Organization("node").also { doInit(it, init) }
    val role get() =
        ScalarNode("role").also { doInit(it) }
}

class EnterpriseOutsideCollaboratorConnection(__name: String = "EnterpriseOutsideCollaboratorConnection"): ObjectNode(__name) {
    fun edges(init: EnterpriseOutsideCollaboratorEdge.() -> Unit) =
        EnterpriseOutsideCollaboratorEdge("edges").also { doInit(it, init) }
    fun nodes(init: User.() -> Unit) =
        User("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class EnterpriseOutsideCollaboratorEdge(__name: String = "EnterpriseOutsideCollaboratorEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    @Deprecated("All outside collaborators consume a license Removal on 2021-01-01 UTC.")
    val isUnlicensed get() =
        ScalarNode("isUnlicensed").also { doInit(it) }
    fun node(init: User.() -> Unit) =
        User("node").also { doInit(it, init) }
    fun repositories(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: RepositoryOrder? = null, init: EnterpriseRepositoryInfoConnection.() -> Unit) =
        EnterpriseRepositoryInfoConnection("repositories").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
}

class EnterpriseOwnerInfo(__name: String = "EnterpriseOwnerInfo"): ObjectNode(__name) {
    fun admins(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: EnterpriseMemberOrder? = null, query: String? = null, role: EnterpriseAdministratorRole? = null, init: EnterpriseAdministratorConnection.() -> Unit) =
        EnterpriseAdministratorConnection("admins").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("query", query) }.apply { addArgs("role", role) }.also { doInit(it, init) }
    fun affiliatedUsersWithTwoFactorDisabled(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: UserConnection.() -> Unit) =
        UserConnection("affiliatedUsersWithTwoFactorDisabled").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val affiliatedUsersWithTwoFactorDisabledExist get() =
        ScalarNode("affiliatedUsersWithTwoFactorDisabledExist").also { doInit(it) }
    val allowPrivateRepositoryForkingSetting get() =
        ScalarNode("allowPrivateRepositoryForkingSetting").also { doInit(it) }
    fun allowPrivateRepositoryForkingSettingOrganizations(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: OrganizationOrder? = null, value: Boolean, init: OrganizationConnection.() -> Unit) =
        OrganizationConnection("allowPrivateRepositoryForkingSettingOrganizations").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("value", value) }.also { doInit(it, init) }
    val defaultRepositoryPermissionSetting get() =
        ScalarNode("defaultRepositoryPermissionSetting").also { doInit(it) }
    fun defaultRepositoryPermissionSettingOrganizations(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: OrganizationOrder? = null, value: DefaultRepositoryPermissionField, init: OrganizationConnection.() -> Unit) =
        OrganizationConnection("defaultRepositoryPermissionSettingOrganizations").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("value", value) }.also { doInit(it, init) }
    fun enterpriseServerInstallations(after: String? = null, before: String? = null, connectedOnly: Boolean? = null, first: Int? = null, last: Int? = null, orderBy: EnterpriseServerInstallationOrder? = null, init: EnterpriseServerInstallationConnection.() -> Unit) =
        EnterpriseServerInstallationConnection("enterpriseServerInstallations").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("connectedOnly", connectedOnly) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    val ipAllowListEnabledSetting get() =
        ScalarNode("ipAllowListEnabledSetting").also { doInit(it) }
    fun ipAllowListEntries(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: IpAllowListEntryOrder? = null, init: IpAllowListEntryConnection.() -> Unit) =
        IpAllowListEntryConnection("ipAllowListEntries").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    val isUpdatingDefaultRepositoryPermission get() =
        ScalarNode("isUpdatingDefaultRepositoryPermission").also { doInit(it) }
    val isUpdatingTwoFactorRequirement get() =
        ScalarNode("isUpdatingTwoFactorRequirement").also { doInit(it) }
    val membersCanChangeRepositoryVisibilitySetting get() =
        ScalarNode("membersCanChangeRepositoryVisibilitySetting").also { doInit(it) }
    fun membersCanChangeRepositoryVisibilitySettingOrganizations(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: OrganizationOrder? = null, value: Boolean, init: OrganizationConnection.() -> Unit) =
        OrganizationConnection("membersCanChangeRepositoryVisibilitySettingOrganizations").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("value", value) }.also { doInit(it, init) }
    val membersCanCreateInternalRepositoriesSetting get() =
        ScalarNode("membersCanCreateInternalRepositoriesSetting").also { doInit(it) }
    val membersCanCreatePrivateRepositoriesSetting get() =
        ScalarNode("membersCanCreatePrivateRepositoriesSetting").also { doInit(it) }
    val membersCanCreatePublicRepositoriesSetting get() =
        ScalarNode("membersCanCreatePublicRepositoriesSetting").also { doInit(it) }
    val membersCanCreateRepositoriesSetting get() =
        ScalarNode("membersCanCreateRepositoriesSetting").also { doInit(it) }
    fun membersCanCreateRepositoriesSettingOrganizations(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: OrganizationOrder? = null, value: OrganizationMembersCanCreateRepositoriesSettingValue, init: OrganizationConnection.() -> Unit) =
        OrganizationConnection("membersCanCreateRepositoriesSettingOrganizations").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("value", value) }.also { doInit(it, init) }
    val membersCanDeleteIssuesSetting get() =
        ScalarNode("membersCanDeleteIssuesSetting").also { doInit(it) }
    fun membersCanDeleteIssuesSettingOrganizations(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: OrganizationOrder? = null, value: Boolean, init: OrganizationConnection.() -> Unit) =
        OrganizationConnection("membersCanDeleteIssuesSettingOrganizations").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("value", value) }.also { doInit(it, init) }
    val membersCanDeleteRepositoriesSetting get() =
        ScalarNode("membersCanDeleteRepositoriesSetting").also { doInit(it) }
    fun membersCanDeleteRepositoriesSettingOrganizations(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: OrganizationOrder? = null, value: Boolean, init: OrganizationConnection.() -> Unit) =
        OrganizationConnection("membersCanDeleteRepositoriesSettingOrganizations").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("value", value) }.also { doInit(it, init) }
    val membersCanInviteCollaboratorsSetting get() =
        ScalarNode("membersCanInviteCollaboratorsSetting").also { doInit(it) }
    fun membersCanInviteCollaboratorsSettingOrganizations(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: OrganizationOrder? = null, value: Boolean, init: OrganizationConnection.() -> Unit) =
        OrganizationConnection("membersCanInviteCollaboratorsSettingOrganizations").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("value", value) }.also { doInit(it, init) }
    val membersCanMakePurchasesSetting get() =
        ScalarNode("membersCanMakePurchasesSetting").also { doInit(it) }
    val membersCanUpdateProtectedBranchesSetting get() =
        ScalarNode("membersCanUpdateProtectedBranchesSetting").also { doInit(it) }
    fun membersCanUpdateProtectedBranchesSettingOrganizations(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: OrganizationOrder? = null, value: Boolean, init: OrganizationConnection.() -> Unit) =
        OrganizationConnection("membersCanUpdateProtectedBranchesSettingOrganizations").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("value", value) }.also { doInit(it, init) }
    val membersCanViewDependencyInsightsSetting get() =
        ScalarNode("membersCanViewDependencyInsightsSetting").also { doInit(it) }
    fun membersCanViewDependencyInsightsSettingOrganizations(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: OrganizationOrder? = null, value: Boolean, init: OrganizationConnection.() -> Unit) =
        OrganizationConnection("membersCanViewDependencyInsightsSettingOrganizations").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("value", value) }.also { doInit(it, init) }
    val organizationProjectsSetting get() =
        ScalarNode("organizationProjectsSetting").also { doInit(it) }
    fun organizationProjectsSettingOrganizations(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: OrganizationOrder? = null, value: Boolean, init: OrganizationConnection.() -> Unit) =
        OrganizationConnection("organizationProjectsSettingOrganizations").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("value", value) }.also { doInit(it, init) }
    fun outsideCollaborators(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, login: String? = null, orderBy: EnterpriseMemberOrder? = null, query: String? = null, visibility: RepositoryVisibility? = null, init: EnterpriseOutsideCollaboratorConnection.() -> Unit) =
        EnterpriseOutsideCollaboratorConnection("outsideCollaborators").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("login", login) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("query", query) }.apply { addArgs("visibility", visibility) }.also { doInit(it, init) }
    fun pendingAdminInvitations(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: EnterpriseAdministratorInvitationOrder? = null, query: String? = null, role: EnterpriseAdministratorRole? = null, init: EnterpriseAdministratorInvitationConnection.() -> Unit) =
        EnterpriseAdministratorInvitationConnection("pendingAdminInvitations").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("query", query) }.apply { addArgs("role", role) }.also { doInit(it, init) }
    fun pendingCollaboratorInvitations(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: RepositoryInvitationOrder? = null, query: String? = null, init: RepositoryInvitationConnection.() -> Unit) =
        RepositoryInvitationConnection("pendingCollaboratorInvitations").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("query", query) }.also { doInit(it, init) }
    @Deprecated("Repository invitations can now be associated with an email, not only an invitee. Use the `pendingCollaboratorInvitations` field instead. Removal on 2020-10-01 UTC.")
    fun pendingCollaborators(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: RepositoryInvitationOrder? = null, query: String? = null, init: EnterprisePendingCollaboratorConnection.() -> Unit) =
        EnterprisePendingCollaboratorConnection("pendingCollaborators").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("query", query) }.also { doInit(it, init) }
    fun pendingMemberInvitations(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, query: String? = null, init: EnterprisePendingMemberInvitationConnection.() -> Unit) =
        EnterprisePendingMemberInvitationConnection("pendingMemberInvitations").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("query", query) }.also { doInit(it, init) }
    val repositoryProjectsSetting get() =
        ScalarNode("repositoryProjectsSetting").also { doInit(it) }
    fun repositoryProjectsSettingOrganizations(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: OrganizationOrder? = null, value: Boolean, init: OrganizationConnection.() -> Unit) =
        OrganizationConnection("repositoryProjectsSettingOrganizations").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("value", value) }.also { doInit(it, init) }
    fun samlIdentityProvider(init: EnterpriseIdentityProvider.() -> Unit) =
        EnterpriseIdentityProvider("samlIdentityProvider").also { doInit(it, init) }
    fun samlIdentityProviderSettingOrganizations(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: OrganizationOrder? = null, value: IdentityProviderConfigurationState, init: OrganizationConnection.() -> Unit) =
        OrganizationConnection("samlIdentityProviderSettingOrganizations").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("value", value) }.also { doInit(it, init) }
    val teamDiscussionsSetting get() =
        ScalarNode("teamDiscussionsSetting").also { doInit(it) }
    fun teamDiscussionsSettingOrganizations(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: OrganizationOrder? = null, value: Boolean, init: OrganizationConnection.() -> Unit) =
        OrganizationConnection("teamDiscussionsSettingOrganizations").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("value", value) }.also { doInit(it, init) }
    val twoFactorRequiredSetting get() =
        ScalarNode("twoFactorRequiredSetting").also { doInit(it) }
    fun twoFactorRequiredSettingOrganizations(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: OrganizationOrder? = null, value: Boolean, init: OrganizationConnection.() -> Unit) =
        OrganizationConnection("twoFactorRequiredSettingOrganizations").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("value", value) }.also { doInit(it, init) }
}

class EnterprisePendingCollaboratorConnection(__name: String = "EnterprisePendingCollaboratorConnection"): ObjectNode(__name) {
    fun edges(init: EnterprisePendingCollaboratorEdge.() -> Unit) =
        EnterprisePendingCollaboratorEdge("edges").also { doInit(it, init) }
    fun nodes(init: User.() -> Unit) =
        User("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class EnterprisePendingCollaboratorEdge(__name: String = "EnterprisePendingCollaboratorEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    @Deprecated("All pending collaborators consume a license Removal on 2021-01-01 UTC.")
    val isUnlicensed get() =
        ScalarNode("isUnlicensed").also { doInit(it) }
    fun node(init: User.() -> Unit) =
        User("node").also { doInit(it, init) }
    fun repositories(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: RepositoryOrder? = null, init: EnterpriseRepositoryInfoConnection.() -> Unit) =
        EnterpriseRepositoryInfoConnection("repositories").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
}

class EnterprisePendingMemberInvitationConnection(__name: String = "EnterprisePendingMemberInvitationConnection"): ObjectNode(__name) {
    fun edges(init: EnterprisePendingMemberInvitationEdge.() -> Unit) =
        EnterprisePendingMemberInvitationEdge("edges").also { doInit(it, init) }
    fun nodes(init: OrganizationInvitation.() -> Unit) =
        OrganizationInvitation("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
    val totalUniqueUserCount get() =
        ScalarNode("totalUniqueUserCount").also { doInit(it) }
}

class EnterprisePendingMemberInvitationEdge(__name: String = "EnterprisePendingMemberInvitationEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    @Deprecated("All pending members consume a license Removal on 2020-07-01 UTC.")
    val isUnlicensed get() =
        ScalarNode("isUnlicensed").also { doInit(it) }
    fun node(init: OrganizationInvitation.() -> Unit) =
        OrganizationInvitation("node").also { doInit(it, init) }
}

class EnterpriseRepositoryInfo(__name: String = "EnterpriseRepositoryInfo"): ObjectNode(__name) {
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val isPrivate get() =
        ScalarNode("isPrivate").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    val nameWithOwner get() =
        ScalarNode("nameWithOwner").also { doInit(it) }
}

class EnterpriseRepositoryInfoConnection(__name: String = "EnterpriseRepositoryInfoConnection"): ObjectNode(__name) {
    fun edges(init: EnterpriseRepositoryInfoEdge.() -> Unit) =
        EnterpriseRepositoryInfoEdge("edges").also { doInit(it, init) }
    fun nodes(init: EnterpriseRepositoryInfo.() -> Unit) =
        EnterpriseRepositoryInfo("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class EnterpriseRepositoryInfoEdge(__name: String = "EnterpriseRepositoryInfoEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: EnterpriseRepositoryInfo.() -> Unit) =
        EnterpriseRepositoryInfo("node").also { doInit(it, init) }
}

class EnterpriseServerInstallation(__name: String = "EnterpriseServerInstallation"): ObjectNode(__name) {
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val customerName get() =
        ScalarNode("customerName").also { doInit(it) }
    val hostName get() =
        ScalarNode("hostName").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val isConnected get() =
        ScalarNode("isConnected").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    fun userAccounts(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: EnterpriseServerUserAccountOrder? = null, init: EnterpriseServerUserAccountConnection.() -> Unit) =
        EnterpriseServerUserAccountConnection("userAccounts").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun userAccountsUploads(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: EnterpriseServerUserAccountsUploadOrder? = null, init: EnterpriseServerUserAccountsUploadConnection.() -> Unit) =
        EnterpriseServerUserAccountsUploadConnection("userAccountsUploads").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
}

class EnterpriseServerInstallationConnection(__name: String = "EnterpriseServerInstallationConnection"): ObjectNode(__name) {
    fun edges(init: EnterpriseServerInstallationEdge.() -> Unit) =
        EnterpriseServerInstallationEdge("edges").also { doInit(it, init) }
    fun nodes(init: EnterpriseServerInstallation.() -> Unit) =
        EnterpriseServerInstallation("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class EnterpriseServerInstallationEdge(__name: String = "EnterpriseServerInstallationEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: EnterpriseServerInstallation.() -> Unit) =
        EnterpriseServerInstallation("node").also { doInit(it, init) }
}

class EnterpriseServerUserAccount(__name: String = "EnterpriseServerUserAccount"): ObjectNode(__name) {
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    fun emails(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: EnterpriseServerUserAccountEmailOrder? = null, init: EnterpriseServerUserAccountEmailConnection.() -> Unit) =
        EnterpriseServerUserAccountEmailConnection("emails").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun enterpriseServerInstallation(init: EnterpriseServerInstallation.() -> Unit) =
        EnterpriseServerInstallation("enterpriseServerInstallation").also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val isSiteAdmin get() =
        ScalarNode("isSiteAdmin").also { doInit(it) }
    val login get() =
        ScalarNode("login").also { doInit(it) }
    val profileName get() =
        ScalarNode("profileName").also { doInit(it) }
    val remoteCreatedAt get() =
        ScalarNode("remoteCreatedAt").also { doInit(it) }
    val remoteUserId get() =
        ScalarNode("remoteUserId").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
}

class EnterpriseServerUserAccountConnection(__name: String = "EnterpriseServerUserAccountConnection"): ObjectNode(__name) {
    fun edges(init: EnterpriseServerUserAccountEdge.() -> Unit) =
        EnterpriseServerUserAccountEdge("edges").also { doInit(it, init) }
    fun nodes(init: EnterpriseServerUserAccount.() -> Unit) =
        EnterpriseServerUserAccount("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class EnterpriseServerUserAccountEdge(__name: String = "EnterpriseServerUserAccountEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: EnterpriseServerUserAccount.() -> Unit) =
        EnterpriseServerUserAccount("node").also { doInit(it, init) }
}

class EnterpriseServerUserAccountEmail(__name: String = "EnterpriseServerUserAccountEmail"): ObjectNode(__name) {
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val email get() =
        ScalarNode("email").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val isPrimary get() =
        ScalarNode("isPrimary").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    fun userAccount(init: EnterpriseServerUserAccount.() -> Unit) =
        EnterpriseServerUserAccount("userAccount").also { doInit(it, init) }
}

class EnterpriseServerUserAccountEmailConnection(__name: String = "EnterpriseServerUserAccountEmailConnection"): ObjectNode(__name) {
    fun edges(init: EnterpriseServerUserAccountEmailEdge.() -> Unit) =
        EnterpriseServerUserAccountEmailEdge("edges").also { doInit(it, init) }
    fun nodes(init: EnterpriseServerUserAccountEmail.() -> Unit) =
        EnterpriseServerUserAccountEmail("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class EnterpriseServerUserAccountEmailEdge(__name: String = "EnterpriseServerUserAccountEmailEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: EnterpriseServerUserAccountEmail.() -> Unit) =
        EnterpriseServerUserAccountEmail("node").also { doInit(it, init) }
}

class EnterpriseServerUserAccountsUpload(__name: String = "EnterpriseServerUserAccountsUpload"): ObjectNode(__name) {
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    fun enterprise(init: Enterprise.() -> Unit) =
        Enterprise("enterprise").also { doInit(it, init) }
    fun enterpriseServerInstallation(init: EnterpriseServerInstallation.() -> Unit) =
        EnterpriseServerInstallation("enterpriseServerInstallation").also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    val syncState get() =
        ScalarNode("syncState").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
}

class EnterpriseServerUserAccountsUploadConnection(__name: String = "EnterpriseServerUserAccountsUploadConnection"): ObjectNode(__name) {
    fun edges(init: EnterpriseServerUserAccountsUploadEdge.() -> Unit) =
        EnterpriseServerUserAccountsUploadEdge("edges").also { doInit(it, init) }
    fun nodes(init: EnterpriseServerUserAccountsUpload.() -> Unit) =
        EnterpriseServerUserAccountsUpload("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class EnterpriseServerUserAccountsUploadEdge(__name: String = "EnterpriseServerUserAccountsUploadEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: EnterpriseServerUserAccountsUpload.() -> Unit) =
        EnterpriseServerUserAccountsUpload("node").also { doInit(it, init) }
}

class EnterpriseUserAccount(__name: String = "EnterpriseUserAccount"): ObjectNode(__name) {
    fun avatarUrl(size: Int? = null) =
        ScalarWithArgsNode("avatarUrl", mapOf("size" to size)).also { doInit(it) }
    val avatarUrl get() =
        ScalarNode("avatarUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    fun enterprise(init: Enterprise.() -> Unit) =
        Enterprise("enterprise").also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val login get() =
        ScalarNode("login").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    fun organizations(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: OrganizationOrder? = null, query: String? = null, role: EnterpriseUserAccountMembershipRole? = null, init: EnterpriseOrganizationMembershipConnection.() -> Unit) =
        EnterpriseOrganizationMembershipConnection("organizations").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("query", query) }.apply { addArgs("role", role) }.also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
}

class EnterpriseUserAccountConnection(__name: String = "EnterpriseUserAccountConnection"): ObjectNode(__name) {
    fun edges(init: EnterpriseUserAccountEdge.() -> Unit) =
        EnterpriseUserAccountEdge("edges").also { doInit(it, init) }
    fun nodes(init: EnterpriseUserAccount.() -> Unit) =
        EnterpriseUserAccount("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class EnterpriseUserAccountEdge(__name: String = "EnterpriseUserAccountEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: EnterpriseUserAccount.() -> Unit) =
        EnterpriseUserAccount("node").also { doInit(it, init) }
}

class ExternalIdentity(__name: String = "ExternalIdentity"): ObjectNode(__name) {
    val guid get() =
        ScalarNode("guid").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun organizationInvitation(init: OrganizationInvitation.() -> Unit) =
        OrganizationInvitation("organizationInvitation").also { doInit(it, init) }
    fun samlIdentity(init: ExternalIdentitySamlAttributes.() -> Unit) =
        ExternalIdentitySamlAttributes("samlIdentity").also { doInit(it, init) }
    fun scimIdentity(init: ExternalIdentityScimAttributes.() -> Unit) =
        ExternalIdentityScimAttributes("scimIdentity").also { doInit(it, init) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
}

class ExternalIdentityConnection(__name: String = "ExternalIdentityConnection"): ObjectNode(__name) {
    fun edges(init: ExternalIdentityEdge.() -> Unit) =
        ExternalIdentityEdge("edges").also { doInit(it, init) }
    fun nodes(init: ExternalIdentity.() -> Unit) =
        ExternalIdentity("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class ExternalIdentityEdge(__name: String = "ExternalIdentityEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: ExternalIdentity.() -> Unit) =
        ExternalIdentity("node").also { doInit(it, init) }
}

class ExternalIdentitySamlAttributes(__name: String = "ExternalIdentitySamlAttributes"): ObjectNode(__name) {
    fun emails(init: UserEmailMetadata.() -> Unit) =
        UserEmailMetadata("emails").also { doInit(it, init) }
    val familyName get() =
        ScalarNode("familyName").also { doInit(it) }
    val givenName get() =
        ScalarNode("givenName").also { doInit(it) }
    val groups get() =
        ScalarNode("groups").also { doInit(it) }
    val nameId get() =
        ScalarNode("nameId").also { doInit(it) }
    val username get() =
        ScalarNode("username").also { doInit(it) }
}

class ExternalIdentityScimAttributes(__name: String = "ExternalIdentityScimAttributes"): ObjectNode(__name) {
    fun emails(init: UserEmailMetadata.() -> Unit) =
        UserEmailMetadata("emails").also { doInit(it, init) }
    val familyName get() =
        ScalarNode("familyName").also { doInit(it) }
    val givenName get() =
        ScalarNode("givenName").also { doInit(it) }
    val groups get() =
        ScalarNode("groups").also { doInit(it) }
    val username get() =
        ScalarNode("username").also { doInit(it) }
}

class FollowUserPayload(__name: String = "FollowUserPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
}

class FollowerConnection(__name: String = "FollowerConnection"): ObjectNode(__name) {
    fun edges(init: UserEdge.() -> Unit) =
        UserEdge("edges").also { doInit(it, init) }
    fun nodes(init: User.() -> Unit) =
        User("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class FollowingConnection(__name: String = "FollowingConnection"): ObjectNode(__name) {
    fun edges(init: UserEdge.() -> Unit) =
        UserEdge("edges").also { doInit(it, init) }
    fun nodes(init: User.() -> Unit) =
        User("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class FundingLink(__name: String = "FundingLink"): ObjectNode(__name) {
    val platform get() =
        ScalarNode("platform").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
}

class GenericHovercardContext(__name: String = "GenericHovercardContext"): ObjectNode(__name) {
    val message get() =
        ScalarNode("message").also { doInit(it) }
    val octicon get() =
        ScalarNode("octicon").also { doInit(it) }
}

class Gist(__name: String = "Gist"): ObjectNode(__name) {
    fun comments(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: GistCommentConnection.() -> Unit) =
        GistCommentConnection("comments").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val description get() =
        ScalarNode("description").also { doInit(it) }
    fun files(limit: Int? = null, oid: GitObjectID? = null, init: GistFile.() -> Unit) =
        GistFile("files").apply { addArgs("limit", limit) }.apply { addArgs("oid", oid) }.also { doInit(it, init) }
    fun forks(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: GistOrder? = null, init: GistConnection.() -> Unit) =
        GistConnection("forks").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val isFork get() =
        ScalarNode("isFork").also { doInit(it) }
    val isPublic get() =
        ScalarNode("isPublic").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    fun owner(init: RepositoryOwner.() -> Unit) =
        RepositoryOwner("owner").also { doInit(it, init) }
    val pushedAt get() =
        ScalarNode("pushedAt").also { doInit(it) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val stargazerCount get() =
        ScalarNode("stargazerCount").also { doInit(it) }
    fun stargazers(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: StarOrder? = null, init: StargazerConnection.() -> Unit) =
        StargazerConnection("stargazers").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    val viewerHasStarred get() =
        ScalarNode("viewerHasStarred").also { doInit(it) }
}

class GistComment(__name: String = "GistComment"): ObjectNode(__name) {
    fun author(init: Actor.() -> Unit) =
        Actor("author").also { doInit(it, init) }
    val authorAssociation get() =
        ScalarNode("authorAssociation").also { doInit(it) }
    val body get() =
        ScalarNode("body").also { doInit(it) }
    val bodyHTML get() =
        ScalarNode("bodyHTML").also { doInit(it) }
    val bodyText get() =
        ScalarNode("bodyText").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val createdViaEmail get() =
        ScalarNode("createdViaEmail").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    fun editor(init: Actor.() -> Unit) =
        Actor("editor").also { doInit(it, init) }
    fun gist(init: Gist.() -> Unit) =
        Gist("gist").also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val includesCreatedEdit get() =
        ScalarNode("includesCreatedEdit").also { doInit(it) }
    val isMinimized get() =
        ScalarNode("isMinimized").also { doInit(it) }
    val lastEditedAt get() =
        ScalarNode("lastEditedAt").also { doInit(it) }
    val minimizedReason get() =
        ScalarNode("minimizedReason").also { doInit(it) }
    val publishedAt get() =
        ScalarNode("publishedAt").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    fun userContentEdits(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: UserContentEditConnection.() -> Unit) =
        UserContentEditConnection("userContentEdits").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val viewerCanDelete get() =
        ScalarNode("viewerCanDelete").also { doInit(it) }
    val viewerCanMinimize get() =
        ScalarNode("viewerCanMinimize").also { doInit(it) }
    val viewerCanUpdate get() =
        ScalarNode("viewerCanUpdate").also { doInit(it) }
    val viewerCannotUpdateReasons get() =
        ScalarNode("viewerCannotUpdateReasons").also { doInit(it) }
    val viewerDidAuthor get() =
        ScalarNode("viewerDidAuthor").also { doInit(it) }
}

class GistCommentConnection(__name: String = "GistCommentConnection"): ObjectNode(__name) {
    fun edges(init: GistCommentEdge.() -> Unit) =
        GistCommentEdge("edges").also { doInit(it, init) }
    fun nodes(init: GistComment.() -> Unit) =
        GistComment("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class GistCommentEdge(__name: String = "GistCommentEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: GistComment.() -> Unit) =
        GistComment("node").also { doInit(it, init) }
}

class GistConnection(__name: String = "GistConnection"): ObjectNode(__name) {
    fun edges(init: GistEdge.() -> Unit) =
        GistEdge("edges").also { doInit(it, init) }
    fun nodes(init: Gist.() -> Unit) =
        Gist("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class GistEdge(__name: String = "GistEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: Gist.() -> Unit) =
        Gist("node").also { doInit(it, init) }
}

class GistFile(__name: String = "GistFile"): ObjectNode(__name) {
    val encodedName get() =
        ScalarNode("encodedName").also { doInit(it) }
    val encoding get() =
        ScalarNode("encoding").also { doInit(it) }
    val extension get() =
        ScalarNode("extension").also { doInit(it) }
    val isImage get() =
        ScalarNode("isImage").also { doInit(it) }
    val isTruncated get() =
        ScalarNode("isTruncated").also { doInit(it) }
    fun language(init: Language.() -> Unit) =
        Language("language").also { doInit(it, init) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    val size get() =
        ScalarNode("size").also { doInit(it) }
    fun text(truncate: Int? = null) =
        ScalarWithArgsNode("text", mapOf("truncate" to truncate)).also { doInit(it) }
    val text get() =
        ScalarNode("text").also { doInit(it) }
}

class GitActor(__name: String = "GitActor"): ObjectNode(__name) {
    fun avatarUrl(size: Int? = null) =
        ScalarWithArgsNode("avatarUrl", mapOf("size" to size)).also { doInit(it) }
    val avatarUrl get() =
        ScalarNode("avatarUrl").also { doInit(it) }
    val date get() =
        ScalarNode("date").also { doInit(it) }
    val email get() =
        ScalarNode("email").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
}

class GitActorConnection(__name: String = "GitActorConnection"): ObjectNode(__name) {
    fun edges(init: GitActorEdge.() -> Unit) =
        GitActorEdge("edges").also { doInit(it, init) }
    fun nodes(init: GitActor.() -> Unit) =
        GitActor("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class GitActorEdge(__name: String = "GitActorEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: GitActor.() -> Unit) =
        GitActor("node").also { doInit(it, init) }
}

class GitHubMetadata(__name: String = "GitHubMetadata"): ObjectNode(__name) {
    val gitHubServicesSha get() =
        ScalarNode("gitHubServicesSha").also { doInit(it) }
    val gitIpAddresses get() =
        ScalarNode("gitIpAddresses").also { doInit(it) }
    val hookIpAddresses get() =
        ScalarNode("hookIpAddresses").also { doInit(it) }
    val importerIpAddresses get() =
        ScalarNode("importerIpAddresses").also { doInit(it) }
    val isPasswordAuthenticationVerifiable get() =
        ScalarNode("isPasswordAuthenticationVerifiable").also { doInit(it) }
    val pagesIpAddresses get() =
        ScalarNode("pagesIpAddresses").also { doInit(it) }
}

class GpgSignature(__name: String = "GpgSignature"): ObjectNode(__name) {
    val email get() =
        ScalarNode("email").also { doInit(it) }
    val isValid get() =
        ScalarNode("isValid").also { doInit(it) }
    val keyId get() =
        ScalarNode("keyId").also { doInit(it) }
    val payload get() =
        ScalarNode("payload").also { doInit(it) }
    val signature get() =
        ScalarNode("signature").also { doInit(it) }
    fun signer(init: User.() -> Unit) =
        User("signer").also { doInit(it, init) }
    val state get() =
        ScalarNode("state").also { doInit(it) }
    val wasSignedByGitHub get() =
        ScalarNode("wasSignedByGitHub").also { doInit(it) }
}

class HeadRefDeletedEvent(__name: String = "HeadRefDeletedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    fun headRef(init: Ref.() -> Unit) =
        Ref("headRef").also { doInit(it, init) }
    val headRefName get() =
        ScalarNode("headRefName").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
}

class HeadRefForcePushedEvent(__name: String = "HeadRefForcePushedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    fun afterCommit(init: Commit.() -> Unit) =
        Commit("afterCommit").also { doInit(it, init) }
    fun beforeCommit(init: Commit.() -> Unit) =
        Commit("beforeCommit").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
    fun ref(init: Ref.() -> Unit) =
        Ref("ref").also { doInit(it, init) }
}

class HeadRefRestoredEvent(__name: String = "HeadRefRestoredEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
}

class Hovercard(__name: String = "Hovercard"): ObjectNode(__name) {
    fun contexts(init: HovercardContext.() -> Unit) =
        HovercardContext("contexts").also { doInit(it, init) }
}

class ImportProjectPayload(__name: String = "ImportProjectPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun project(init: Project.() -> Unit) =
        Project("project").also { doInit(it, init) }
}

class InviteEnterpriseAdminPayload(__name: String = "InviteEnterpriseAdminPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun invitation(init: EnterpriseAdministratorInvitation.() -> Unit) =
        EnterpriseAdministratorInvitation("invitation").also { doInit(it, init) }
}

class IpAllowListEntry(__name: String = "IpAllowListEntry"): ObjectNode(__name) {
    val allowListValue get() =
        ScalarNode("allowListValue").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val isActive get() =
        ScalarNode("isActive").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    fun owner(init: IpAllowListOwner.() -> Unit) =
        IpAllowListOwner("owner").also { doInit(it, init) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
}

class IpAllowListEntryConnection(__name: String = "IpAllowListEntryConnection"): ObjectNode(__name) {
    fun edges(init: IpAllowListEntryEdge.() -> Unit) =
        IpAllowListEntryEdge("edges").also { doInit(it, init) }
    fun nodes(init: IpAllowListEntry.() -> Unit) =
        IpAllowListEntry("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class IpAllowListEntryEdge(__name: String = "IpAllowListEntryEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: IpAllowListEntry.() -> Unit) =
        IpAllowListEntry("node").also { doInit(it, init) }
}

class Issue(__name: String = "Issue"): ObjectNode(__name) {
    val activeLockReason get() =
        ScalarNode("activeLockReason").also { doInit(it) }
    fun assignees(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: UserConnection.() -> Unit) =
        UserConnection("assignees").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun author(init: Actor.() -> Unit) =
        Actor("author").also { doInit(it, init) }
    val authorAssociation get() =
        ScalarNode("authorAssociation").also { doInit(it) }
    val body get() =
        ScalarNode("body").also { doInit(it) }
    val bodyHTML get() =
        ScalarNode("bodyHTML").also { doInit(it) }
    val bodyResourcePath get() =
        ScalarNode("bodyResourcePath").also { doInit(it) }
    val bodyText get() =
        ScalarNode("bodyText").also { doInit(it) }
    val bodyUrl get() =
        ScalarNode("bodyUrl").also { doInit(it) }
    val closed get() =
        ScalarNode("closed").also { doInit(it) }
    val closedAt get() =
        ScalarNode("closedAt").also { doInit(it) }
    fun comments(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: IssueCommentConnection.() -> Unit) =
        IssueCommentConnection("comments").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val createdViaEmail get() =
        ScalarNode("createdViaEmail").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    fun editor(init: Actor.() -> Unit) =
        Actor("editor").also { doInit(it, init) }
    fun hovercard(includeNotificationContexts: Boolean? = null, init: Hovercard.() -> Unit) =
        Hovercard("hovercard").apply { addArgs("includeNotificationContexts", includeNotificationContexts) }.also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val includesCreatedEdit get() =
        ScalarNode("includesCreatedEdit").also { doInit(it) }
    val isReadByViewer get() =
        ScalarNode("isReadByViewer").also { doInit(it) }
    fun labels(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: LabelOrder? = null, init: LabelConnection.() -> Unit) =
        LabelConnection("labels").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    val lastEditedAt get() =
        ScalarNode("lastEditedAt").also { doInit(it) }
    val locked get() =
        ScalarNode("locked").also { doInit(it) }
    fun milestone(init: Milestone.() -> Unit) =
        Milestone("milestone").also { doInit(it, init) }
    val number get() =
        ScalarNode("number").also { doInit(it) }
    fun participants(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: UserConnection.() -> Unit) =
        UserConnection("participants").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun projectCards(after: String? = null, archivedStates: ProjectCardArchivedState? = null, before: String? = null, first: Int? = null, last: Int? = null, init: ProjectCardConnection.() -> Unit) =
        ProjectCardConnection("projectCards").apply { addArgs("after", after) }.apply { addArgs("archivedStates", archivedStates) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val publishedAt get() =
        ScalarNode("publishedAt").also { doInit(it) }
    fun reactionGroups(init: ReactionGroup.() -> Unit) =
        ReactionGroup("reactionGroups").also { doInit(it, init) }
    fun reactions(after: String? = null, before: String? = null, content: ReactionContent? = null, first: Int? = null, last: Int? = null, orderBy: ReactionOrder? = null, init: ReactionConnection.() -> Unit) =
        ReactionConnection("reactions").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("content", content) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val state get() =
        ScalarNode("state").also { doInit(it) }
    @Deprecated("`timeline` will be removed Use Issue.timelineItems instead. Removal on 2020-10-01 UTC.")
    fun timeline(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, since: DateTime? = null, init: IssueTimelineConnection.() -> Unit) =
        IssueTimelineConnection("timeline").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("since", since) }.also { doInit(it, init) }
    fun timelineItems(after: String? = null, before: String? = null, first: Int? = null, itemTypes: IssueTimelineItemsItemType? = null, last: Int? = null, since: DateTime? = null, skip: Int? = null, init: IssueTimelineItemsConnection.() -> Unit) =
        IssueTimelineItemsConnection("timelineItems").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("itemTypes", itemTypes) }.apply { addArgs("last", last) }.apply { addArgs("since", since) }.apply { addArgs("skip", skip) }.also { doInit(it, init) }
    val title get() =
        ScalarNode("title").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    fun userContentEdits(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: UserContentEditConnection.() -> Unit) =
        UserContentEditConnection("userContentEdits").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val viewerCanReact get() =
        ScalarNode("viewerCanReact").also { doInit(it) }
    val viewerCanSubscribe get() =
        ScalarNode("viewerCanSubscribe").also { doInit(it) }
    val viewerCanUpdate get() =
        ScalarNode("viewerCanUpdate").also { doInit(it) }
    val viewerCannotUpdateReasons get() =
        ScalarNode("viewerCannotUpdateReasons").also { doInit(it) }
    val viewerDidAuthor get() =
        ScalarNode("viewerDidAuthor").also { doInit(it) }
    val viewerSubscription get() =
        ScalarNode("viewerSubscription").also { doInit(it) }
}

class IssueComment(__name: String = "IssueComment"): ObjectNode(__name) {
    fun author(init: Actor.() -> Unit) =
        Actor("author").also { doInit(it, init) }
    val authorAssociation get() =
        ScalarNode("authorAssociation").also { doInit(it) }
    val body get() =
        ScalarNode("body").also { doInit(it) }
    val bodyHTML get() =
        ScalarNode("bodyHTML").also { doInit(it) }
    val bodyText get() =
        ScalarNode("bodyText").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val createdViaEmail get() =
        ScalarNode("createdViaEmail").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    fun editor(init: Actor.() -> Unit) =
        Actor("editor").also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val includesCreatedEdit get() =
        ScalarNode("includesCreatedEdit").also { doInit(it) }
    val isMinimized get() =
        ScalarNode("isMinimized").also { doInit(it) }
    fun issue(init: Issue.() -> Unit) =
        Issue("issue").also { doInit(it, init) }
    val lastEditedAt get() =
        ScalarNode("lastEditedAt").also { doInit(it) }
    val minimizedReason get() =
        ScalarNode("minimizedReason").also { doInit(it) }
    val publishedAt get() =
        ScalarNode("publishedAt").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
    fun reactionGroups(init: ReactionGroup.() -> Unit) =
        ReactionGroup("reactionGroups").also { doInit(it, init) }
    fun reactions(after: String? = null, before: String? = null, content: ReactionContent? = null, first: Int? = null, last: Int? = null, orderBy: ReactionOrder? = null, init: ReactionConnection.() -> Unit) =
        ReactionConnection("reactions").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("content", content) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    fun userContentEdits(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: UserContentEditConnection.() -> Unit) =
        UserContentEditConnection("userContentEdits").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val viewerCanDelete get() =
        ScalarNode("viewerCanDelete").also { doInit(it) }
    val viewerCanMinimize get() =
        ScalarNode("viewerCanMinimize").also { doInit(it) }
    val viewerCanReact get() =
        ScalarNode("viewerCanReact").also { doInit(it) }
    val viewerCanUpdate get() =
        ScalarNode("viewerCanUpdate").also { doInit(it) }
    val viewerCannotUpdateReasons get() =
        ScalarNode("viewerCannotUpdateReasons").also { doInit(it) }
    val viewerDidAuthor get() =
        ScalarNode("viewerDidAuthor").also { doInit(it) }
}

class IssueCommentConnection(__name: String = "IssueCommentConnection"): ObjectNode(__name) {
    fun edges(init: IssueCommentEdge.() -> Unit) =
        IssueCommentEdge("edges").also { doInit(it, init) }
    fun nodes(init: IssueComment.() -> Unit) =
        IssueComment("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class IssueCommentEdge(__name: String = "IssueCommentEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: IssueComment.() -> Unit) =
        IssueComment("node").also { doInit(it, init) }
}

class IssueConnection(__name: String = "IssueConnection"): ObjectNode(__name) {
    fun edges(init: IssueEdge.() -> Unit) =
        IssueEdge("edges").also { doInit(it, init) }
    fun nodes(init: Issue.() -> Unit) =
        Issue("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class IssueContributionsByRepository(__name: String = "IssueContributionsByRepository"): ObjectNode(__name) {
    fun contributions(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: ContributionOrder? = null, init: CreatedIssueContributionConnection.() -> Unit) =
        CreatedIssueContributionConnection("contributions").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
}

class IssueEdge(__name: String = "IssueEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: Issue.() -> Unit) =
        Issue("node").also { doInit(it, init) }
}

class IssueTemplate(__name: String = "IssueTemplate"): ObjectNode(__name) {
    val about get() =
        ScalarNode("about").also { doInit(it) }
    val body get() =
        ScalarNode("body").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    val title get() =
        ScalarNode("title").also { doInit(it) }
}

class IssueTimelineConnection(__name: String = "IssueTimelineConnection"): ObjectNode(__name) {
    fun edges(init: IssueTimelineItemEdge.() -> Unit) =
        IssueTimelineItemEdge("edges").also { doInit(it, init) }
    fun nodes(init: IssueTimelineItem.() -> Unit) =
        IssueTimelineItem("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class IssueTimelineItemEdge(__name: String = "IssueTimelineItemEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: IssueTimelineItem.() -> Unit) =
        IssueTimelineItem("node").also { doInit(it, init) }
}

class IssueTimelineItemsConnection(__name: String = "IssueTimelineItemsConnection"): ObjectNode(__name) {
    fun edges(init: IssueTimelineItemsEdge.() -> Unit) =
        IssueTimelineItemsEdge("edges").also { doInit(it, init) }
    val filteredCount get() =
        ScalarNode("filteredCount").also { doInit(it) }
    fun nodes(init: IssueTimelineItems.() -> Unit) =
        IssueTimelineItems("nodes").also { doInit(it, init) }
    val pageCount get() =
        ScalarNode("pageCount").also { doInit(it) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
}

class IssueTimelineItemsEdge(__name: String = "IssueTimelineItemsEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: IssueTimelineItems.() -> Unit) =
        IssueTimelineItems("node").also { doInit(it, init) }
}

class JoinedGitHubContribution(__name: String = "JoinedGitHubContribution"): ObjectNode(__name) {
    val isRestricted get() =
        ScalarNode("isRestricted").also { doInit(it) }
    val occurredAt get() =
        ScalarNode("occurredAt").also { doInit(it) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
}

class Label(__name: String = "Label"): ObjectNode(__name) {
    val color get() =
        ScalarNode("color").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val description get() =
        ScalarNode("description").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val isDefault get() =
        ScalarNode("isDefault").also { doInit(it) }
    fun issues(after: String? = null, before: String? = null, filterBy: IssueFilters? = null, first: Int? = null, labels: String? = null, last: Int? = null, orderBy: IssueOrder? = null, states: IssueState? = null, init: IssueConnection.() -> Unit) =
        IssueConnection("issues").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("filterBy", filterBy) }.apply { addArgs("first", first) }.apply { addArgs("labels", labels) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("states", states) }.also { doInit(it, init) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    fun pullRequests(after: String? = null, baseRefName: String? = null, before: String? = null, first: Int? = null, headRefName: String? = null, labels: String? = null, last: Int? = null, orderBy: IssueOrder? = null, states: PullRequestState? = null, init: PullRequestConnection.() -> Unit) =
        PullRequestConnection("pullRequests").apply { addArgs("after", after) }.apply { addArgs("baseRefName", baseRefName) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("headRefName", headRefName) }.apply { addArgs("labels", labels) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("states", states) }.also { doInit(it, init) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
}

class LabelConnection(__name: String = "LabelConnection"): ObjectNode(__name) {
    fun edges(init: LabelEdge.() -> Unit) =
        LabelEdge("edges").also { doInit(it, init) }
    fun nodes(init: Label.() -> Unit) =
        Label("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class LabelEdge(__name: String = "LabelEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: Label.() -> Unit) =
        Label("node").also { doInit(it, init) }
}

class LabeledEvent(__name: String = "LabeledEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun label(init: Label.() -> Unit) =
        Label("label").also { doInit(it, init) }
    fun labelable(init: Labelable.() -> Unit) =
        Labelable("labelable").also { doInit(it, init) }
}

class Language(__name: String = "Language"): ObjectNode(__name) {
    val color get() =
        ScalarNode("color").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
}

class LanguageConnection(__name: String = "LanguageConnection"): ObjectNode(__name) {
    fun edges(init: LanguageEdge.() -> Unit) =
        LanguageEdge("edges").also { doInit(it, init) }
    fun nodes(init: Language.() -> Unit) =
        Language("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
    val totalSize get() =
        ScalarNode("totalSize").also { doInit(it) }
}

class LanguageEdge(__name: String = "LanguageEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: Language.() -> Unit) =
        Language("node").also { doInit(it, init) }
    val size get() =
        ScalarNode("size").also { doInit(it) }
}

class License(__name: String = "License"): ObjectNode(__name) {
    val body get() =
        ScalarNode("body").also { doInit(it) }
    fun conditions(init: LicenseRule.() -> Unit) =
        LicenseRule("conditions").also { doInit(it, init) }
    val description get() =
        ScalarNode("description").also { doInit(it) }
    val featured get() =
        ScalarNode("featured").also { doInit(it) }
    val hidden get() =
        ScalarNode("hidden").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val implementation get() =
        ScalarNode("implementation").also { doInit(it) }
    val key get() =
        ScalarNode("key").also { doInit(it) }
    fun limitations(init: LicenseRule.() -> Unit) =
        LicenseRule("limitations").also { doInit(it, init) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    val nickname get() =
        ScalarNode("nickname").also { doInit(it) }
    fun permissions(init: LicenseRule.() -> Unit) =
        LicenseRule("permissions").also { doInit(it, init) }
    val pseudoLicense get() =
        ScalarNode("pseudoLicense").also { doInit(it) }
    val spdxId get() =
        ScalarNode("spdxId").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
}

class LicenseRule(__name: String = "LicenseRule"): ObjectNode(__name) {
    val description get() =
        ScalarNode("description").also { doInit(it) }
    val key get() =
        ScalarNode("key").also { doInit(it) }
    val label get() =
        ScalarNode("label").also { doInit(it) }
}

class LinkRepositoryToProjectPayload(__name: String = "LinkRepositoryToProjectPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun project(init: Project.() -> Unit) =
        Project("project").also { doInit(it, init) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
}

class LockLockablePayload(__name: String = "LockLockablePayload"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun lockedRecord(init: Lockable.() -> Unit) =
        Lockable("lockedRecord").also { doInit(it, init) }
}

class LockedEvent(__name: String = "LockedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val lockReason get() =
        ScalarNode("lockReason").also { doInit(it) }
    fun lockable(init: Lockable.() -> Unit) =
        Lockable("lockable").also { doInit(it, init) }
}

class Mannequin(__name: String = "Mannequin"): ObjectNode(__name) {
    fun avatarUrl(size: Int? = null) =
        ScalarWithArgsNode("avatarUrl", mapOf("size" to size)).also { doInit(it) }
    val avatarUrl get() =
        ScalarNode("avatarUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val email get() =
        ScalarNode("email").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val login get() =
        ScalarNode("login").also { doInit(it) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
}

class MarkFileAsViewedPayload(__name: String = "MarkFileAsViewedPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
}

class MarkPullRequestReadyForReviewPayload(__name: String = "MarkPullRequestReadyForReviewPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
}

class MarkedAsDuplicateEvent(__name: String = "MarkedAsDuplicateEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    fun canonical(init: IssueOrPullRequest.() -> Unit) =
        IssueOrPullRequest("canonical").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    fun duplicate(init: IssueOrPullRequest.() -> Unit) =
        IssueOrPullRequest("duplicate").also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val isCrossRepository get() =
        ScalarNode("isCrossRepository").also { doInit(it) }
}

class MarketplaceCategory(__name: String = "MarketplaceCategory"): ObjectNode(__name) {
    val description get() =
        ScalarNode("description").also { doInit(it) }
    val howItWorks get() =
        ScalarNode("howItWorks").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    val primaryListingCount get() =
        ScalarNode("primaryListingCount").also { doInit(it) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val secondaryListingCount get() =
        ScalarNode("secondaryListingCount").also { doInit(it) }
    val slug get() =
        ScalarNode("slug").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
}

class MarketplaceListing(__name: String = "MarketplaceListing"): ObjectNode(__name) {
    fun app(init: App.() -> Unit) =
        App("app").also { doInit(it, init) }
    val companyUrl get() =
        ScalarNode("companyUrl").also { doInit(it) }
    val configurationResourcePath get() =
        ScalarNode("configurationResourcePath").also { doInit(it) }
    val configurationUrl get() =
        ScalarNode("configurationUrl").also { doInit(it) }
    val documentationUrl get() =
        ScalarNode("documentationUrl").also { doInit(it) }
    val extendedDescription get() =
        ScalarNode("extendedDescription").also { doInit(it) }
    val extendedDescriptionHTML get() =
        ScalarNode("extendedDescriptionHTML").also { doInit(it) }
    val fullDescription get() =
        ScalarNode("fullDescription").also { doInit(it) }
    val fullDescriptionHTML get() =
        ScalarNode("fullDescriptionHTML").also { doInit(it) }
    val hasPublishedFreeTrialPlans get() =
        ScalarNode("hasPublishedFreeTrialPlans").also { doInit(it) }
    val hasTermsOfService get() =
        ScalarNode("hasTermsOfService").also { doInit(it) }
    val howItWorks get() =
        ScalarNode("howItWorks").also { doInit(it) }
    val howItWorksHTML get() =
        ScalarNode("howItWorksHTML").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val installationUrl get() =
        ScalarNode("installationUrl").also { doInit(it) }
    val installedForViewer get() =
        ScalarNode("installedForViewer").also { doInit(it) }
    val isArchived get() =
        ScalarNode("isArchived").also { doInit(it) }
    val isDraft get() =
        ScalarNode("isDraft").also { doInit(it) }
    val isPaid get() =
        ScalarNode("isPaid").also { doInit(it) }
    val isPublic get() =
        ScalarNode("isPublic").also { doInit(it) }
    val isRejected get() =
        ScalarNode("isRejected").also { doInit(it) }
    val isUnverified get() =
        ScalarNode("isUnverified").also { doInit(it) }
    val isUnverifiedPending get() =
        ScalarNode("isUnverifiedPending").also { doInit(it) }
    val isVerificationPendingFromDraft get() =
        ScalarNode("isVerificationPendingFromDraft").also { doInit(it) }
    val isVerificationPendingFromUnverified get() =
        ScalarNode("isVerificationPendingFromUnverified").also { doInit(it) }
    val isVerified get() =
        ScalarNode("isVerified").also { doInit(it) }
    val logoBackgroundColor get() =
        ScalarNode("logoBackgroundColor").also { doInit(it) }
    fun logoUrl(size: Int? = null) =
        ScalarWithArgsNode("logoUrl", mapOf("size" to size)).also { doInit(it) }
    val logoUrl get() =
        ScalarNode("logoUrl").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    val normalizedShortDescription get() =
        ScalarNode("normalizedShortDescription").also { doInit(it) }
    val pricingUrl get() =
        ScalarNode("pricingUrl").also { doInit(it) }
    fun primaryCategory(init: MarketplaceCategory.() -> Unit) =
        MarketplaceCategory("primaryCategory").also { doInit(it, init) }
    val privacyPolicyUrl get() =
        ScalarNode("privacyPolicyUrl").also { doInit(it) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val screenshotUrls get() =
        ScalarNode("screenshotUrls").also { doInit(it) }
    fun secondaryCategory(init: MarketplaceCategory.() -> Unit) =
        MarketplaceCategory("secondaryCategory").also { doInit(it, init) }
    val shortDescription get() =
        ScalarNode("shortDescription").also { doInit(it) }
    val slug get() =
        ScalarNode("slug").also { doInit(it) }
    val statusUrl get() =
        ScalarNode("statusUrl").also { doInit(it) }
    val supportEmail get() =
        ScalarNode("supportEmail").also { doInit(it) }
    val supportUrl get() =
        ScalarNode("supportUrl").also { doInit(it) }
    val termsOfServiceUrl get() =
        ScalarNode("termsOfServiceUrl").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    val viewerCanAddPlans get() =
        ScalarNode("viewerCanAddPlans").also { doInit(it) }
    val viewerCanApprove get() =
        ScalarNode("viewerCanApprove").also { doInit(it) }
    val viewerCanDelist get() =
        ScalarNode("viewerCanDelist").also { doInit(it) }
    val viewerCanEdit get() =
        ScalarNode("viewerCanEdit").also { doInit(it) }
    val viewerCanEditCategories get() =
        ScalarNode("viewerCanEditCategories").also { doInit(it) }
    val viewerCanEditPlans get() =
        ScalarNode("viewerCanEditPlans").also { doInit(it) }
    val viewerCanRedraft get() =
        ScalarNode("viewerCanRedraft").also { doInit(it) }
    val viewerCanReject get() =
        ScalarNode("viewerCanReject").also { doInit(it) }
    val viewerCanRequestApproval get() =
        ScalarNode("viewerCanRequestApproval").also { doInit(it) }
    val viewerHasPurchased get() =
        ScalarNode("viewerHasPurchased").also { doInit(it) }
    val viewerHasPurchasedForAllOrganizations get() =
        ScalarNode("viewerHasPurchasedForAllOrganizations").also { doInit(it) }
    val viewerIsListingAdmin get() =
        ScalarNode("viewerIsListingAdmin").also { doInit(it) }
}

class MarketplaceListingConnection(__name: String = "MarketplaceListingConnection"): ObjectNode(__name) {
    fun edges(init: MarketplaceListingEdge.() -> Unit) =
        MarketplaceListingEdge("edges").also { doInit(it, init) }
    fun nodes(init: MarketplaceListing.() -> Unit) =
        MarketplaceListing("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class MarketplaceListingEdge(__name: String = "MarketplaceListingEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: MarketplaceListing.() -> Unit) =
        MarketplaceListing("node").also { doInit(it, init) }
}

class MembersCanDeleteReposClearAuditEntry(__name: String = "MembersCanDeleteReposClearAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val enterpriseResourcePath get() =
        ScalarNode("enterpriseResourcePath").also { doInit(it) }
    val enterpriseSlug get() =
        ScalarNode("enterpriseSlug").also { doInit(it) }
    val enterpriseUrl get() =
        ScalarNode("enterpriseUrl").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class MembersCanDeleteReposDisableAuditEntry(__name: String = "MembersCanDeleteReposDisableAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val enterpriseResourcePath get() =
        ScalarNode("enterpriseResourcePath").also { doInit(it) }
    val enterpriseSlug get() =
        ScalarNode("enterpriseSlug").also { doInit(it) }
    val enterpriseUrl get() =
        ScalarNode("enterpriseUrl").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class MembersCanDeleteReposEnableAuditEntry(__name: String = "MembersCanDeleteReposEnableAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val enterpriseResourcePath get() =
        ScalarNode("enterpriseResourcePath").also { doInit(it) }
    val enterpriseSlug get() =
        ScalarNode("enterpriseSlug").also { doInit(it) }
    val enterpriseUrl get() =
        ScalarNode("enterpriseUrl").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class MentionedEvent(__name: String = "MentionedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
}

class MergeBranchPayload(__name: String = "MergeBranchPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun mergeCommit(init: Commit.() -> Unit) =
        Commit("mergeCommit").also { doInit(it, init) }
}

class MergePullRequestPayload(__name: String = "MergePullRequestPayload"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
}

class MergedEvent(__name: String = "MergedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    fun commit(init: Commit.() -> Unit) =
        Commit("commit").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun mergeRef(init: Ref.() -> Unit) =
        Ref("mergeRef").also { doInit(it, init) }
    val mergeRefName get() =
        ScalarNode("mergeRefName").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
}

class Milestone(__name: String = "Milestone"): ObjectNode(__name) {
    val closed get() =
        ScalarNode("closed").also { doInit(it) }
    val closedAt get() =
        ScalarNode("closedAt").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    fun creator(init: Actor.() -> Unit) =
        Actor("creator").also { doInit(it, init) }
    val description get() =
        ScalarNode("description").also { doInit(it) }
    val dueOn get() =
        ScalarNode("dueOn").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun issues(after: String? = null, before: String? = null, filterBy: IssueFilters? = null, first: Int? = null, labels: String? = null, last: Int? = null, orderBy: IssueOrder? = null, states: IssueState? = null, init: IssueConnection.() -> Unit) =
        IssueConnection("issues").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("filterBy", filterBy) }.apply { addArgs("first", first) }.apply { addArgs("labels", labels) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("states", states) }.also { doInit(it, init) }
    val number get() =
        ScalarNode("number").also { doInit(it) }
    val progressPercentage get() =
        ScalarNode("progressPercentage").also { doInit(it) }
    fun pullRequests(after: String? = null, baseRefName: String? = null, before: String? = null, first: Int? = null, headRefName: String? = null, labels: String? = null, last: Int? = null, orderBy: IssueOrder? = null, states: PullRequestState? = null, init: PullRequestConnection.() -> Unit) =
        PullRequestConnection("pullRequests").apply { addArgs("after", after) }.apply { addArgs("baseRefName", baseRefName) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("headRefName", headRefName) }.apply { addArgs("labels", labels) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("states", states) }.also { doInit(it, init) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val state get() =
        ScalarNode("state").also { doInit(it) }
    val title get() =
        ScalarNode("title").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
}

class MilestoneConnection(__name: String = "MilestoneConnection"): ObjectNode(__name) {
    fun edges(init: MilestoneEdge.() -> Unit) =
        MilestoneEdge("edges").also { doInit(it, init) }
    fun nodes(init: Milestone.() -> Unit) =
        Milestone("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class MilestoneEdge(__name: String = "MilestoneEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: Milestone.() -> Unit) =
        Milestone("node").also { doInit(it, init) }
}

class MilestonedEvent(__name: String = "MilestonedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val milestoneTitle get() =
        ScalarNode("milestoneTitle").also { doInit(it) }
    fun subject(init: MilestoneItem.() -> Unit) =
        MilestoneItem("subject").also { doInit(it, init) }
}

class MinimizeCommentPayload(__name: String = "MinimizeCommentPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun minimizedComment(init: Minimizable.() -> Unit) =
        Minimizable("minimizedComment").also { doInit(it, init) }
}

class MoveProjectCardPayload(__name: String = "MoveProjectCardPayload"): ObjectNode(__name) {
    fun cardEdge(init: ProjectCardEdge.() -> Unit) =
        ProjectCardEdge("cardEdge").also { doInit(it, init) }
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
}

class MoveProjectColumnPayload(__name: String = "MoveProjectColumnPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun columnEdge(init: ProjectColumnEdge.() -> Unit) =
        ProjectColumnEdge("columnEdge").also { doInit(it, init) }
}

class MovedColumnsInProjectEvent(__name: String = "MovedColumnsInProjectEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val previousProjectColumnName get() =
        ScalarNode("previousProjectColumnName").also { doInit(it) }
    fun project(init: Project.() -> Unit) =
        Project("project").also { doInit(it, init) }
    fun projectCard(init: ProjectCard.() -> Unit) =
        ProjectCard("projectCard").also { doInit(it, init) }
    val projectColumnName get() =
        ScalarNode("projectColumnName").also { doInit(it) }
}

class Mutation(__name: String = "mutation"): ObjectNode(__name) {
    fun acceptEnterpriseAdministratorInvitation(input: AcceptEnterpriseAdministratorInvitationInput, init: AcceptEnterpriseAdministratorInvitationPayload.() -> Unit) =
        AcceptEnterpriseAdministratorInvitationPayload("acceptEnterpriseAdministratorInvitation").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun acceptTopicSuggestion(input: AcceptTopicSuggestionInput, init: AcceptTopicSuggestionPayload.() -> Unit) =
        AcceptTopicSuggestionPayload("acceptTopicSuggestion").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun addAssigneesToAssignable(input: AddAssigneesToAssignableInput, init: AddAssigneesToAssignablePayload.() -> Unit) =
        AddAssigneesToAssignablePayload("addAssigneesToAssignable").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun addComment(input: AddCommentInput, init: AddCommentPayload.() -> Unit) =
        AddCommentPayload("addComment").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun addLabelsToLabelable(input: AddLabelsToLabelableInput, init: AddLabelsToLabelablePayload.() -> Unit) =
        AddLabelsToLabelablePayload("addLabelsToLabelable").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun addProjectCard(input: AddProjectCardInput, init: AddProjectCardPayload.() -> Unit) =
        AddProjectCardPayload("addProjectCard").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun addProjectColumn(input: AddProjectColumnInput, init: AddProjectColumnPayload.() -> Unit) =
        AddProjectColumnPayload("addProjectColumn").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun addPullRequestReview(input: AddPullRequestReviewInput, init: AddPullRequestReviewPayload.() -> Unit) =
        AddPullRequestReviewPayload("addPullRequestReview").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun addPullRequestReviewComment(input: AddPullRequestReviewCommentInput, init: AddPullRequestReviewCommentPayload.() -> Unit) =
        AddPullRequestReviewCommentPayload("addPullRequestReviewComment").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun addPullRequestReviewThread(input: AddPullRequestReviewThreadInput, init: AddPullRequestReviewThreadPayload.() -> Unit) =
        AddPullRequestReviewThreadPayload("addPullRequestReviewThread").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun addReaction(input: AddReactionInput, init: AddReactionPayload.() -> Unit) =
        AddReactionPayload("addReaction").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun addStar(input: AddStarInput, init: AddStarPayload.() -> Unit) =
        AddStarPayload("addStar").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun archiveRepository(input: ArchiveRepositoryInput, init: ArchiveRepositoryPayload.() -> Unit) =
        ArchiveRepositoryPayload("archiveRepository").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun cancelEnterpriseAdminInvitation(input: CancelEnterpriseAdminInvitationInput, init: CancelEnterpriseAdminInvitationPayload.() -> Unit) =
        CancelEnterpriseAdminInvitationPayload("cancelEnterpriseAdminInvitation").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun changeUserStatus(input: ChangeUserStatusInput, init: ChangeUserStatusPayload.() -> Unit) =
        ChangeUserStatusPayload("changeUserStatus").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun clearLabelsFromLabelable(input: ClearLabelsFromLabelableInput, init: ClearLabelsFromLabelablePayload.() -> Unit) =
        ClearLabelsFromLabelablePayload("clearLabelsFromLabelable").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun cloneProject(input: CloneProjectInput, init: CloneProjectPayload.() -> Unit) =
        CloneProjectPayload("cloneProject").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun cloneTemplateRepository(input: CloneTemplateRepositoryInput, init: CloneTemplateRepositoryPayload.() -> Unit) =
        CloneTemplateRepositoryPayload("cloneTemplateRepository").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun closeIssue(input: CloseIssueInput, init: CloseIssuePayload.() -> Unit) =
        CloseIssuePayload("closeIssue").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun closePullRequest(input: ClosePullRequestInput, init: ClosePullRequestPayload.() -> Unit) =
        ClosePullRequestPayload("closePullRequest").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun convertProjectCardNoteToIssue(input: ConvertProjectCardNoteToIssueInput, init: ConvertProjectCardNoteToIssuePayload.() -> Unit) =
        ConvertProjectCardNoteToIssuePayload("convertProjectCardNoteToIssue").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun createBranchProtectionRule(input: CreateBranchProtectionRuleInput, init: CreateBranchProtectionRulePayload.() -> Unit) =
        CreateBranchProtectionRulePayload("createBranchProtectionRule").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun createCheckRun(input: CreateCheckRunInput, init: CreateCheckRunPayload.() -> Unit) =
        CreateCheckRunPayload("createCheckRun").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun createCheckSuite(input: CreateCheckSuiteInput, init: CreateCheckSuitePayload.() -> Unit) =
        CreateCheckSuitePayload("createCheckSuite").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun createContentAttachment(input: CreateContentAttachmentInput, init: CreateContentAttachmentPayload.() -> Unit) =
        CreateContentAttachmentPayload("createContentAttachment").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun createDeployment(input: CreateDeploymentInput, init: CreateDeploymentPayload.() -> Unit) =
        CreateDeploymentPayload("createDeployment").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun createDeploymentStatus(input: CreateDeploymentStatusInput, init: CreateDeploymentStatusPayload.() -> Unit) =
        CreateDeploymentStatusPayload("createDeploymentStatus").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun createEnterpriseOrganization(input: CreateEnterpriseOrganizationInput, init: CreateEnterpriseOrganizationPayload.() -> Unit) =
        CreateEnterpriseOrganizationPayload("createEnterpriseOrganization").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun createIpAllowListEntry(input: CreateIpAllowListEntryInput, init: CreateIpAllowListEntryPayload.() -> Unit) =
        CreateIpAllowListEntryPayload("createIpAllowListEntry").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun createIssue(input: CreateIssueInput, init: CreateIssuePayload.() -> Unit) =
        CreateIssuePayload("createIssue").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun createLabel(input: CreateLabelInput, init: CreateLabelPayload.() -> Unit) =
        CreateLabelPayload("createLabel").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun createProject(input: CreateProjectInput, init: CreateProjectPayload.() -> Unit) =
        CreateProjectPayload("createProject").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun createPullRequest(input: CreatePullRequestInput, init: CreatePullRequestPayload.() -> Unit) =
        CreatePullRequestPayload("createPullRequest").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun createRef(input: CreateRefInput, init: CreateRefPayload.() -> Unit) =
        CreateRefPayload("createRef").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun createRepository(input: CreateRepositoryInput, init: CreateRepositoryPayload.() -> Unit) =
        CreateRepositoryPayload("createRepository").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun createTeamDiscussion(input: CreateTeamDiscussionInput, init: CreateTeamDiscussionPayload.() -> Unit) =
        CreateTeamDiscussionPayload("createTeamDiscussion").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun createTeamDiscussionComment(input: CreateTeamDiscussionCommentInput, init: CreateTeamDiscussionCommentPayload.() -> Unit) =
        CreateTeamDiscussionCommentPayload("createTeamDiscussionComment").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun declineTopicSuggestion(input: DeclineTopicSuggestionInput, init: DeclineTopicSuggestionPayload.() -> Unit) =
        DeclineTopicSuggestionPayload("declineTopicSuggestion").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun deleteBranchProtectionRule(input: DeleteBranchProtectionRuleInput, init: DeleteBranchProtectionRulePayload.() -> Unit) =
        DeleteBranchProtectionRulePayload("deleteBranchProtectionRule").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun deleteDeployment(input: DeleteDeploymentInput, init: DeleteDeploymentPayload.() -> Unit) =
        DeleteDeploymentPayload("deleteDeployment").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun deleteIpAllowListEntry(input: DeleteIpAllowListEntryInput, init: DeleteIpAllowListEntryPayload.() -> Unit) =
        DeleteIpAllowListEntryPayload("deleteIpAllowListEntry").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun deleteIssue(input: DeleteIssueInput, init: DeleteIssuePayload.() -> Unit) =
        DeleteIssuePayload("deleteIssue").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun deleteIssueComment(input: DeleteIssueCommentInput, init: DeleteIssueCommentPayload.() -> Unit) =
        DeleteIssueCommentPayload("deleteIssueComment").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun deleteLabel(input: DeleteLabelInput, init: DeleteLabelPayload.() -> Unit) =
        DeleteLabelPayload("deleteLabel").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun deletePackageVersion(input: DeletePackageVersionInput, init: DeletePackageVersionPayload.() -> Unit) =
        DeletePackageVersionPayload("deletePackageVersion").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun deleteProject(input: DeleteProjectInput, init: DeleteProjectPayload.() -> Unit) =
        DeleteProjectPayload("deleteProject").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun deleteProjectCard(input: DeleteProjectCardInput, init: DeleteProjectCardPayload.() -> Unit) =
        DeleteProjectCardPayload("deleteProjectCard").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun deleteProjectColumn(input: DeleteProjectColumnInput, init: DeleteProjectColumnPayload.() -> Unit) =
        DeleteProjectColumnPayload("deleteProjectColumn").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun deletePullRequestReview(input: DeletePullRequestReviewInput, init: DeletePullRequestReviewPayload.() -> Unit) =
        DeletePullRequestReviewPayload("deletePullRequestReview").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun deletePullRequestReviewComment(input: DeletePullRequestReviewCommentInput, init: DeletePullRequestReviewCommentPayload.() -> Unit) =
        DeletePullRequestReviewCommentPayload("deletePullRequestReviewComment").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun deleteRef(input: DeleteRefInput, init: DeleteRefPayload.() -> Unit) =
        DeleteRefPayload("deleteRef").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun deleteTeamDiscussion(input: DeleteTeamDiscussionInput, init: DeleteTeamDiscussionPayload.() -> Unit) =
        DeleteTeamDiscussionPayload("deleteTeamDiscussion").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun deleteTeamDiscussionComment(input: DeleteTeamDiscussionCommentInput, init: DeleteTeamDiscussionCommentPayload.() -> Unit) =
        DeleteTeamDiscussionCommentPayload("deleteTeamDiscussionComment").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun dismissPullRequestReview(input: DismissPullRequestReviewInput, init: DismissPullRequestReviewPayload.() -> Unit) =
        DismissPullRequestReviewPayload("dismissPullRequestReview").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun followUser(input: FollowUserInput, init: FollowUserPayload.() -> Unit) =
        FollowUserPayload("followUser").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun importProject(input: ImportProjectInput, init: ImportProjectPayload.() -> Unit) =
        ImportProjectPayload("importProject").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun inviteEnterpriseAdmin(input: InviteEnterpriseAdminInput, init: InviteEnterpriseAdminPayload.() -> Unit) =
        InviteEnterpriseAdminPayload("inviteEnterpriseAdmin").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun linkRepositoryToProject(input: LinkRepositoryToProjectInput, init: LinkRepositoryToProjectPayload.() -> Unit) =
        LinkRepositoryToProjectPayload("linkRepositoryToProject").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun lockLockable(input: LockLockableInput, init: LockLockablePayload.() -> Unit) =
        LockLockablePayload("lockLockable").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun markFileAsViewed(input: MarkFileAsViewedInput, init: MarkFileAsViewedPayload.() -> Unit) =
        MarkFileAsViewedPayload("markFileAsViewed").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun markPullRequestReadyForReview(input: MarkPullRequestReadyForReviewInput, init: MarkPullRequestReadyForReviewPayload.() -> Unit) =
        MarkPullRequestReadyForReviewPayload("markPullRequestReadyForReview").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun mergeBranch(input: MergeBranchInput, init: MergeBranchPayload.() -> Unit) =
        MergeBranchPayload("mergeBranch").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun mergePullRequest(input: MergePullRequestInput, init: MergePullRequestPayload.() -> Unit) =
        MergePullRequestPayload("mergePullRequest").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun minimizeComment(input: MinimizeCommentInput, init: MinimizeCommentPayload.() -> Unit) =
        MinimizeCommentPayload("minimizeComment").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun moveProjectCard(input: MoveProjectCardInput, init: MoveProjectCardPayload.() -> Unit) =
        MoveProjectCardPayload("moveProjectCard").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun moveProjectColumn(input: MoveProjectColumnInput, init: MoveProjectColumnPayload.() -> Unit) =
        MoveProjectColumnPayload("moveProjectColumn").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun pinIssue(input: PinIssueInput, init: PinIssuePayload.() -> Unit) =
        PinIssuePayload("pinIssue").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun regenerateEnterpriseIdentityProviderRecoveryCodes(input: RegenerateEnterpriseIdentityProviderRecoveryCodesInput, init: RegenerateEnterpriseIdentityProviderRecoveryCodesPayload.() -> Unit) =
        RegenerateEnterpriseIdentityProviderRecoveryCodesPayload("regenerateEnterpriseIdentityProviderRecoveryCodes").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun removeAssigneesFromAssignable(input: RemoveAssigneesFromAssignableInput, init: RemoveAssigneesFromAssignablePayload.() -> Unit) =
        RemoveAssigneesFromAssignablePayload("removeAssigneesFromAssignable").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun removeEnterpriseAdmin(input: RemoveEnterpriseAdminInput, init: RemoveEnterpriseAdminPayload.() -> Unit) =
        RemoveEnterpriseAdminPayload("removeEnterpriseAdmin").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun removeEnterpriseIdentityProvider(input: RemoveEnterpriseIdentityProviderInput, init: RemoveEnterpriseIdentityProviderPayload.() -> Unit) =
        RemoveEnterpriseIdentityProviderPayload("removeEnterpriseIdentityProvider").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun removeEnterpriseOrganization(input: RemoveEnterpriseOrganizationInput, init: RemoveEnterpriseOrganizationPayload.() -> Unit) =
        RemoveEnterpriseOrganizationPayload("removeEnterpriseOrganization").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun removeLabelsFromLabelable(input: RemoveLabelsFromLabelableInput, init: RemoveLabelsFromLabelablePayload.() -> Unit) =
        RemoveLabelsFromLabelablePayload("removeLabelsFromLabelable").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun removeOutsideCollaborator(input: RemoveOutsideCollaboratorInput, init: RemoveOutsideCollaboratorPayload.() -> Unit) =
        RemoveOutsideCollaboratorPayload("removeOutsideCollaborator").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun removeReaction(input: RemoveReactionInput, init: RemoveReactionPayload.() -> Unit) =
        RemoveReactionPayload("removeReaction").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun removeStar(input: RemoveStarInput, init: RemoveStarPayload.() -> Unit) =
        RemoveStarPayload("removeStar").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun reopenIssue(input: ReopenIssueInput, init: ReopenIssuePayload.() -> Unit) =
        ReopenIssuePayload("reopenIssue").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun reopenPullRequest(input: ReopenPullRequestInput, init: ReopenPullRequestPayload.() -> Unit) =
        ReopenPullRequestPayload("reopenPullRequest").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun requestReviews(input: RequestReviewsInput, init: RequestReviewsPayload.() -> Unit) =
        RequestReviewsPayload("requestReviews").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun rerequestCheckSuite(input: RerequestCheckSuiteInput, init: RerequestCheckSuitePayload.() -> Unit) =
        RerequestCheckSuitePayload("rerequestCheckSuite").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun resolveReviewThread(input: ResolveReviewThreadInput, init: ResolveReviewThreadPayload.() -> Unit) =
        ResolveReviewThreadPayload("resolveReviewThread").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun setEnterpriseIdentityProvider(input: SetEnterpriseIdentityProviderInput, init: SetEnterpriseIdentityProviderPayload.() -> Unit) =
        SetEnterpriseIdentityProviderPayload("setEnterpriseIdentityProvider").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun submitPullRequestReview(input: SubmitPullRequestReviewInput, init: SubmitPullRequestReviewPayload.() -> Unit) =
        SubmitPullRequestReviewPayload("submitPullRequestReview").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun transferIssue(input: TransferIssueInput, init: TransferIssuePayload.() -> Unit) =
        TransferIssuePayload("transferIssue").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun unarchiveRepository(input: UnarchiveRepositoryInput, init: UnarchiveRepositoryPayload.() -> Unit) =
        UnarchiveRepositoryPayload("unarchiveRepository").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun unfollowUser(input: UnfollowUserInput, init: UnfollowUserPayload.() -> Unit) =
        UnfollowUserPayload("unfollowUser").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun unlinkRepositoryFromProject(input: UnlinkRepositoryFromProjectInput, init: UnlinkRepositoryFromProjectPayload.() -> Unit) =
        UnlinkRepositoryFromProjectPayload("unlinkRepositoryFromProject").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun unlockLockable(input: UnlockLockableInput, init: UnlockLockablePayload.() -> Unit) =
        UnlockLockablePayload("unlockLockable").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun unmarkFileAsViewed(input: UnmarkFileAsViewedInput, init: UnmarkFileAsViewedPayload.() -> Unit) =
        UnmarkFileAsViewedPayload("unmarkFileAsViewed").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun unmarkIssueAsDuplicate(input: UnmarkIssueAsDuplicateInput, init: UnmarkIssueAsDuplicatePayload.() -> Unit) =
        UnmarkIssueAsDuplicatePayload("unmarkIssueAsDuplicate").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun unminimizeComment(input: UnminimizeCommentInput, init: UnminimizeCommentPayload.() -> Unit) =
        UnminimizeCommentPayload("unminimizeComment").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun unpinIssue(input: UnpinIssueInput, init: UnpinIssuePayload.() -> Unit) =
        UnpinIssuePayload("unpinIssue").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun unresolveReviewThread(input: UnresolveReviewThreadInput, init: UnresolveReviewThreadPayload.() -> Unit) =
        UnresolveReviewThreadPayload("unresolveReviewThread").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateBranchProtectionRule(input: UpdateBranchProtectionRuleInput, init: UpdateBranchProtectionRulePayload.() -> Unit) =
        UpdateBranchProtectionRulePayload("updateBranchProtectionRule").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateCheckRun(input: UpdateCheckRunInput, init: UpdateCheckRunPayload.() -> Unit) =
        UpdateCheckRunPayload("updateCheckRun").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateCheckSuitePreferences(input: UpdateCheckSuitePreferencesInput, init: UpdateCheckSuitePreferencesPayload.() -> Unit) =
        UpdateCheckSuitePreferencesPayload("updateCheckSuitePreferences").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateEnterpriseAdministratorRole(input: UpdateEnterpriseAdministratorRoleInput, init: UpdateEnterpriseAdministratorRolePayload.() -> Unit) =
        UpdateEnterpriseAdministratorRolePayload("updateEnterpriseAdministratorRole").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateEnterpriseAllowPrivateRepositoryForkingSetting(input: UpdateEnterpriseAllowPrivateRepositoryForkingSettingInput, init: UpdateEnterpriseAllowPrivateRepositoryForkingSettingPayload.() -> Unit) =
        UpdateEnterpriseAllowPrivateRepositoryForkingSettingPayload("updateEnterpriseAllowPrivateRepositoryForkingSetting").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateEnterpriseDefaultRepositoryPermissionSetting(input: UpdateEnterpriseDefaultRepositoryPermissionSettingInput, init: UpdateEnterpriseDefaultRepositoryPermissionSettingPayload.() -> Unit) =
        UpdateEnterpriseDefaultRepositoryPermissionSettingPayload("updateEnterpriseDefaultRepositoryPermissionSetting").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateEnterpriseMembersCanChangeRepositoryVisibilitySetting(input: UpdateEnterpriseMembersCanChangeRepositoryVisibilitySettingInput, init: UpdateEnterpriseMembersCanChangeRepositoryVisibilitySettingPayload.() -> Unit) =
        UpdateEnterpriseMembersCanChangeRepositoryVisibilitySettingPayload("updateEnterpriseMembersCanChangeRepositoryVisibilitySetting").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateEnterpriseMembersCanCreateRepositoriesSetting(input: UpdateEnterpriseMembersCanCreateRepositoriesSettingInput, init: UpdateEnterpriseMembersCanCreateRepositoriesSettingPayload.() -> Unit) =
        UpdateEnterpriseMembersCanCreateRepositoriesSettingPayload("updateEnterpriseMembersCanCreateRepositoriesSetting").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateEnterpriseMembersCanDeleteIssuesSetting(input: UpdateEnterpriseMembersCanDeleteIssuesSettingInput, init: UpdateEnterpriseMembersCanDeleteIssuesSettingPayload.() -> Unit) =
        UpdateEnterpriseMembersCanDeleteIssuesSettingPayload("updateEnterpriseMembersCanDeleteIssuesSetting").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateEnterpriseMembersCanDeleteRepositoriesSetting(input: UpdateEnterpriseMembersCanDeleteRepositoriesSettingInput, init: UpdateEnterpriseMembersCanDeleteRepositoriesSettingPayload.() -> Unit) =
        UpdateEnterpriseMembersCanDeleteRepositoriesSettingPayload("updateEnterpriseMembersCanDeleteRepositoriesSetting").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateEnterpriseMembersCanInviteCollaboratorsSetting(input: UpdateEnterpriseMembersCanInviteCollaboratorsSettingInput, init: UpdateEnterpriseMembersCanInviteCollaboratorsSettingPayload.() -> Unit) =
        UpdateEnterpriseMembersCanInviteCollaboratorsSettingPayload("updateEnterpriseMembersCanInviteCollaboratorsSetting").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateEnterpriseMembersCanMakePurchasesSetting(input: UpdateEnterpriseMembersCanMakePurchasesSettingInput, init: UpdateEnterpriseMembersCanMakePurchasesSettingPayload.() -> Unit) =
        UpdateEnterpriseMembersCanMakePurchasesSettingPayload("updateEnterpriseMembersCanMakePurchasesSetting").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateEnterpriseMembersCanUpdateProtectedBranchesSetting(input: UpdateEnterpriseMembersCanUpdateProtectedBranchesSettingInput, init: UpdateEnterpriseMembersCanUpdateProtectedBranchesSettingPayload.() -> Unit) =
        UpdateEnterpriseMembersCanUpdateProtectedBranchesSettingPayload("updateEnterpriseMembersCanUpdateProtectedBranchesSetting").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateEnterpriseMembersCanViewDependencyInsightsSetting(input: UpdateEnterpriseMembersCanViewDependencyInsightsSettingInput, init: UpdateEnterpriseMembersCanViewDependencyInsightsSettingPayload.() -> Unit) =
        UpdateEnterpriseMembersCanViewDependencyInsightsSettingPayload("updateEnterpriseMembersCanViewDependencyInsightsSetting").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateEnterpriseOrganizationProjectsSetting(input: UpdateEnterpriseOrganizationProjectsSettingInput, init: UpdateEnterpriseOrganizationProjectsSettingPayload.() -> Unit) =
        UpdateEnterpriseOrganizationProjectsSettingPayload("updateEnterpriseOrganizationProjectsSetting").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateEnterpriseProfile(input: UpdateEnterpriseProfileInput, init: UpdateEnterpriseProfilePayload.() -> Unit) =
        UpdateEnterpriseProfilePayload("updateEnterpriseProfile").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateEnterpriseRepositoryProjectsSetting(input: UpdateEnterpriseRepositoryProjectsSettingInput, init: UpdateEnterpriseRepositoryProjectsSettingPayload.() -> Unit) =
        UpdateEnterpriseRepositoryProjectsSettingPayload("updateEnterpriseRepositoryProjectsSetting").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateEnterpriseTeamDiscussionsSetting(input: UpdateEnterpriseTeamDiscussionsSettingInput, init: UpdateEnterpriseTeamDiscussionsSettingPayload.() -> Unit) =
        UpdateEnterpriseTeamDiscussionsSettingPayload("updateEnterpriseTeamDiscussionsSetting").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateEnterpriseTwoFactorAuthenticationRequiredSetting(input: UpdateEnterpriseTwoFactorAuthenticationRequiredSettingInput, init: UpdateEnterpriseTwoFactorAuthenticationRequiredSettingPayload.() -> Unit) =
        UpdateEnterpriseTwoFactorAuthenticationRequiredSettingPayload("updateEnterpriseTwoFactorAuthenticationRequiredSetting").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateIpAllowListEnabledSetting(input: UpdateIpAllowListEnabledSettingInput, init: UpdateIpAllowListEnabledSettingPayload.() -> Unit) =
        UpdateIpAllowListEnabledSettingPayload("updateIpAllowListEnabledSetting").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateIpAllowListEntry(input: UpdateIpAllowListEntryInput, init: UpdateIpAllowListEntryPayload.() -> Unit) =
        UpdateIpAllowListEntryPayload("updateIpAllowListEntry").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateIssue(input: UpdateIssueInput, init: UpdateIssuePayload.() -> Unit) =
        UpdateIssuePayload("updateIssue").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateIssueComment(input: UpdateIssueCommentInput, init: UpdateIssueCommentPayload.() -> Unit) =
        UpdateIssueCommentPayload("updateIssueComment").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateLabel(input: UpdateLabelInput, init: UpdateLabelPayload.() -> Unit) =
        UpdateLabelPayload("updateLabel").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateProject(input: UpdateProjectInput, init: UpdateProjectPayload.() -> Unit) =
        UpdateProjectPayload("updateProject").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateProjectCard(input: UpdateProjectCardInput, init: UpdateProjectCardPayload.() -> Unit) =
        UpdateProjectCardPayload("updateProjectCard").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateProjectColumn(input: UpdateProjectColumnInput, init: UpdateProjectColumnPayload.() -> Unit) =
        UpdateProjectColumnPayload("updateProjectColumn").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updatePullRequest(input: UpdatePullRequestInput, init: UpdatePullRequestPayload.() -> Unit) =
        UpdatePullRequestPayload("updatePullRequest").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updatePullRequestReview(input: UpdatePullRequestReviewInput, init: UpdatePullRequestReviewPayload.() -> Unit) =
        UpdatePullRequestReviewPayload("updatePullRequestReview").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updatePullRequestReviewComment(input: UpdatePullRequestReviewCommentInput, init: UpdatePullRequestReviewCommentPayload.() -> Unit) =
        UpdatePullRequestReviewCommentPayload("updatePullRequestReviewComment").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateRef(input: UpdateRefInput, init: UpdateRefPayload.() -> Unit) =
        UpdateRefPayload("updateRef").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateRefs(input: UpdateRefsInput, init: UpdateRefsPayload.() -> Unit) =
        UpdateRefsPayload("updateRefs").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateRepository(input: UpdateRepositoryInput, init: UpdateRepositoryPayload.() -> Unit) =
        UpdateRepositoryPayload("updateRepository").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateSubscription(input: UpdateSubscriptionInput, init: UpdateSubscriptionPayload.() -> Unit) =
        UpdateSubscriptionPayload("updateSubscription").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateTeamDiscussion(input: UpdateTeamDiscussionInput, init: UpdateTeamDiscussionPayload.() -> Unit) =
        UpdateTeamDiscussionPayload("updateTeamDiscussion").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateTeamDiscussionComment(input: UpdateTeamDiscussionCommentInput, init: UpdateTeamDiscussionCommentPayload.() -> Unit) =
        UpdateTeamDiscussionCommentPayload("updateTeamDiscussionComment").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateTeamReviewAssignment(input: UpdateTeamReviewAssignmentInput, init: UpdateTeamReviewAssignmentPayload.() -> Unit) =
        UpdateTeamReviewAssignmentPayload("updateTeamReviewAssignment").apply { addArgs("input", input) }.also { doInit(it, init) }
    fun updateTopics(input: UpdateTopicsInput, init: UpdateTopicsPayload.() -> Unit) =
        UpdateTopicsPayload("updateTopics").apply { addArgs("input", input) }.also { doInit(it, init) }
}

class OauthApplicationCreateAuditEntry(__name: String = "OauthApplicationCreateAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val applicationUrl get() =
        ScalarNode("applicationUrl").also { doInit(it) }
    val callbackUrl get() =
        ScalarNode("callbackUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val oauthApplicationName get() =
        ScalarNode("oauthApplicationName").also { doInit(it) }
    val oauthApplicationResourcePath get() =
        ScalarNode("oauthApplicationResourcePath").also { doInit(it) }
    val oauthApplicationUrl get() =
        ScalarNode("oauthApplicationUrl").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    val rateLimit get() =
        ScalarNode("rateLimit").also { doInit(it) }
    val state get() =
        ScalarNode("state").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class OrgAddBillingManagerAuditEntry(__name: String = "OrgAddBillingManagerAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val invitationEmail get() =
        ScalarNode("invitationEmail").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class OrgAddMemberAuditEntry(__name: String = "OrgAddMemberAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    val permission get() =
        ScalarNode("permission").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class OrgBlockUserAuditEntry(__name: String = "OrgBlockUserAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    fun blockedUser(init: User.() -> Unit) =
        User("blockedUser").also { doInit(it, init) }
    val blockedUserName get() =
        ScalarNode("blockedUserName").also { doInit(it) }
    val blockedUserResourcePath get() =
        ScalarNode("blockedUserResourcePath").also { doInit(it) }
    val blockedUserUrl get() =
        ScalarNode("blockedUserUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class OrgConfigDisableCollaboratorsOnlyAuditEntry(__name: String = "OrgConfigDisableCollaboratorsOnlyAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class OrgConfigEnableCollaboratorsOnlyAuditEntry(__name: String = "OrgConfigEnableCollaboratorsOnlyAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class OrgCreateAuditEntry(__name: String = "OrgCreateAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val billingPlan get() =
        ScalarNode("billingPlan").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class OrgDisableOauthAppRestrictionsAuditEntry(__name: String = "OrgDisableOauthAppRestrictionsAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class OrgDisableSamlAuditEntry(__name: String = "OrgDisableSamlAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val digestMethodUrl get() =
        ScalarNode("digestMethodUrl").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val issuerUrl get() =
        ScalarNode("issuerUrl").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    val signatureMethodUrl get() =
        ScalarNode("signatureMethodUrl").also { doInit(it) }
    val singleSignOnUrl get() =
        ScalarNode("singleSignOnUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class OrgDisableTwoFactorRequirementAuditEntry(__name: String = "OrgDisableTwoFactorRequirementAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class OrgEnableOauthAppRestrictionsAuditEntry(__name: String = "OrgEnableOauthAppRestrictionsAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class OrgEnableSamlAuditEntry(__name: String = "OrgEnableSamlAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val digestMethodUrl get() =
        ScalarNode("digestMethodUrl").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val issuerUrl get() =
        ScalarNode("issuerUrl").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    val signatureMethodUrl get() =
        ScalarNode("signatureMethodUrl").also { doInit(it) }
    val singleSignOnUrl get() =
        ScalarNode("singleSignOnUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class OrgEnableTwoFactorRequirementAuditEntry(__name: String = "OrgEnableTwoFactorRequirementAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class OrgInviteMemberAuditEntry(__name: String = "OrgInviteMemberAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val email get() =
        ScalarNode("email").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    fun organizationInvitation(init: OrganizationInvitation.() -> Unit) =
        OrganizationInvitation("organizationInvitation").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class OrgInviteToBusinessAuditEntry(__name: String = "OrgInviteToBusinessAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val enterpriseResourcePath get() =
        ScalarNode("enterpriseResourcePath").also { doInit(it) }
    val enterpriseSlug get() =
        ScalarNode("enterpriseSlug").also { doInit(it) }
    val enterpriseUrl get() =
        ScalarNode("enterpriseUrl").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class OrgOauthAppAccessApprovedAuditEntry(__name: String = "OrgOauthAppAccessApprovedAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val oauthApplicationName get() =
        ScalarNode("oauthApplicationName").also { doInit(it) }
    val oauthApplicationResourcePath get() =
        ScalarNode("oauthApplicationResourcePath").also { doInit(it) }
    val oauthApplicationUrl get() =
        ScalarNode("oauthApplicationUrl").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class OrgOauthAppAccessDeniedAuditEntry(__name: String = "OrgOauthAppAccessDeniedAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val oauthApplicationName get() =
        ScalarNode("oauthApplicationName").also { doInit(it) }
    val oauthApplicationResourcePath get() =
        ScalarNode("oauthApplicationResourcePath").also { doInit(it) }
    val oauthApplicationUrl get() =
        ScalarNode("oauthApplicationUrl").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class OrgOauthAppAccessRequestedAuditEntry(__name: String = "OrgOauthAppAccessRequestedAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val oauthApplicationName get() =
        ScalarNode("oauthApplicationName").also { doInit(it) }
    val oauthApplicationResourcePath get() =
        ScalarNode("oauthApplicationResourcePath").also { doInit(it) }
    val oauthApplicationUrl get() =
        ScalarNode("oauthApplicationUrl").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class OrgRemoveBillingManagerAuditEntry(__name: String = "OrgRemoveBillingManagerAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    val reason get() =
        ScalarNode("reason").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class OrgRemoveMemberAuditEntry(__name: String = "OrgRemoveMemberAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val membershipTypes get() =
        ScalarNode("membershipTypes").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    val reason get() =
        ScalarNode("reason").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class OrgRemoveOutsideCollaboratorAuditEntry(__name: String = "OrgRemoveOutsideCollaboratorAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val membershipTypes get() =
        ScalarNode("membershipTypes").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    val reason get() =
        ScalarNode("reason").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class OrgRestoreMemberAuditEntry(__name: String = "OrgRestoreMemberAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    val restoredCustomEmailRoutingsCount get() =
        ScalarNode("restoredCustomEmailRoutingsCount").also { doInit(it) }
    val restoredIssueAssignmentsCount get() =
        ScalarNode("restoredIssueAssignmentsCount").also { doInit(it) }
    fun restoredMemberships(init: OrgRestoreMemberAuditEntryMembership.() -> Unit) =
        OrgRestoreMemberAuditEntryMembership("restoredMemberships").also { doInit(it, init) }
    val restoredMembershipsCount get() =
        ScalarNode("restoredMembershipsCount").also { doInit(it) }
    val restoredRepositoriesCount get() =
        ScalarNode("restoredRepositoriesCount").also { doInit(it) }
    val restoredRepositoryStarsCount get() =
        ScalarNode("restoredRepositoryStarsCount").also { doInit(it) }
    val restoredRepositoryWatchesCount get() =
        ScalarNode("restoredRepositoryWatchesCount").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class OrgRestoreMemberMembershipOrganizationAuditEntryData(__name: String = "OrgRestoreMemberMembershipOrganizationAuditEntryData"): ObjectNode(__name) {
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
}

class OrgRestoreMemberMembershipRepositoryAuditEntryData(__name: String = "OrgRestoreMemberMembershipRepositoryAuditEntryData"): ObjectNode(__name) {
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val repositoryName get() =
        ScalarNode("repositoryName").also { doInit(it) }
    val repositoryResourcePath get() =
        ScalarNode("repositoryResourcePath").also { doInit(it) }
    val repositoryUrl get() =
        ScalarNode("repositoryUrl").also { doInit(it) }
}

class OrgRestoreMemberMembershipTeamAuditEntryData(__name: String = "OrgRestoreMemberMembershipTeamAuditEntryData"): ObjectNode(__name) {
    fun team(init: Team.() -> Unit) =
        Team("team").also { doInit(it, init) }
    val teamName get() =
        ScalarNode("teamName").also { doInit(it) }
    val teamResourcePath get() =
        ScalarNode("teamResourcePath").also { doInit(it) }
    val teamUrl get() =
        ScalarNode("teamUrl").also { doInit(it) }
}

class OrgUnblockUserAuditEntry(__name: String = "OrgUnblockUserAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    fun blockedUser(init: User.() -> Unit) =
        User("blockedUser").also { doInit(it, init) }
    val blockedUserName get() =
        ScalarNode("blockedUserName").also { doInit(it) }
    val blockedUserResourcePath get() =
        ScalarNode("blockedUserResourcePath").also { doInit(it) }
    val blockedUserUrl get() =
        ScalarNode("blockedUserUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class OrgUpdateDefaultRepositoryPermissionAuditEntry(__name: String = "OrgUpdateDefaultRepositoryPermissionAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    val permission get() =
        ScalarNode("permission").also { doInit(it) }
    val permissionWas get() =
        ScalarNode("permissionWas").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class OrgUpdateMemberAuditEntry(__name: String = "OrgUpdateMemberAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    val permission get() =
        ScalarNode("permission").also { doInit(it) }
    val permissionWas get() =
        ScalarNode("permissionWas").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class OrgUpdateMemberRepositoryCreationPermissionAuditEntry(__name: String = "OrgUpdateMemberRepositoryCreationPermissionAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val canCreateRepositories get() =
        ScalarNode("canCreateRepositories").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
    val visibility get() =
        ScalarNode("visibility").also { doInit(it) }
}

class OrgUpdateMemberRepositoryInvitationPermissionAuditEntry(__name: String = "OrgUpdateMemberRepositoryInvitationPermissionAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val canInviteOutsideCollaboratorsToRepositories get() =
        ScalarNode("canInviteOutsideCollaboratorsToRepositories").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class Organization(__name: String = "Organization"): ObjectNode(__name) {
    fun anyPinnableItems(type: PinnableItemType? = null) =
        ScalarWithArgsNode("anyPinnableItems", mapOf("type" to type)).also { doInit(it) }
    val anyPinnableItems get() =
        ScalarNode("anyPinnableItems").also { doInit(it) }
    fun auditLog(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: AuditLogOrder? = null, query: String? = null, init: OrganizationAuditEntryConnection.() -> Unit) =
        OrganizationAuditEntryConnection("auditLog").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("query", query) }.also { doInit(it, init) }
    fun avatarUrl(size: Int? = null) =
        ScalarWithArgsNode("avatarUrl", mapOf("size" to size)).also { doInit(it) }
    val avatarUrl get() =
        ScalarNode("avatarUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val description get() =
        ScalarNode("description").also { doInit(it) }
    val descriptionHTML get() =
        ScalarNode("descriptionHTML").also { doInit(it) }
    val email get() =
        ScalarNode("email").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val ipAllowListEnabledSetting get() =
        ScalarNode("ipAllowListEnabledSetting").also { doInit(it) }
    fun ipAllowListEntries(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: IpAllowListEntryOrder? = null, init: IpAllowListEntryConnection.() -> Unit) =
        IpAllowListEntryConnection("ipAllowListEntries").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    val isVerified get() =
        ScalarNode("isVerified").also { doInit(it) }
    fun itemShowcase(init: ProfileItemShowcase.() -> Unit) =
        ProfileItemShowcase("itemShowcase").also { doInit(it, init) }
    val location get() =
        ScalarNode("location").also { doInit(it) }
    val login get() =
        ScalarNode("login").also { doInit(it) }
    fun memberStatuses(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: UserStatusOrder? = null, init: UserStatusConnection.() -> Unit) =
        UserStatusConnection("memberStatuses").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun membersWithRole(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: OrganizationMemberConnection.() -> Unit) =
        OrganizationMemberConnection("membersWithRole").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    val newTeamResourcePath get() =
        ScalarNode("newTeamResourcePath").also { doInit(it) }
    val newTeamUrl get() =
        ScalarNode("newTeamUrl").also { doInit(it) }
    val organizationBillingEmail get() =
        ScalarNode("organizationBillingEmail").also { doInit(it) }
    fun packages(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, names: String? = null, orderBy: PackageOrder? = null, packageType: PackageType? = null, repositoryId: ID? = null, init: PackageConnection.() -> Unit) =
        PackageConnection("packages").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("names", names) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("packageType", packageType) }.apply { addArgs("repositoryId", repositoryId) }.also { doInit(it, init) }
    fun pendingMembers(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: UserConnection.() -> Unit) =
        UserConnection("pendingMembers").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun pinnableItems(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, types: PinnableItemType? = null, init: PinnableItemConnection.() -> Unit) =
        PinnableItemConnection("pinnableItems").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("types", types) }.also { doInit(it, init) }
    fun pinnedItems(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, types: PinnableItemType? = null, init: PinnableItemConnection.() -> Unit) =
        PinnableItemConnection("pinnedItems").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("types", types) }.also { doInit(it, init) }
    val pinnedItemsRemaining get() =
        ScalarNode("pinnedItemsRemaining").also { doInit(it) }
    fun project(number: Int, init: Project.() -> Unit) =
        Project("project").apply { addArgs("number", number) }.also { doInit(it, init) }
    fun projects(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: ProjectOrder? = null, search: String? = null, states: ProjectState? = null, init: ProjectConnection.() -> Unit) =
        ProjectConnection("projects").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("search", search) }.apply { addArgs("states", states) }.also { doInit(it, init) }
    val projectsResourcePath get() =
        ScalarNode("projectsResourcePath").also { doInit(it) }
    val projectsUrl get() =
        ScalarNode("projectsUrl").also { doInit(it) }
    fun repositories(affiliations: RepositoryAffiliation? = null, after: String? = null, before: String? = null, first: Int? = null, isFork: Boolean? = null, isLocked: Boolean? = null, last: Int? = null, orderBy: RepositoryOrder? = null, ownerAffiliations: RepositoryAffiliation? = null, privacy: RepositoryPrivacy? = null, init: RepositoryConnection.() -> Unit) =
        RepositoryConnection("repositories").apply { addArgs("affiliations", affiliations) }.apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("isFork", isFork) }.apply { addArgs("isLocked", isLocked) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("ownerAffiliations", ownerAffiliations) }.apply { addArgs("privacy", privacy) }.also { doInit(it, init) }
    fun repository(name: String, init: Repository.() -> Unit) =
        Repository("repository").apply { addArgs("name", name) }.also { doInit(it, init) }
    val requiresTwoFactorAuthentication get() =
        ScalarNode("requiresTwoFactorAuthentication").also { doInit(it) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    fun samlIdentityProvider(init: OrganizationIdentityProvider.() -> Unit) =
        OrganizationIdentityProvider("samlIdentityProvider").also { doInit(it, init) }
    fun sponsorsListing(init: SponsorsListing.() -> Unit) =
        SponsorsListing("sponsorsListing").also { doInit(it, init) }
    fun sponsorshipsAsMaintainer(after: String? = null, before: String? = null, first: Int? = null, includePrivate: Boolean? = null, last: Int? = null, orderBy: SponsorshipOrder? = null, init: SponsorshipConnection.() -> Unit) =
        SponsorshipConnection("sponsorshipsAsMaintainer").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("includePrivate", includePrivate) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun sponsorshipsAsSponsor(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: SponsorshipOrder? = null, init: SponsorshipConnection.() -> Unit) =
        SponsorshipConnection("sponsorshipsAsSponsor").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun team(slug: String, init: Team.() -> Unit) =
        Team("team").apply { addArgs("slug", slug) }.also { doInit(it, init) }
    fun teams(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, ldapMapped: Boolean? = null, orderBy: TeamOrder? = null, privacy: TeamPrivacy? = null, query: String? = null, role: TeamRole? = null, rootTeamsOnly: Boolean? = null, userLogins: String? = null, init: TeamConnection.() -> Unit) =
        TeamConnection("teams").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("ldapMapped", ldapMapped) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("privacy", privacy) }.apply { addArgs("query", query) }.apply { addArgs("role", role) }.apply { addArgs("rootTeamsOnly", rootTeamsOnly) }.apply { addArgs("userLogins", userLogins) }.also { doInit(it, init) }
    val teamsResourcePath get() =
        ScalarNode("teamsResourcePath").also { doInit(it) }
    val teamsUrl get() =
        ScalarNode("teamsUrl").also { doInit(it) }
    val twitterUsername get() =
        ScalarNode("twitterUsername").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    val viewerCanAdminister get() =
        ScalarNode("viewerCanAdminister").also { doInit(it) }
    val viewerCanChangePinnedItems get() =
        ScalarNode("viewerCanChangePinnedItems").also { doInit(it) }
    val viewerCanCreateProjects get() =
        ScalarNode("viewerCanCreateProjects").also { doInit(it) }
    val viewerCanCreateRepositories get() =
        ScalarNode("viewerCanCreateRepositories").also { doInit(it) }
    val viewerCanCreateTeams get() =
        ScalarNode("viewerCanCreateTeams").also { doInit(it) }
    val viewerIsAMember get() =
        ScalarNode("viewerIsAMember").also { doInit(it) }
    val websiteUrl get() =
        ScalarNode("websiteUrl").also { doInit(it) }
}

class OrganizationAuditEntryConnection(__name: String = "OrganizationAuditEntryConnection"): ObjectNode(__name) {
    fun edges(init: OrganizationAuditEntryEdge.() -> Unit) =
        OrganizationAuditEntryEdge("edges").also { doInit(it, init) }
    fun nodes(init: OrganizationAuditEntry.() -> Unit) =
        OrganizationAuditEntry("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class OrganizationAuditEntryEdge(__name: String = "OrganizationAuditEntryEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: OrganizationAuditEntry.() -> Unit) =
        OrganizationAuditEntry("node").also { doInit(it, init) }
}

class OrganizationConnection(__name: String = "OrganizationConnection"): ObjectNode(__name) {
    fun edges(init: OrganizationEdge.() -> Unit) =
        OrganizationEdge("edges").also { doInit(it, init) }
    fun nodes(init: Organization.() -> Unit) =
        Organization("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class OrganizationEdge(__name: String = "OrganizationEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: Organization.() -> Unit) =
        Organization("node").also { doInit(it, init) }
}

class OrganizationIdentityProvider(__name: String = "OrganizationIdentityProvider"): ObjectNode(__name) {
    val digestMethod get() =
        ScalarNode("digestMethod").also { doInit(it) }
    fun externalIdentities(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: ExternalIdentityConnection.() -> Unit) =
        ExternalIdentityConnection("externalIdentities").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val idpCertificate get() =
        ScalarNode("idpCertificate").also { doInit(it) }
    val issuer get() =
        ScalarNode("issuer").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val signatureMethod get() =
        ScalarNode("signatureMethod").also { doInit(it) }
    val ssoUrl get() =
        ScalarNode("ssoUrl").also { doInit(it) }
}

class OrganizationInvitation(__name: String = "OrganizationInvitation"): ObjectNode(__name) {
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val email get() =
        ScalarNode("email").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val invitationType get() =
        ScalarNode("invitationType").also { doInit(it) }
    fun invitee(init: User.() -> Unit) =
        User("invitee").also { doInit(it, init) }
    fun inviter(init: User.() -> Unit) =
        User("inviter").also { doInit(it, init) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val role get() =
        ScalarNode("role").also { doInit(it) }
}

class OrganizationInvitationConnection(__name: String = "OrganizationInvitationConnection"): ObjectNode(__name) {
    fun edges(init: OrganizationInvitationEdge.() -> Unit) =
        OrganizationInvitationEdge("edges").also { doInit(it, init) }
    fun nodes(init: OrganizationInvitation.() -> Unit) =
        OrganizationInvitation("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class OrganizationInvitationEdge(__name: String = "OrganizationInvitationEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: OrganizationInvitation.() -> Unit) =
        OrganizationInvitation("node").also { doInit(it, init) }
}

class OrganizationMemberConnection(__name: String = "OrganizationMemberConnection"): ObjectNode(__name) {
    fun edges(init: OrganizationMemberEdge.() -> Unit) =
        OrganizationMemberEdge("edges").also { doInit(it, init) }
    fun nodes(init: User.() -> Unit) =
        User("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class OrganizationMemberEdge(__name: String = "OrganizationMemberEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    val hasTwoFactorEnabled get() =
        ScalarNode("hasTwoFactorEnabled").also { doInit(it) }
    fun node(init: User.() -> Unit) =
        User("node").also { doInit(it, init) }
    val role get() =
        ScalarNode("role").also { doInit(it) }
}

class OrganizationTeamsHovercardContext(__name: String = "OrganizationTeamsHovercardContext"): ObjectNode(__name) {
    val message get() =
        ScalarNode("message").also { doInit(it) }
    val octicon get() =
        ScalarNode("octicon").also { doInit(it) }
    fun relevantTeams(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: TeamConnection.() -> Unit) =
        TeamConnection("relevantTeams").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val teamsResourcePath get() =
        ScalarNode("teamsResourcePath").also { doInit(it) }
    val teamsUrl get() =
        ScalarNode("teamsUrl").also { doInit(it) }
    val totalTeamCount get() =
        ScalarNode("totalTeamCount").also { doInit(it) }
}

class OrganizationsHovercardContext(__name: String = "OrganizationsHovercardContext"): ObjectNode(__name) {
    val message get() =
        ScalarNode("message").also { doInit(it) }
    val octicon get() =
        ScalarNode("octicon").also { doInit(it) }
    fun relevantOrganizations(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: OrganizationConnection.() -> Unit) =
        OrganizationConnection("relevantOrganizations").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val totalOrganizationCount get() =
        ScalarNode("totalOrganizationCount").also { doInit(it) }
}

class Package(__name: String = "Package"): ObjectNode(__name) {
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun latestVersion(init: PackageVersion.() -> Unit) =
        PackageVersion("latestVersion").also { doInit(it, init) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    val packageType get() =
        ScalarNode("packageType").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    fun statistics(init: PackageStatistics.() -> Unit) =
        PackageStatistics("statistics").also { doInit(it, init) }
    fun version(version: String, init: PackageVersion.() -> Unit) =
        PackageVersion("version").apply { addArgs("version", version) }.also { doInit(it, init) }
    fun versions(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: PackageVersionOrder? = null, init: PackageVersionConnection.() -> Unit) =
        PackageVersionConnection("versions").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
}

class PackageConnection(__name: String = "PackageConnection"): ObjectNode(__name) {
    fun edges(init: PackageEdge.() -> Unit) =
        PackageEdge("edges").also { doInit(it, init) }
    fun nodes(init: Package.() -> Unit) =
        Package("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class PackageEdge(__name: String = "PackageEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: Package.() -> Unit) =
        Package("node").also { doInit(it, init) }
}

class PackageFile(__name: String = "PackageFile"): ObjectNode(__name) {
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val md5 get() =
        ScalarNode("md5").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    fun packageVersion(init: PackageVersion.() -> Unit) =
        PackageVersion("packageVersion").also { doInit(it, init) }
    val sha1 get() =
        ScalarNode("sha1").also { doInit(it) }
    val sha256 get() =
        ScalarNode("sha256").also { doInit(it) }
    val size get() =
        ScalarNode("size").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
}

class PackageFileConnection(__name: String = "PackageFileConnection"): ObjectNode(__name) {
    fun edges(init: PackageFileEdge.() -> Unit) =
        PackageFileEdge("edges").also { doInit(it, init) }
    fun nodes(init: PackageFile.() -> Unit) =
        PackageFile("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class PackageFileEdge(__name: String = "PackageFileEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: PackageFile.() -> Unit) =
        PackageFile("node").also { doInit(it, init) }
}

class PackageStatistics(__name: String = "PackageStatistics"): ObjectNode(__name) {
    val downloadsTotalCount get() =
        ScalarNode("downloadsTotalCount").also { doInit(it) }
}

class PackageTag(__name: String = "PackageTag"): ObjectNode(__name) {
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    fun version(init: PackageVersion.() -> Unit) =
        PackageVersion("version").also { doInit(it, init) }
}

class PackageVersion(__name: String = "PackageVersion"): ObjectNode(__name) {
    fun files(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: PackageFileOrder? = null, init: PackageFileConnection.() -> Unit) =
        PackageFileConnection("files").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun `package`(init: Package.() -> Unit) =
        Package("package").also { doInit(it, init) }
    val platform get() =
        ScalarNode("platform").also { doInit(it) }
    val preRelease get() =
        ScalarNode("preRelease").also { doInit(it) }
    val readme get() =
        ScalarNode("readme").also { doInit(it) }
    fun release(init: Release.() -> Unit) =
        Release("release").also { doInit(it, init) }
    fun statistics(init: PackageVersionStatistics.() -> Unit) =
        PackageVersionStatistics("statistics").also { doInit(it, init) }
    val summary get() =
        ScalarNode("summary").also { doInit(it) }
    val version get() =
        ScalarNode("version").also { doInit(it) }
}

class PackageVersionConnection(__name: String = "PackageVersionConnection"): ObjectNode(__name) {
    fun edges(init: PackageVersionEdge.() -> Unit) =
        PackageVersionEdge("edges").also { doInit(it, init) }
    fun nodes(init: PackageVersion.() -> Unit) =
        PackageVersion("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class PackageVersionEdge(__name: String = "PackageVersionEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: PackageVersion.() -> Unit) =
        PackageVersion("node").also { doInit(it, init) }
}

class PackageVersionStatistics(__name: String = "PackageVersionStatistics"): ObjectNode(__name) {
    val downloadsTotalCount get() =
        ScalarNode("downloadsTotalCount").also { doInit(it) }
}

class PageInfo(__name: String = "PageInfo"): ObjectNode(__name) {
    val endCursor get() =
        ScalarNode("endCursor").also { doInit(it) }
    val hasNextPage get() =
        ScalarNode("hasNextPage").also { doInit(it) }
    val hasPreviousPage get() =
        ScalarNode("hasPreviousPage").also { doInit(it) }
    val startCursor get() =
        ScalarNode("startCursor").also { doInit(it) }
}

class PermissionSource(__name: String = "PermissionSource"): ObjectNode(__name) {
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val permission get() =
        ScalarNode("permission").also { doInit(it) }
    fun source(init: PermissionGranter.() -> Unit) =
        PermissionGranter("source").also { doInit(it, init) }
}

class PinIssuePayload(__name: String = "PinIssuePayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun issue(init: Issue.() -> Unit) =
        Issue("issue").also { doInit(it, init) }
}

class PinnableItemConnection(__name: String = "PinnableItemConnection"): ObjectNode(__name) {
    fun edges(init: PinnableItemEdge.() -> Unit) =
        PinnableItemEdge("edges").also { doInit(it, init) }
    fun nodes(init: PinnableItem.() -> Unit) =
        PinnableItem("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class PinnableItemEdge(__name: String = "PinnableItemEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: PinnableItem.() -> Unit) =
        PinnableItem("node").also { doInit(it, init) }
}

class PinnedEvent(__name: String = "PinnedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun issue(init: Issue.() -> Unit) =
        Issue("issue").also { doInit(it, init) }
}

class PinnedIssue(__name: String = "PinnedIssue"): ObjectNode(__name) {
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun issue(init: Issue.() -> Unit) =
        Issue("issue").also { doInit(it, init) }
    fun pinnedBy(init: Actor.() -> Unit) =
        Actor("pinnedBy").also { doInit(it, init) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
}

class PinnedIssueConnection(__name: String = "PinnedIssueConnection"): ObjectNode(__name) {
    fun edges(init: PinnedIssueEdge.() -> Unit) =
        PinnedIssueEdge("edges").also { doInit(it, init) }
    fun nodes(init: PinnedIssue.() -> Unit) =
        PinnedIssue("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class PinnedIssueEdge(__name: String = "PinnedIssueEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: PinnedIssue.() -> Unit) =
        PinnedIssue("node").also { doInit(it, init) }
}

class PrivateRepositoryForkingDisableAuditEntry(__name: String = "PrivateRepositoryForkingDisableAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val enterpriseResourcePath get() =
        ScalarNode("enterpriseResourcePath").also { doInit(it) }
    val enterpriseSlug get() =
        ScalarNode("enterpriseSlug").also { doInit(it) }
    val enterpriseUrl get() =
        ScalarNode("enterpriseUrl").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val repositoryName get() =
        ScalarNode("repositoryName").also { doInit(it) }
    val repositoryResourcePath get() =
        ScalarNode("repositoryResourcePath").also { doInit(it) }
    val repositoryUrl get() =
        ScalarNode("repositoryUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class PrivateRepositoryForkingEnableAuditEntry(__name: String = "PrivateRepositoryForkingEnableAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val enterpriseResourcePath get() =
        ScalarNode("enterpriseResourcePath").also { doInit(it) }
    val enterpriseSlug get() =
        ScalarNode("enterpriseSlug").also { doInit(it) }
    val enterpriseUrl get() =
        ScalarNode("enterpriseUrl").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val repositoryName get() =
        ScalarNode("repositoryName").also { doInit(it) }
    val repositoryResourcePath get() =
        ScalarNode("repositoryResourcePath").also { doInit(it) }
    val repositoryUrl get() =
        ScalarNode("repositoryUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class ProfileItemShowcase(__name: String = "ProfileItemShowcase"): ObjectNode(__name) {
    val hasPinnedItems get() =
        ScalarNode("hasPinnedItems").also { doInit(it) }
    fun items(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: PinnableItemConnection.() -> Unit) =
        PinnableItemConnection("items").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
}

class Project(__name: String = "Project"): ObjectNode(__name) {
    val body get() =
        ScalarNode("body").also { doInit(it) }
    val bodyHTML get() =
        ScalarNode("bodyHTML").also { doInit(it) }
    val closed get() =
        ScalarNode("closed").also { doInit(it) }
    val closedAt get() =
        ScalarNode("closedAt").also { doInit(it) }
    fun columns(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: ProjectColumnConnection.() -> Unit) =
        ProjectColumnConnection("columns").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    fun creator(init: Actor.() -> Unit) =
        Actor("creator").also { doInit(it, init) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    val number get() =
        ScalarNode("number").also { doInit(it) }
    fun owner(init: ProjectOwner.() -> Unit) =
        ProjectOwner("owner").also { doInit(it, init) }
    fun pendingCards(after: String? = null, archivedStates: ProjectCardArchivedState? = null, before: String? = null, first: Int? = null, last: Int? = null, init: ProjectCardConnection.() -> Unit) =
        ProjectCardConnection("pendingCards").apply { addArgs("after", after) }.apply { addArgs("archivedStates", archivedStates) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun progress(init: ProjectProgress.() -> Unit) =
        ProjectProgress("progress").also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val state get() =
        ScalarNode("state").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    val viewerCanUpdate get() =
        ScalarNode("viewerCanUpdate").also { doInit(it) }
}

class ProjectCard(__name: String = "ProjectCard"): ObjectNode(__name) {
    fun column(init: ProjectColumn.() -> Unit) =
        ProjectColumn("column").also { doInit(it, init) }
    fun content(init: ProjectCardItem.() -> Unit) =
        ProjectCardItem("content").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    fun creator(init: Actor.() -> Unit) =
        Actor("creator").also { doInit(it, init) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val isArchived get() =
        ScalarNode("isArchived").also { doInit(it) }
    val note get() =
        ScalarNode("note").also { doInit(it) }
    fun project(init: Project.() -> Unit) =
        Project("project").also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val state get() =
        ScalarNode("state").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
}

class ProjectCardConnection(__name: String = "ProjectCardConnection"): ObjectNode(__name) {
    fun edges(init: ProjectCardEdge.() -> Unit) =
        ProjectCardEdge("edges").also { doInit(it, init) }
    fun nodes(init: ProjectCard.() -> Unit) =
        ProjectCard("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class ProjectCardEdge(__name: String = "ProjectCardEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: ProjectCard.() -> Unit) =
        ProjectCard("node").also { doInit(it, init) }
}

class ProjectColumn(__name: String = "ProjectColumn"): ObjectNode(__name) {
    fun cards(after: String? = null, archivedStates: ProjectCardArchivedState? = null, before: String? = null, first: Int? = null, last: Int? = null, init: ProjectCardConnection.() -> Unit) =
        ProjectCardConnection("cards").apply { addArgs("after", after) }.apply { addArgs("archivedStates", archivedStates) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    fun project(init: Project.() -> Unit) =
        Project("project").also { doInit(it, init) }
    val purpose get() =
        ScalarNode("purpose").also { doInit(it) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
}

class ProjectColumnConnection(__name: String = "ProjectColumnConnection"): ObjectNode(__name) {
    fun edges(init: ProjectColumnEdge.() -> Unit) =
        ProjectColumnEdge("edges").also { doInit(it, init) }
    fun nodes(init: ProjectColumn.() -> Unit) =
        ProjectColumn("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class ProjectColumnEdge(__name: String = "ProjectColumnEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: ProjectColumn.() -> Unit) =
        ProjectColumn("node").also { doInit(it, init) }
}

class ProjectConnection(__name: String = "ProjectConnection"): ObjectNode(__name) {
    fun edges(init: ProjectEdge.() -> Unit) =
        ProjectEdge("edges").also { doInit(it, init) }
    fun nodes(init: Project.() -> Unit) =
        Project("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class ProjectEdge(__name: String = "ProjectEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: Project.() -> Unit) =
        Project("node").also { doInit(it, init) }
}

class ProjectProgress(__name: String = "ProjectProgress"): ObjectNode(__name) {
    val doneCount get() =
        ScalarNode("doneCount").also { doInit(it) }
    val donePercentage get() =
        ScalarNode("donePercentage").also { doInit(it) }
    val enabled get() =
        ScalarNode("enabled").also { doInit(it) }
    val inProgressCount get() =
        ScalarNode("inProgressCount").also { doInit(it) }
    val inProgressPercentage get() =
        ScalarNode("inProgressPercentage").also { doInit(it) }
    val todoCount get() =
        ScalarNode("todoCount").also { doInit(it) }
    val todoPercentage get() =
        ScalarNode("todoPercentage").also { doInit(it) }
}

class PublicKey(__name: String = "PublicKey"): ObjectNode(__name) {
    val accessedAt get() =
        ScalarNode("accessedAt").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val fingerprint get() =
        ScalarNode("fingerprint").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val isReadOnly get() =
        ScalarNode("isReadOnly").also { doInit(it) }
    val key get() =
        ScalarNode("key").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
}

class PublicKeyConnection(__name: String = "PublicKeyConnection"): ObjectNode(__name) {
    fun edges(init: PublicKeyEdge.() -> Unit) =
        PublicKeyEdge("edges").also { doInit(it, init) }
    fun nodes(init: PublicKey.() -> Unit) =
        PublicKey("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class PublicKeyEdge(__name: String = "PublicKeyEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: PublicKey.() -> Unit) =
        PublicKey("node").also { doInit(it, init) }
}

class PullRequest(__name: String = "PullRequest"): ObjectNode(__name) {
    val activeLockReason get() =
        ScalarNode("activeLockReason").also { doInit(it) }
    val additions get() =
        ScalarNode("additions").also { doInit(it) }
    fun assignees(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: UserConnection.() -> Unit) =
        UserConnection("assignees").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun author(init: Actor.() -> Unit) =
        Actor("author").also { doInit(it, init) }
    val authorAssociation get() =
        ScalarNode("authorAssociation").also { doInit(it) }
    fun baseRef(init: Ref.() -> Unit) =
        Ref("baseRef").also { doInit(it, init) }
    val baseRefName get() =
        ScalarNode("baseRefName").also { doInit(it) }
    val baseRefOid get() =
        ScalarNode("baseRefOid").also { doInit(it) }
    fun baseRepository(init: Repository.() -> Unit) =
        Repository("baseRepository").also { doInit(it, init) }
    val body get() =
        ScalarNode("body").also { doInit(it) }
    val bodyHTML get() =
        ScalarNode("bodyHTML").also { doInit(it) }
    val bodyText get() =
        ScalarNode("bodyText").also { doInit(it) }
    val canBeRebased get() =
        ScalarNode("canBeRebased").also { doInit(it) }
    val changedFiles get() =
        ScalarNode("changedFiles").also { doInit(it) }
    val checksResourcePath get() =
        ScalarNode("checksResourcePath").also { doInit(it) }
    val checksUrl get() =
        ScalarNode("checksUrl").also { doInit(it) }
    val closed get() =
        ScalarNode("closed").also { doInit(it) }
    val closedAt get() =
        ScalarNode("closedAt").also { doInit(it) }
    fun comments(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: IssueCommentConnection.() -> Unit) =
        IssueCommentConnection("comments").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun commits(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: PullRequestCommitConnection.() -> Unit) =
        PullRequestCommitConnection("commits").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val createdViaEmail get() =
        ScalarNode("createdViaEmail").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val deletions get() =
        ScalarNode("deletions").also { doInit(it) }
    fun editor(init: Actor.() -> Unit) =
        Actor("editor").also { doInit(it, init) }
    fun files(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: PullRequestChangedFileConnection.() -> Unit) =
        PullRequestChangedFileConnection("files").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun headRef(init: Ref.() -> Unit) =
        Ref("headRef").also { doInit(it, init) }
    val headRefName get() =
        ScalarNode("headRefName").also { doInit(it) }
    val headRefOid get() =
        ScalarNode("headRefOid").also { doInit(it) }
    fun headRepository(init: Repository.() -> Unit) =
        Repository("headRepository").also { doInit(it, init) }
    fun headRepositoryOwner(init: RepositoryOwner.() -> Unit) =
        RepositoryOwner("headRepositoryOwner").also { doInit(it, init) }
    fun hovercard(includeNotificationContexts: Boolean? = null, init: Hovercard.() -> Unit) =
        Hovercard("hovercard").apply { addArgs("includeNotificationContexts", includeNotificationContexts) }.also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val includesCreatedEdit get() =
        ScalarNode("includesCreatedEdit").also { doInit(it) }
    val isCrossRepository get() =
        ScalarNode("isCrossRepository").also { doInit(it) }
    val isDraft get() =
        ScalarNode("isDraft").also { doInit(it) }
    val isReadByViewer get() =
        ScalarNode("isReadByViewer").also { doInit(it) }
    fun labels(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: LabelOrder? = null, init: LabelConnection.() -> Unit) =
        LabelConnection("labels").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    val lastEditedAt get() =
        ScalarNode("lastEditedAt").also { doInit(it) }
    fun latestOpinionatedReviews(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, writersOnly: Boolean? = null, init: PullRequestReviewConnection.() -> Unit) =
        PullRequestReviewConnection("latestOpinionatedReviews").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("writersOnly", writersOnly) }.also { doInit(it, init) }
    fun latestReviews(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: PullRequestReviewConnection.() -> Unit) =
        PullRequestReviewConnection("latestReviews").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val locked get() =
        ScalarNode("locked").also { doInit(it) }
    val maintainerCanModify get() =
        ScalarNode("maintainerCanModify").also { doInit(it) }
    fun mergeCommit(init: Commit.() -> Unit) =
        Commit("mergeCommit").also { doInit(it, init) }
    val mergeStateStatus get() =
        ScalarNode("mergeStateStatus").also { doInit(it) }
    val mergeable get() =
        ScalarNode("mergeable").also { doInit(it) }
    val merged get() =
        ScalarNode("merged").also { doInit(it) }
    val mergedAt get() =
        ScalarNode("mergedAt").also { doInit(it) }
    fun mergedBy(init: Actor.() -> Unit) =
        Actor("mergedBy").also { doInit(it, init) }
    fun milestone(init: Milestone.() -> Unit) =
        Milestone("milestone").also { doInit(it, init) }
    val number get() =
        ScalarNode("number").also { doInit(it) }
    fun participants(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: UserConnection.() -> Unit) =
        UserConnection("participants").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val permalink get() =
        ScalarNode("permalink").also { doInit(it) }
    fun potentialMergeCommit(init: Commit.() -> Unit) =
        Commit("potentialMergeCommit").also { doInit(it, init) }
    fun projectCards(after: String? = null, archivedStates: ProjectCardArchivedState? = null, before: String? = null, first: Int? = null, last: Int? = null, init: ProjectCardConnection.() -> Unit) =
        ProjectCardConnection("projectCards").apply { addArgs("after", after) }.apply { addArgs("archivedStates", archivedStates) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val publishedAt get() =
        ScalarNode("publishedAt").also { doInit(it) }
    fun reactionGroups(init: ReactionGroup.() -> Unit) =
        ReactionGroup("reactionGroups").also { doInit(it, init) }
    fun reactions(after: String? = null, before: String? = null, content: ReactionContent? = null, first: Int? = null, last: Int? = null, orderBy: ReactionOrder? = null, init: ReactionConnection.() -> Unit) =
        ReactionConnection("reactions").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("content", content) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val revertResourcePath get() =
        ScalarNode("revertResourcePath").also { doInit(it) }
    val revertUrl get() =
        ScalarNode("revertUrl").also { doInit(it) }
    val reviewDecision get() =
        ScalarNode("reviewDecision").also { doInit(it) }
    fun reviewRequests(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: ReviewRequestConnection.() -> Unit) =
        ReviewRequestConnection("reviewRequests").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun reviewThreads(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: PullRequestReviewThreadConnection.() -> Unit) =
        PullRequestReviewThreadConnection("reviewThreads").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun reviews(after: String? = null, author: String? = null, before: String? = null, first: Int? = null, last: Int? = null, states: PullRequestReviewState? = null, init: PullRequestReviewConnection.() -> Unit) =
        PullRequestReviewConnection("reviews").apply { addArgs("after", after) }.apply { addArgs("author", author) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("states", states) }.also { doInit(it, init) }
    val state get() =
        ScalarNode("state").also { doInit(it) }
    fun suggestedReviewers(init: SuggestedReviewer.() -> Unit) =
        SuggestedReviewer("suggestedReviewers").also { doInit(it, init) }
    @Deprecated("`timeline` will be removed Use PullRequest.timelineItems instead. Removal on 2020-10-01 UTC.")
    fun timeline(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, since: DateTime? = null, init: PullRequestTimelineConnection.() -> Unit) =
        PullRequestTimelineConnection("timeline").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("since", since) }.also { doInit(it, init) }
    fun timelineItems(after: String? = null, before: String? = null, first: Int? = null, itemTypes: PullRequestTimelineItemsItemType? = null, last: Int? = null, since: DateTime? = null, skip: Int? = null, init: PullRequestTimelineItemsConnection.() -> Unit) =
        PullRequestTimelineItemsConnection("timelineItems").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("itemTypes", itemTypes) }.apply { addArgs("last", last) }.apply { addArgs("since", since) }.apply { addArgs("skip", skip) }.also { doInit(it, init) }
    val title get() =
        ScalarNode("title").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    fun userContentEdits(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: UserContentEditConnection.() -> Unit) =
        UserContentEditConnection("userContentEdits").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val viewerCanApplySuggestion get() =
        ScalarNode("viewerCanApplySuggestion").also { doInit(it) }
    val viewerCanDeleteHeadRef get() =
        ScalarNode("viewerCanDeleteHeadRef").also { doInit(it) }
    val viewerCanReact get() =
        ScalarNode("viewerCanReact").also { doInit(it) }
    val viewerCanSubscribe get() =
        ScalarNode("viewerCanSubscribe").also { doInit(it) }
    val viewerCanUpdate get() =
        ScalarNode("viewerCanUpdate").also { doInit(it) }
    val viewerCannotUpdateReasons get() =
        ScalarNode("viewerCannotUpdateReasons").also { doInit(it) }
    val viewerDidAuthor get() =
        ScalarNode("viewerDidAuthor").also { doInit(it) }
    fun viewerMergeBodyText(mergeType: PullRequestMergeMethod? = null) =
        ScalarWithArgsNode("viewerMergeBodyText", mapOf("mergeType" to mergeType)).also { doInit(it) }
    val viewerMergeBodyText get() =
        ScalarNode("viewerMergeBodyText").also { doInit(it) }
    fun viewerMergeHeadlineText(mergeType: PullRequestMergeMethod? = null) =
        ScalarWithArgsNode("viewerMergeHeadlineText", mapOf("mergeType" to mergeType)).also { doInit(it) }
    val viewerMergeHeadlineText get() =
        ScalarNode("viewerMergeHeadlineText").also { doInit(it) }
    val viewerSubscription get() =
        ScalarNode("viewerSubscription").also { doInit(it) }
}

class PullRequestChangedFile(__name: String = "PullRequestChangedFile"): ObjectNode(__name) {
    val additions get() =
        ScalarNode("additions").also { doInit(it) }
    val deletions get() =
        ScalarNode("deletions").also { doInit(it) }
    val path get() =
        ScalarNode("path").also { doInit(it) }
    val viewerViewedState get() =
        ScalarNode("viewerViewedState").also { doInit(it) }
}

class PullRequestChangedFileConnection(__name: String = "PullRequestChangedFileConnection"): ObjectNode(__name) {
    fun edges(init: PullRequestChangedFileEdge.() -> Unit) =
        PullRequestChangedFileEdge("edges").also { doInit(it, init) }
    fun nodes(init: PullRequestChangedFile.() -> Unit) =
        PullRequestChangedFile("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class PullRequestChangedFileEdge(__name: String = "PullRequestChangedFileEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: PullRequestChangedFile.() -> Unit) =
        PullRequestChangedFile("node").also { doInit(it, init) }
}

class PullRequestCommit(__name: String = "PullRequestCommit"): ObjectNode(__name) {
    fun commit(init: Commit.() -> Unit) =
        Commit("commit").also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
}

class PullRequestCommitCommentThread(__name: String = "PullRequestCommitCommentThread"): ObjectNode(__name) {
    fun comments(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: CommitCommentConnection.() -> Unit) =
        CommitCommentConnection("comments").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun commit(init: Commit.() -> Unit) =
        Commit("commit").also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val path get() =
        ScalarNode("path").also { doInit(it) }
    val position get() =
        ScalarNode("position").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
}

class PullRequestCommitConnection(__name: String = "PullRequestCommitConnection"): ObjectNode(__name) {
    fun edges(init: PullRequestCommitEdge.() -> Unit) =
        PullRequestCommitEdge("edges").also { doInit(it, init) }
    fun nodes(init: PullRequestCommit.() -> Unit) =
        PullRequestCommit("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class PullRequestCommitEdge(__name: String = "PullRequestCommitEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: PullRequestCommit.() -> Unit) =
        PullRequestCommit("node").also { doInit(it, init) }
}

class PullRequestConnection(__name: String = "PullRequestConnection"): ObjectNode(__name) {
    fun edges(init: PullRequestEdge.() -> Unit) =
        PullRequestEdge("edges").also { doInit(it, init) }
    fun nodes(init: PullRequest.() -> Unit) =
        PullRequest("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class PullRequestContributionsByRepository(__name: String = "PullRequestContributionsByRepository"): ObjectNode(__name) {
    fun contributions(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: ContributionOrder? = null, init: CreatedPullRequestContributionConnection.() -> Unit) =
        CreatedPullRequestContributionConnection("contributions").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
}

class PullRequestEdge(__name: String = "PullRequestEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: PullRequest.() -> Unit) =
        PullRequest("node").also { doInit(it, init) }
}

class PullRequestReview(__name: String = "PullRequestReview"): ObjectNode(__name) {
    fun author(init: Actor.() -> Unit) =
        Actor("author").also { doInit(it, init) }
    val authorAssociation get() =
        ScalarNode("authorAssociation").also { doInit(it) }
    val authorCanPushToRepository get() =
        ScalarNode("authorCanPushToRepository").also { doInit(it) }
    val body get() =
        ScalarNode("body").also { doInit(it) }
    val bodyHTML get() =
        ScalarNode("bodyHTML").also { doInit(it) }
    val bodyText get() =
        ScalarNode("bodyText").also { doInit(it) }
    fun comments(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: PullRequestReviewCommentConnection.() -> Unit) =
        PullRequestReviewCommentConnection("comments").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun commit(init: Commit.() -> Unit) =
        Commit("commit").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val createdViaEmail get() =
        ScalarNode("createdViaEmail").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    fun editor(init: Actor.() -> Unit) =
        Actor("editor").also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val includesCreatedEdit get() =
        ScalarNode("includesCreatedEdit").also { doInit(it) }
    val lastEditedAt get() =
        ScalarNode("lastEditedAt").also { doInit(it) }
    fun onBehalfOf(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: TeamConnection.() -> Unit) =
        TeamConnection("onBehalfOf").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val publishedAt get() =
        ScalarNode("publishedAt").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
    fun reactionGroups(init: ReactionGroup.() -> Unit) =
        ReactionGroup("reactionGroups").also { doInit(it, init) }
    fun reactions(after: String? = null, before: String? = null, content: ReactionContent? = null, first: Int? = null, last: Int? = null, orderBy: ReactionOrder? = null, init: ReactionConnection.() -> Unit) =
        ReactionConnection("reactions").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("content", content) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val state get() =
        ScalarNode("state").also { doInit(it) }
    val submittedAt get() =
        ScalarNode("submittedAt").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    fun userContentEdits(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: UserContentEditConnection.() -> Unit) =
        UserContentEditConnection("userContentEdits").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val viewerCanDelete get() =
        ScalarNode("viewerCanDelete").also { doInit(it) }
    val viewerCanReact get() =
        ScalarNode("viewerCanReact").also { doInit(it) }
    val viewerCanUpdate get() =
        ScalarNode("viewerCanUpdate").also { doInit(it) }
    val viewerCannotUpdateReasons get() =
        ScalarNode("viewerCannotUpdateReasons").also { doInit(it) }
    val viewerDidAuthor get() =
        ScalarNode("viewerDidAuthor").also { doInit(it) }
}

class PullRequestReviewComment(__name: String = "PullRequestReviewComment"): ObjectNode(__name) {
    fun author(init: Actor.() -> Unit) =
        Actor("author").also { doInit(it, init) }
    val authorAssociation get() =
        ScalarNode("authorAssociation").also { doInit(it) }
    val body get() =
        ScalarNode("body").also { doInit(it) }
    val bodyHTML get() =
        ScalarNode("bodyHTML").also { doInit(it) }
    val bodyText get() =
        ScalarNode("bodyText").also { doInit(it) }
    fun commit(init: Commit.() -> Unit) =
        Commit("commit").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val createdViaEmail get() =
        ScalarNode("createdViaEmail").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val diffHunk get() =
        ScalarNode("diffHunk").also { doInit(it) }
    val draftedAt get() =
        ScalarNode("draftedAt").also { doInit(it) }
    fun editor(init: Actor.() -> Unit) =
        Actor("editor").also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val includesCreatedEdit get() =
        ScalarNode("includesCreatedEdit").also { doInit(it) }
    val isMinimized get() =
        ScalarNode("isMinimized").also { doInit(it) }
    val lastEditedAt get() =
        ScalarNode("lastEditedAt").also { doInit(it) }
    val minimizedReason get() =
        ScalarNode("minimizedReason").also { doInit(it) }
    fun originalCommit(init: Commit.() -> Unit) =
        Commit("originalCommit").also { doInit(it, init) }
    val originalPosition get() =
        ScalarNode("originalPosition").also { doInit(it) }
    val outdated get() =
        ScalarNode("outdated").also { doInit(it) }
    val path get() =
        ScalarNode("path").also { doInit(it) }
    val position get() =
        ScalarNode("position").also { doInit(it) }
    val publishedAt get() =
        ScalarNode("publishedAt").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
    fun pullRequestReview(init: PullRequestReview.() -> Unit) =
        PullRequestReview("pullRequestReview").also { doInit(it, init) }
    fun reactionGroups(init: ReactionGroup.() -> Unit) =
        ReactionGroup("reactionGroups").also { doInit(it, init) }
    fun reactions(after: String? = null, before: String? = null, content: ReactionContent? = null, first: Int? = null, last: Int? = null, orderBy: ReactionOrder? = null, init: ReactionConnection.() -> Unit) =
        ReactionConnection("reactions").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("content", content) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun replyTo(init: PullRequestReviewComment.() -> Unit) =
        PullRequestReviewComment("replyTo").also { doInit(it, init) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val state get() =
        ScalarNode("state").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    fun userContentEdits(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: UserContentEditConnection.() -> Unit) =
        UserContentEditConnection("userContentEdits").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val viewerCanDelete get() =
        ScalarNode("viewerCanDelete").also { doInit(it) }
    val viewerCanMinimize get() =
        ScalarNode("viewerCanMinimize").also { doInit(it) }
    val viewerCanReact get() =
        ScalarNode("viewerCanReact").also { doInit(it) }
    val viewerCanUpdate get() =
        ScalarNode("viewerCanUpdate").also { doInit(it) }
    val viewerCannotUpdateReasons get() =
        ScalarNode("viewerCannotUpdateReasons").also { doInit(it) }
    val viewerDidAuthor get() =
        ScalarNode("viewerDidAuthor").also { doInit(it) }
}

class PullRequestReviewCommentConnection(__name: String = "PullRequestReviewCommentConnection"): ObjectNode(__name) {
    fun edges(init: PullRequestReviewCommentEdge.() -> Unit) =
        PullRequestReviewCommentEdge("edges").also { doInit(it, init) }
    fun nodes(init: PullRequestReviewComment.() -> Unit) =
        PullRequestReviewComment("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class PullRequestReviewCommentEdge(__name: String = "PullRequestReviewCommentEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: PullRequestReviewComment.() -> Unit) =
        PullRequestReviewComment("node").also { doInit(it, init) }
}

class PullRequestReviewConnection(__name: String = "PullRequestReviewConnection"): ObjectNode(__name) {
    fun edges(init: PullRequestReviewEdge.() -> Unit) =
        PullRequestReviewEdge("edges").also { doInit(it, init) }
    fun nodes(init: PullRequestReview.() -> Unit) =
        PullRequestReview("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class PullRequestReviewContributionsByRepository(__name: String = "PullRequestReviewContributionsByRepository"): ObjectNode(__name) {
    fun contributions(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: ContributionOrder? = null, init: CreatedPullRequestReviewContributionConnection.() -> Unit) =
        CreatedPullRequestReviewContributionConnection("contributions").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
}

class PullRequestReviewEdge(__name: String = "PullRequestReviewEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: PullRequestReview.() -> Unit) =
        PullRequestReview("node").also { doInit(it, init) }
}

class PullRequestReviewThread(__name: String = "PullRequestReviewThread"): ObjectNode(__name) {
    fun comments(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, skip: Int? = null, init: PullRequestReviewCommentConnection.() -> Unit) =
        PullRequestReviewCommentConnection("comments").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("skip", skip) }.also { doInit(it, init) }
    val diffSide get() =
        ScalarNode("diffSide").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val isCollapsed get() =
        ScalarNode("isCollapsed").also { doInit(it) }
    val isOutdated get() =
        ScalarNode("isOutdated").also { doInit(it) }
    val isResolved get() =
        ScalarNode("isResolved").also { doInit(it) }
    val line get() =
        ScalarNode("line").also { doInit(it) }
    val originalLine get() =
        ScalarNode("originalLine").also { doInit(it) }
    val originalStartLine get() =
        ScalarNode("originalStartLine").also { doInit(it) }
    val path get() =
        ScalarNode("path").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    fun resolvedBy(init: User.() -> Unit) =
        User("resolvedBy").also { doInit(it, init) }
    val startDiffSide get() =
        ScalarNode("startDiffSide").also { doInit(it) }
    val startLine get() =
        ScalarNode("startLine").also { doInit(it) }
    val viewerCanReply get() =
        ScalarNode("viewerCanReply").also { doInit(it) }
    val viewerCanResolve get() =
        ScalarNode("viewerCanResolve").also { doInit(it) }
    val viewerCanUnresolve get() =
        ScalarNode("viewerCanUnresolve").also { doInit(it) }
}

class PullRequestReviewThreadConnection(__name: String = "PullRequestReviewThreadConnection"): ObjectNode(__name) {
    fun edges(init: PullRequestReviewThreadEdge.() -> Unit) =
        PullRequestReviewThreadEdge("edges").also { doInit(it, init) }
    fun nodes(init: PullRequestReviewThread.() -> Unit) =
        PullRequestReviewThread("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class PullRequestReviewThreadEdge(__name: String = "PullRequestReviewThreadEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: PullRequestReviewThread.() -> Unit) =
        PullRequestReviewThread("node").also { doInit(it, init) }
}

class PullRequestRevisionMarker(__name: String = "PullRequestRevisionMarker"): ObjectNode(__name) {
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    fun lastSeenCommit(init: Commit.() -> Unit) =
        Commit("lastSeenCommit").also { doInit(it, init) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
}

class PullRequestTimelineConnection(__name: String = "PullRequestTimelineConnection"): ObjectNode(__name) {
    fun edges(init: PullRequestTimelineItemEdge.() -> Unit) =
        PullRequestTimelineItemEdge("edges").also { doInit(it, init) }
    fun nodes(init: PullRequestTimelineItem.() -> Unit) =
        PullRequestTimelineItem("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class PullRequestTimelineItemEdge(__name: String = "PullRequestTimelineItemEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: PullRequestTimelineItem.() -> Unit) =
        PullRequestTimelineItem("node").also { doInit(it, init) }
}

class PullRequestTimelineItemsConnection(__name: String = "PullRequestTimelineItemsConnection"): ObjectNode(__name) {
    fun edges(init: PullRequestTimelineItemsEdge.() -> Unit) =
        PullRequestTimelineItemsEdge("edges").also { doInit(it, init) }
    val filteredCount get() =
        ScalarNode("filteredCount").also { doInit(it) }
    fun nodes(init: PullRequestTimelineItems.() -> Unit) =
        PullRequestTimelineItems("nodes").also { doInit(it, init) }
    val pageCount get() =
        ScalarNode("pageCount").also { doInit(it) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
}

class PullRequestTimelineItemsEdge(__name: String = "PullRequestTimelineItemsEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: PullRequestTimelineItems.() -> Unit) =
        PullRequestTimelineItems("node").also { doInit(it, init) }
}

class Push(__name: String = "Push"): ObjectNode(__name) {
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val nextSha get() =
        ScalarNode("nextSha").also { doInit(it) }
    val permalink get() =
        ScalarNode("permalink").also { doInit(it) }
    val previousSha get() =
        ScalarNode("previousSha").also { doInit(it) }
    fun pusher(init: User.() -> Unit) =
        User("pusher").also { doInit(it, init) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
}

class PushAllowance(__name: String = "PushAllowance"): ObjectNode(__name) {
    fun actor(init: PushAllowanceActor.() -> Unit) =
        PushAllowanceActor("actor").also { doInit(it, init) }
    fun branchProtectionRule(init: BranchProtectionRule.() -> Unit) =
        BranchProtectionRule("branchProtectionRule").also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
}

class PushAllowanceConnection(__name: String = "PushAllowanceConnection"): ObjectNode(__name) {
    fun edges(init: PushAllowanceEdge.() -> Unit) =
        PushAllowanceEdge("edges").also { doInit(it, init) }
    fun nodes(init: PushAllowance.() -> Unit) =
        PushAllowance("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class PushAllowanceEdge(__name: String = "PushAllowanceEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: PushAllowance.() -> Unit) =
        PushAllowance("node").also { doInit(it, init) }
}

class Query(__name: String = "query"): ObjectNode(__name) {
    fun codeOfConduct(key: String, init: CodeOfConduct.() -> Unit) =
        CodeOfConduct("codeOfConduct").apply { addArgs("key", key) }.also { doInit(it, init) }
    fun codesOfConduct(init: CodeOfConduct.() -> Unit) =
        CodeOfConduct("codesOfConduct").also { doInit(it, init) }
    fun enterprise(invitationToken: String? = null, slug: String, init: Enterprise.() -> Unit) =
        Enterprise("enterprise").apply { addArgs("invitationToken", invitationToken) }.apply { addArgs("slug", slug) }.also { doInit(it, init) }
    fun enterpriseAdministratorInvitation(enterpriseSlug: String, role: EnterpriseAdministratorRole, userLogin: String, init: EnterpriseAdministratorInvitation.() -> Unit) =
        EnterpriseAdministratorInvitation("enterpriseAdministratorInvitation").apply { addArgs("enterpriseSlug", enterpriseSlug) }.apply { addArgs("role", role) }.apply { addArgs("userLogin", userLogin) }.also { doInit(it, init) }
    fun enterpriseAdministratorInvitationByToken(invitationToken: String, init: EnterpriseAdministratorInvitation.() -> Unit) =
        EnterpriseAdministratorInvitation("enterpriseAdministratorInvitationByToken").apply { addArgs("invitationToken", invitationToken) }.also { doInit(it, init) }
    fun license(key: String, init: License.() -> Unit) =
        License("license").apply { addArgs("key", key) }.also { doInit(it, init) }
    fun licenses(init: License.() -> Unit) =
        License("licenses").also { doInit(it, init) }
    fun marketplaceCategories(excludeEmpty: Boolean? = null, excludeSubcategories: Boolean? = null, includeCategories: String? = null, init: MarketplaceCategory.() -> Unit) =
        MarketplaceCategory("marketplaceCategories").apply { addArgs("excludeEmpty", excludeEmpty) }.apply { addArgs("excludeSubcategories", excludeSubcategories) }.apply { addArgs("includeCategories", includeCategories) }.also { doInit(it, init) }
    fun marketplaceCategory(slug: String, useTopicAliases: Boolean? = null, init: MarketplaceCategory.() -> Unit) =
        MarketplaceCategory("marketplaceCategory").apply { addArgs("slug", slug) }.apply { addArgs("useTopicAliases", useTopicAliases) }.also { doInit(it, init) }
    fun marketplaceListing(slug: String, init: MarketplaceListing.() -> Unit) =
        MarketplaceListing("marketplaceListing").apply { addArgs("slug", slug) }.also { doInit(it, init) }
    fun marketplaceListings(adminId: ID? = null, after: String? = null, allStates: Boolean? = null, before: String? = null, categorySlug: String? = null, first: Int? = null, last: Int? = null, organizationId: ID? = null, primaryCategoryOnly: Boolean? = null, slugs: String? = null, useTopicAliases: Boolean? = null, viewerCanAdmin: Boolean? = null, withFreeTrialsOnly: Boolean? = null, init: MarketplaceListingConnection.() -> Unit) =
        MarketplaceListingConnection("marketplaceListings").apply { addArgs("adminId", adminId) }.apply { addArgs("after", after) }.apply { addArgs("allStates", allStates) }.apply { addArgs("before", before) }.apply { addArgs("categorySlug", categorySlug) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("organizationId", organizationId) }.apply { addArgs("primaryCategoryOnly", primaryCategoryOnly) }.apply { addArgs("slugs", slugs) }.apply { addArgs("useTopicAliases", useTopicAliases) }.apply { addArgs("viewerCanAdmin", viewerCanAdmin) }.apply { addArgs("withFreeTrialsOnly", withFreeTrialsOnly) }.also { doInit(it, init) }
    fun meta(init: GitHubMetadata.() -> Unit) =
        GitHubMetadata("meta").also { doInit(it, init) }
    fun node(id: ID, init: Node.() -> Unit) =
        Node("node").apply { addArgs("id", id) }.also { doInit(it, init) }
    fun nodes(ids: ID, init: Node.() -> Unit) =
        Node("nodes").apply { addArgs("ids", ids) }.also { doInit(it, init) }
    fun organization(login: String, init: Organization.() -> Unit) =
        Organization("organization").apply { addArgs("login", login) }.also { doInit(it, init) }
    fun rateLimit(dryRun: Boolean? = null, init: RateLimit.() -> Unit) =
        RateLimit("rateLimit").apply { addArgs("dryRun", dryRun) }.also { doInit(it, init) }
    fun relay(init: Query.() -> Unit) =
        Query("relay").also { doInit(it, init) }
    fun repository(name: String, owner: String, init: Repository.() -> Unit) =
        Repository("repository").apply { addArgs("name", name) }.apply { addArgs("owner", owner) }.also { doInit(it, init) }
    fun repositoryOwner(login: String, init: RepositoryOwner.() -> Unit) =
        RepositoryOwner("repositoryOwner").apply { addArgs("login", login) }.also { doInit(it, init) }
    fun resource(url: URI, init: UniformResourceLocatable.() -> Unit) =
        UniformResourceLocatable("resource").apply { addArgs("url", url) }.also { doInit(it, init) }
    fun search(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, query: String, type: SearchType, init: SearchResultItemConnection.() -> Unit) =
        SearchResultItemConnection("search").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("query", query) }.apply { addArgs("type", type) }.also { doInit(it, init) }
    fun securityAdvisories(after: String? = null, before: String? = null, first: Int? = null, identifier: SecurityAdvisoryIdentifierFilter? = null, last: Int? = null, orderBy: SecurityAdvisoryOrder? = null, publishedSince: DateTime? = null, updatedSince: DateTime? = null, init: SecurityAdvisoryConnection.() -> Unit) =
        SecurityAdvisoryConnection("securityAdvisories").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("identifier", identifier) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("publishedSince", publishedSince) }.apply { addArgs("updatedSince", updatedSince) }.also { doInit(it, init) }
    fun securityAdvisory(ghsaId: String, init: SecurityAdvisory.() -> Unit) =
        SecurityAdvisory("securityAdvisory").apply { addArgs("ghsaId", ghsaId) }.also { doInit(it, init) }
    fun securityVulnerabilities(after: String? = null, before: String? = null, ecosystem: SecurityAdvisoryEcosystem? = null, first: Int? = null, last: Int? = null, orderBy: SecurityVulnerabilityOrder? = null, `package`: String? = null, severities: SecurityAdvisorySeverity? = null, init: SecurityVulnerabilityConnection.() -> Unit) =
        SecurityVulnerabilityConnection("securityVulnerabilities").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("ecosystem", ecosystem) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("package", `package`) }.apply { addArgs("severities", severities) }.also { doInit(it, init) }
    @Deprecated("`Query.sponsorsListing` will be removed. Use `Sponsorable.sponsorsListing` instead. Removal on 2020-04-01 UTC.")
    fun sponsorsListing(slug: String, init: SponsorsListing.() -> Unit) =
        SponsorsListing("sponsorsListing").apply { addArgs("slug", slug) }.also { doInit(it, init) }
    fun topic(name: String, init: Topic.() -> Unit) =
        Topic("topic").apply { addArgs("name", name) }.also { doInit(it, init) }
    fun user(login: String, init: User.() -> Unit) =
        User("user").apply { addArgs("login", login) }.also { doInit(it, init) }
    fun viewer(init: User.() -> Unit) =
        User("viewer").also { doInit(it, init) }
}

class RateLimit(__name: String = "RateLimit"): ObjectNode(__name) {
    val cost get() =
        ScalarNode("cost").also { doInit(it) }
    val limit get() =
        ScalarNode("limit").also { doInit(it) }
    val nodeCount get() =
        ScalarNode("nodeCount").also { doInit(it) }
    val remaining get() =
        ScalarNode("remaining").also { doInit(it) }
    val resetAt get() =
        ScalarNode("resetAt").also { doInit(it) }
    val used get() =
        ScalarNode("used").also { doInit(it) }
}

class ReactingUserConnection(__name: String = "ReactingUserConnection"): ObjectNode(__name) {
    fun edges(init: ReactingUserEdge.() -> Unit) =
        ReactingUserEdge("edges").also { doInit(it, init) }
    fun nodes(init: User.() -> Unit) =
        User("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class ReactingUserEdge(__name: String = "ReactingUserEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: User.() -> Unit) =
        User("node").also { doInit(it, init) }
    val reactedAt get() =
        ScalarNode("reactedAt").also { doInit(it) }
}

class Reaction(__name: String = "Reaction"): ObjectNode(__name) {
    val content get() =
        ScalarNode("content").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun reactable(init: Reactable.() -> Unit) =
        Reactable("reactable").also { doInit(it, init) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
}

class ReactionConnection(__name: String = "ReactionConnection"): ObjectNode(__name) {
    fun edges(init: ReactionEdge.() -> Unit) =
        ReactionEdge("edges").also { doInit(it, init) }
    fun nodes(init: Reaction.() -> Unit) =
        Reaction("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
    val viewerHasReacted get() =
        ScalarNode("viewerHasReacted").also { doInit(it) }
}

class ReactionEdge(__name: String = "ReactionEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: Reaction.() -> Unit) =
        Reaction("node").also { doInit(it, init) }
}

class ReactionGroup(__name: String = "ReactionGroup"): ObjectNode(__name) {
    val content get() =
        ScalarNode("content").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    fun subject(init: Reactable.() -> Unit) =
        Reactable("subject").also { doInit(it, init) }
    fun users(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: ReactingUserConnection.() -> Unit) =
        ReactingUserConnection("users").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val viewerHasReacted get() =
        ScalarNode("viewerHasReacted").also { doInit(it) }
}

class ReadyForReviewEvent(__name: String = "ReadyForReviewEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
}

class Ref(__name: String = "Ref"): ObjectNode(__name) {
    fun associatedPullRequests(after: String? = null, baseRefName: String? = null, before: String? = null, first: Int? = null, headRefName: String? = null, labels: String? = null, last: Int? = null, orderBy: IssueOrder? = null, states: PullRequestState? = null, init: PullRequestConnection.() -> Unit) =
        PullRequestConnection("associatedPullRequests").apply { addArgs("after", after) }.apply { addArgs("baseRefName", baseRefName) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("headRefName", headRefName) }.apply { addArgs("labels", labels) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("states", states) }.also { doInit(it, init) }
    fun branchProtectionRule(init: BranchProtectionRule.() -> Unit) =
        BranchProtectionRule("branchProtectionRule").also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    val prefix get() =
        ScalarNode("prefix").also { doInit(it) }
    fun refUpdateRule(init: RefUpdateRule.() -> Unit) =
        RefUpdateRule("refUpdateRule").also { doInit(it, init) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    fun target(init: GitObject.() -> Unit) =
        GitObject("target").also { doInit(it, init) }
}

class RefConnection(__name: String = "RefConnection"): ObjectNode(__name) {
    fun edges(init: RefEdge.() -> Unit) =
        RefEdge("edges").also { doInit(it, init) }
    fun nodes(init: Ref.() -> Unit) =
        Ref("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class RefEdge(__name: String = "RefEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: Ref.() -> Unit) =
        Ref("node").also { doInit(it, init) }
}

class RefUpdateRule(__name: String = "RefUpdateRule"): ObjectNode(__name) {
    val allowsDeletions get() =
        ScalarNode("allowsDeletions").also { doInit(it) }
    val allowsForcePushes get() =
        ScalarNode("allowsForcePushes").also { doInit(it) }
    val pattern get() =
        ScalarNode("pattern").also { doInit(it) }
    val requiredApprovingReviewCount get() =
        ScalarNode("requiredApprovingReviewCount").also { doInit(it) }
    val requiredStatusCheckContexts get() =
        ScalarNode("requiredStatusCheckContexts").also { doInit(it) }
    val requiresLinearHistory get() =
        ScalarNode("requiresLinearHistory").also { doInit(it) }
    val requiresSignatures get() =
        ScalarNode("requiresSignatures").also { doInit(it) }
    val viewerCanPush get() =
        ScalarNode("viewerCanPush").also { doInit(it) }
}

class ReferencedEvent(__name: String = "ReferencedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    fun commit(init: Commit.() -> Unit) =
        Commit("commit").also { doInit(it, init) }
    fun commitRepository(init: Repository.() -> Unit) =
        Repository("commitRepository").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val isCrossRepository get() =
        ScalarNode("isCrossRepository").also { doInit(it) }
    val isDirectReference get() =
        ScalarNode("isDirectReference").also { doInit(it) }
    fun subject(init: ReferencedSubject.() -> Unit) =
        ReferencedSubject("subject").also { doInit(it, init) }
}

class RegenerateEnterpriseIdentityProviderRecoveryCodesPayload(__name: String = "RegenerateEnterpriseIdentityProviderRecoveryCodesPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun identityProvider(init: EnterpriseIdentityProvider.() -> Unit) =
        EnterpriseIdentityProvider("identityProvider").also { doInit(it, init) }
}

class Release(__name: String = "Release"): ObjectNode(__name) {
    fun author(init: User.() -> Unit) =
        User("author").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val description get() =
        ScalarNode("description").also { doInit(it) }
    val descriptionHTML get() =
        ScalarNode("descriptionHTML").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val isDraft get() =
        ScalarNode("isDraft").also { doInit(it) }
    val isPrerelease get() =
        ScalarNode("isPrerelease").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    val publishedAt get() =
        ScalarNode("publishedAt").also { doInit(it) }
    fun releaseAssets(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, name: String? = null, init: ReleaseAssetConnection.() -> Unit) =
        ReleaseAssetConnection("releaseAssets").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("name", name) }.also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    fun shortDescriptionHTML(limit: Int? = null) =
        ScalarWithArgsNode("shortDescriptionHTML", mapOf("limit" to limit)).also { doInit(it) }
    val shortDescriptionHTML get() =
        ScalarNode("shortDescriptionHTML").also { doInit(it) }
    fun tag(init: Ref.() -> Unit) =
        Ref("tag").also { doInit(it, init) }
    val tagName get() =
        ScalarNode("tagName").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
}

class ReleaseAsset(__name: String = "ReleaseAsset"): ObjectNode(__name) {
    val contentType get() =
        ScalarNode("contentType").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val downloadCount get() =
        ScalarNode("downloadCount").also { doInit(it) }
    val downloadUrl get() =
        ScalarNode("downloadUrl").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    fun release(init: Release.() -> Unit) =
        Release("release").also { doInit(it, init) }
    val size get() =
        ScalarNode("size").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    fun uploadedBy(init: User.() -> Unit) =
        User("uploadedBy").also { doInit(it, init) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
}

class ReleaseAssetConnection(__name: String = "ReleaseAssetConnection"): ObjectNode(__name) {
    fun edges(init: ReleaseAssetEdge.() -> Unit) =
        ReleaseAssetEdge("edges").also { doInit(it, init) }
    fun nodes(init: ReleaseAsset.() -> Unit) =
        ReleaseAsset("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class ReleaseAssetEdge(__name: String = "ReleaseAssetEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: ReleaseAsset.() -> Unit) =
        ReleaseAsset("node").also { doInit(it, init) }
}

class ReleaseConnection(__name: String = "ReleaseConnection"): ObjectNode(__name) {
    fun edges(init: ReleaseEdge.() -> Unit) =
        ReleaseEdge("edges").also { doInit(it, init) }
    fun nodes(init: Release.() -> Unit) =
        Release("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class ReleaseEdge(__name: String = "ReleaseEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: Release.() -> Unit) =
        Release("node").also { doInit(it, init) }
}

class RemoveAssigneesFromAssignablePayload(__name: String = "RemoveAssigneesFromAssignablePayload"): ObjectNode(__name) {
    fun assignable(init: Assignable.() -> Unit) =
        Assignable("assignable").also { doInit(it, init) }
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
}

class RemoveEnterpriseAdminPayload(__name: String = "RemoveEnterpriseAdminPayload"): ObjectNode(__name) {
    fun admin(init: User.() -> Unit) =
        User("admin").also { doInit(it, init) }
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun enterprise(init: Enterprise.() -> Unit) =
        Enterprise("enterprise").also { doInit(it, init) }
    val message get() =
        ScalarNode("message").also { doInit(it) }
    fun viewer(init: User.() -> Unit) =
        User("viewer").also { doInit(it, init) }
}

class RemoveEnterpriseIdentityProviderPayload(__name: String = "RemoveEnterpriseIdentityProviderPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun identityProvider(init: EnterpriseIdentityProvider.() -> Unit) =
        EnterpriseIdentityProvider("identityProvider").also { doInit(it, init) }
}

class RemoveEnterpriseOrganizationPayload(__name: String = "RemoveEnterpriseOrganizationPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun enterprise(init: Enterprise.() -> Unit) =
        Enterprise("enterprise").also { doInit(it, init) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    fun viewer(init: User.() -> Unit) =
        User("viewer").also { doInit(it, init) }
}

class RemoveLabelsFromLabelablePayload(__name: String = "RemoveLabelsFromLabelablePayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun labelable(init: Labelable.() -> Unit) =
        Labelable("labelable").also { doInit(it, init) }
}

class RemoveOutsideCollaboratorPayload(__name: String = "RemoveOutsideCollaboratorPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun removedUser(init: User.() -> Unit) =
        User("removedUser").also { doInit(it, init) }
}

class RemoveReactionPayload(__name: String = "RemoveReactionPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun reaction(init: Reaction.() -> Unit) =
        Reaction("reaction").also { doInit(it, init) }
    fun subject(init: Reactable.() -> Unit) =
        Reactable("subject").also { doInit(it, init) }
}

class RemoveStarPayload(__name: String = "RemoveStarPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun starrable(init: Starrable.() -> Unit) =
        Starrable("starrable").also { doInit(it, init) }
}

class RemovedFromProjectEvent(__name: String = "RemovedFromProjectEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun project(init: Project.() -> Unit) =
        Project("project").also { doInit(it, init) }
    val projectColumnName get() =
        ScalarNode("projectColumnName").also { doInit(it) }
}

class RenamedTitleEvent(__name: String = "RenamedTitleEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val currentTitle get() =
        ScalarNode("currentTitle").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val previousTitle get() =
        ScalarNode("previousTitle").also { doInit(it) }
    fun subject(init: RenamedTitleSubject.() -> Unit) =
        RenamedTitleSubject("subject").also { doInit(it, init) }
}

class ReopenIssuePayload(__name: String = "ReopenIssuePayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun issue(init: Issue.() -> Unit) =
        Issue("issue").also { doInit(it, init) }
}

class ReopenPullRequestPayload(__name: String = "ReopenPullRequestPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
}

class ReopenedEvent(__name: String = "ReopenedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    fun closable(init: Closable.() -> Unit) =
        Closable("closable").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
}

class RepoAccessAuditEntry(__name: String = "RepoAccessAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val repositoryName get() =
        ScalarNode("repositoryName").also { doInit(it) }
    val repositoryResourcePath get() =
        ScalarNode("repositoryResourcePath").also { doInit(it) }
    val repositoryUrl get() =
        ScalarNode("repositoryUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
    val visibility get() =
        ScalarNode("visibility").also { doInit(it) }
}

class RepoAddMemberAuditEntry(__name: String = "RepoAddMemberAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val repositoryName get() =
        ScalarNode("repositoryName").also { doInit(it) }
    val repositoryResourcePath get() =
        ScalarNode("repositoryResourcePath").also { doInit(it) }
    val repositoryUrl get() =
        ScalarNode("repositoryUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
    val visibility get() =
        ScalarNode("visibility").also { doInit(it) }
}

class RepoAddTopicAuditEntry(__name: String = "RepoAddTopicAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val repositoryName get() =
        ScalarNode("repositoryName").also { doInit(it) }
    val repositoryResourcePath get() =
        ScalarNode("repositoryResourcePath").also { doInit(it) }
    val repositoryUrl get() =
        ScalarNode("repositoryUrl").also { doInit(it) }
    fun topic(init: Topic.() -> Unit) =
        Topic("topic").also { doInit(it, init) }
    val topicName get() =
        ScalarNode("topicName").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class RepoArchivedAuditEntry(__name: String = "RepoArchivedAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val repositoryName get() =
        ScalarNode("repositoryName").also { doInit(it) }
    val repositoryResourcePath get() =
        ScalarNode("repositoryResourcePath").also { doInit(it) }
    val repositoryUrl get() =
        ScalarNode("repositoryUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
    val visibility get() =
        ScalarNode("visibility").also { doInit(it) }
}

class RepoChangeMergeSettingAuditEntry(__name: String = "RepoChangeMergeSettingAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val isEnabled get() =
        ScalarNode("isEnabled").also { doInit(it) }
    val mergeType get() =
        ScalarNode("mergeType").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val repositoryName get() =
        ScalarNode("repositoryName").also { doInit(it) }
    val repositoryResourcePath get() =
        ScalarNode("repositoryResourcePath").also { doInit(it) }
    val repositoryUrl get() =
        ScalarNode("repositoryUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class RepoConfigDisableAnonymousGitAccessAuditEntry(__name: String = "RepoConfigDisableAnonymousGitAccessAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val repositoryName get() =
        ScalarNode("repositoryName").also { doInit(it) }
    val repositoryResourcePath get() =
        ScalarNode("repositoryResourcePath").also { doInit(it) }
    val repositoryUrl get() =
        ScalarNode("repositoryUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class RepoConfigDisableCollaboratorsOnlyAuditEntry(__name: String = "RepoConfigDisableCollaboratorsOnlyAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val repositoryName get() =
        ScalarNode("repositoryName").also { doInit(it) }
    val repositoryResourcePath get() =
        ScalarNode("repositoryResourcePath").also { doInit(it) }
    val repositoryUrl get() =
        ScalarNode("repositoryUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class RepoConfigDisableContributorsOnlyAuditEntry(__name: String = "RepoConfigDisableContributorsOnlyAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val repositoryName get() =
        ScalarNode("repositoryName").also { doInit(it) }
    val repositoryResourcePath get() =
        ScalarNode("repositoryResourcePath").also { doInit(it) }
    val repositoryUrl get() =
        ScalarNode("repositoryUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class RepoConfigDisableSockpuppetDisallowedAuditEntry(__name: String = "RepoConfigDisableSockpuppetDisallowedAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val repositoryName get() =
        ScalarNode("repositoryName").also { doInit(it) }
    val repositoryResourcePath get() =
        ScalarNode("repositoryResourcePath").also { doInit(it) }
    val repositoryUrl get() =
        ScalarNode("repositoryUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class RepoConfigEnableAnonymousGitAccessAuditEntry(__name: String = "RepoConfigEnableAnonymousGitAccessAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val repositoryName get() =
        ScalarNode("repositoryName").also { doInit(it) }
    val repositoryResourcePath get() =
        ScalarNode("repositoryResourcePath").also { doInit(it) }
    val repositoryUrl get() =
        ScalarNode("repositoryUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class RepoConfigEnableCollaboratorsOnlyAuditEntry(__name: String = "RepoConfigEnableCollaboratorsOnlyAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val repositoryName get() =
        ScalarNode("repositoryName").also { doInit(it) }
    val repositoryResourcePath get() =
        ScalarNode("repositoryResourcePath").also { doInit(it) }
    val repositoryUrl get() =
        ScalarNode("repositoryUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class RepoConfigEnableContributorsOnlyAuditEntry(__name: String = "RepoConfigEnableContributorsOnlyAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val repositoryName get() =
        ScalarNode("repositoryName").also { doInit(it) }
    val repositoryResourcePath get() =
        ScalarNode("repositoryResourcePath").also { doInit(it) }
    val repositoryUrl get() =
        ScalarNode("repositoryUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class RepoConfigEnableSockpuppetDisallowedAuditEntry(__name: String = "RepoConfigEnableSockpuppetDisallowedAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val repositoryName get() =
        ScalarNode("repositoryName").also { doInit(it) }
    val repositoryResourcePath get() =
        ScalarNode("repositoryResourcePath").also { doInit(it) }
    val repositoryUrl get() =
        ScalarNode("repositoryUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class RepoConfigLockAnonymousGitAccessAuditEntry(__name: String = "RepoConfigLockAnonymousGitAccessAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val repositoryName get() =
        ScalarNode("repositoryName").also { doInit(it) }
    val repositoryResourcePath get() =
        ScalarNode("repositoryResourcePath").also { doInit(it) }
    val repositoryUrl get() =
        ScalarNode("repositoryUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class RepoConfigUnlockAnonymousGitAccessAuditEntry(__name: String = "RepoConfigUnlockAnonymousGitAccessAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val repositoryName get() =
        ScalarNode("repositoryName").also { doInit(it) }
    val repositoryResourcePath get() =
        ScalarNode("repositoryResourcePath").also { doInit(it) }
    val repositoryUrl get() =
        ScalarNode("repositoryUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class RepoCreateAuditEntry(__name: String = "RepoCreateAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val forkParentName get() =
        ScalarNode("forkParentName").also { doInit(it) }
    val forkSourceName get() =
        ScalarNode("forkSourceName").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val repositoryName get() =
        ScalarNode("repositoryName").also { doInit(it) }
    val repositoryResourcePath get() =
        ScalarNode("repositoryResourcePath").also { doInit(it) }
    val repositoryUrl get() =
        ScalarNode("repositoryUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
    val visibility get() =
        ScalarNode("visibility").also { doInit(it) }
}

class RepoDestroyAuditEntry(__name: String = "RepoDestroyAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val repositoryName get() =
        ScalarNode("repositoryName").also { doInit(it) }
    val repositoryResourcePath get() =
        ScalarNode("repositoryResourcePath").also { doInit(it) }
    val repositoryUrl get() =
        ScalarNode("repositoryUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
    val visibility get() =
        ScalarNode("visibility").also { doInit(it) }
}

class RepoRemoveMemberAuditEntry(__name: String = "RepoRemoveMemberAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val repositoryName get() =
        ScalarNode("repositoryName").also { doInit(it) }
    val repositoryResourcePath get() =
        ScalarNode("repositoryResourcePath").also { doInit(it) }
    val repositoryUrl get() =
        ScalarNode("repositoryUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
    val visibility get() =
        ScalarNode("visibility").also { doInit(it) }
}

class RepoRemoveTopicAuditEntry(__name: String = "RepoRemoveTopicAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val repositoryName get() =
        ScalarNode("repositoryName").also { doInit(it) }
    val repositoryResourcePath get() =
        ScalarNode("repositoryResourcePath").also { doInit(it) }
    val repositoryUrl get() =
        ScalarNode("repositoryUrl").also { doInit(it) }
    fun topic(init: Topic.() -> Unit) =
        Topic("topic").also { doInit(it, init) }
    val topicName get() =
        ScalarNode("topicName").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class Repository(__name: String = "Repository"): ObjectNode(__name) {
    fun assignableUsers(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, query: String? = null, init: UserConnection.() -> Unit) =
        UserConnection("assignableUsers").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("query", query) }.also { doInit(it, init) }
    fun branchProtectionRules(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: BranchProtectionRuleConnection.() -> Unit) =
        BranchProtectionRuleConnection("branchProtectionRules").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun codeOfConduct(init: CodeOfConduct.() -> Unit) =
        CodeOfConduct("codeOfConduct").also { doInit(it, init) }
    fun collaborators(affiliation: CollaboratorAffiliation? = null, after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, query: String? = null, init: RepositoryCollaboratorConnection.() -> Unit) =
        RepositoryCollaboratorConnection("collaborators").apply { addArgs("affiliation", affiliation) }.apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("query", query) }.also { doInit(it, init) }
    fun commitComments(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: CommitCommentConnection.() -> Unit) =
        CommitCommentConnection("commitComments").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun contactLinks(init: RepositoryContactLink.() -> Unit) =
        RepositoryContactLink("contactLinks").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    fun defaultBranchRef(init: Ref.() -> Unit) =
        Ref("defaultBranchRef").also { doInit(it, init) }
    val deleteBranchOnMerge get() =
        ScalarNode("deleteBranchOnMerge").also { doInit(it) }
    fun dependencyGraphManifests(after: String? = null, before: String? = null, dependenciesAfter: String? = null, dependenciesFirst: Int? = null, first: Int? = null, last: Int? = null, withDependencies: Boolean? = null, init: DependencyGraphManifestConnection.() -> Unit) =
        DependencyGraphManifestConnection("dependencyGraphManifests").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("dependenciesAfter", dependenciesAfter) }.apply { addArgs("dependenciesFirst", dependenciesFirst) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("withDependencies", withDependencies) }.also { doInit(it, init) }
    fun deployKeys(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: DeployKeyConnection.() -> Unit) =
        DeployKeyConnection("deployKeys").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun deployments(after: String? = null, before: String? = null, environments: String? = null, first: Int? = null, last: Int? = null, orderBy: DeploymentOrder? = null, init: DeploymentConnection.() -> Unit) =
        DeploymentConnection("deployments").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("environments", environments) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    val description get() =
        ScalarNode("description").also { doInit(it) }
    val descriptionHTML get() =
        ScalarNode("descriptionHTML").also { doInit(it) }
    val diskUsage get() =
        ScalarNode("diskUsage").also { doInit(it) }
    val forkCount get() =
        ScalarNode("forkCount").also { doInit(it) }
    fun forks(affiliations: RepositoryAffiliation? = null, after: String? = null, before: String? = null, first: Int? = null, isLocked: Boolean? = null, last: Int? = null, orderBy: RepositoryOrder? = null, ownerAffiliations: RepositoryAffiliation? = null, privacy: RepositoryPrivacy? = null, init: RepositoryConnection.() -> Unit) =
        RepositoryConnection("forks").apply { addArgs("affiliations", affiliations) }.apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("isLocked", isLocked) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("ownerAffiliations", ownerAffiliations) }.apply { addArgs("privacy", privacy) }.also { doInit(it, init) }
    fun fundingLinks(init: FundingLink.() -> Unit) =
        FundingLink("fundingLinks").also { doInit(it, init) }
    val hasIssuesEnabled get() =
        ScalarNode("hasIssuesEnabled").also { doInit(it) }
    val hasProjectsEnabled get() =
        ScalarNode("hasProjectsEnabled").also { doInit(it) }
    val hasWikiEnabled get() =
        ScalarNode("hasWikiEnabled").also { doInit(it) }
    val homepageUrl get() =
        ScalarNode("homepageUrl").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val isArchived get() =
        ScalarNode("isArchived").also { doInit(it) }
    val isBlankIssuesEnabled get() =
        ScalarNode("isBlankIssuesEnabled").also { doInit(it) }
    val isDisabled get() =
        ScalarNode("isDisabled").also { doInit(it) }
    val isEmpty get() =
        ScalarNode("isEmpty").also { doInit(it) }
    val isFork get() =
        ScalarNode("isFork").also { doInit(it) }
    val isInOrganization get() =
        ScalarNode("isInOrganization").also { doInit(it) }
    val isLocked get() =
        ScalarNode("isLocked").also { doInit(it) }
    val isMirror get() =
        ScalarNode("isMirror").also { doInit(it) }
    val isPrivate get() =
        ScalarNode("isPrivate").also { doInit(it) }
    val isSecurityPolicyEnabled get() =
        ScalarNode("isSecurityPolicyEnabled").also { doInit(it) }
    val isTemplate get() =
        ScalarNode("isTemplate").also { doInit(it) }
    val isUserConfigurationRepository get() =
        ScalarNode("isUserConfigurationRepository").also { doInit(it) }
    fun issue(number: Int, init: Issue.() -> Unit) =
        Issue("issue").apply { addArgs("number", number) }.also { doInit(it, init) }
    fun issueOrPullRequest(number: Int, init: IssueOrPullRequest.() -> Unit) =
        IssueOrPullRequest("issueOrPullRequest").apply { addArgs("number", number) }.also { doInit(it, init) }
    fun issueTemplates(init: IssueTemplate.() -> Unit) =
        IssueTemplate("issueTemplates").also { doInit(it, init) }
    fun issues(after: String? = null, before: String? = null, filterBy: IssueFilters? = null, first: Int? = null, labels: String? = null, last: Int? = null, orderBy: IssueOrder? = null, states: IssueState? = null, init: IssueConnection.() -> Unit) =
        IssueConnection("issues").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("filterBy", filterBy) }.apply { addArgs("first", first) }.apply { addArgs("labels", labels) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("states", states) }.also { doInit(it, init) }
    fun label(name: String, init: Label.() -> Unit) =
        Label("label").apply { addArgs("name", name) }.also { doInit(it, init) }
    fun labels(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: LabelOrder? = null, query: String? = null, init: LabelConnection.() -> Unit) =
        LabelConnection("labels").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("query", query) }.also { doInit(it, init) }
    fun languages(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: LanguageOrder? = null, init: LanguageConnection.() -> Unit) =
        LanguageConnection("languages").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun licenseInfo(init: License.() -> Unit) =
        License("licenseInfo").also { doInit(it, init) }
    val lockReason get() =
        ScalarNode("lockReason").also { doInit(it) }
    fun mentionableUsers(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, query: String? = null, init: UserConnection.() -> Unit) =
        UserConnection("mentionableUsers").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("query", query) }.also { doInit(it, init) }
    val mergeCommitAllowed get() =
        ScalarNode("mergeCommitAllowed").also { doInit(it) }
    fun milestone(number: Int, init: Milestone.() -> Unit) =
        Milestone("milestone").apply { addArgs("number", number) }.also { doInit(it, init) }
    fun milestones(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: MilestoneOrder? = null, query: String? = null, states: MilestoneState? = null, init: MilestoneConnection.() -> Unit) =
        MilestoneConnection("milestones").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("query", query) }.apply { addArgs("states", states) }.also { doInit(it, init) }
    val mirrorUrl get() =
        ScalarNode("mirrorUrl").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    val nameWithOwner get() =
        ScalarNode("nameWithOwner").also { doInit(it) }
    fun `object`(expression: String? = null, oid: GitObjectID? = null, init: GitObject.() -> Unit) =
        GitObject("object").apply { addArgs("expression", expression) }.apply { addArgs("oid", oid) }.also { doInit(it, init) }
    val openGraphImageUrl get() =
        ScalarNode("openGraphImageUrl").also { doInit(it) }
    fun owner(init: RepositoryOwner.() -> Unit) =
        RepositoryOwner("owner").also { doInit(it, init) }
    fun packages(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, names: String? = null, orderBy: PackageOrder? = null, packageType: PackageType? = null, repositoryId: ID? = null, init: PackageConnection.() -> Unit) =
        PackageConnection("packages").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("names", names) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("packageType", packageType) }.apply { addArgs("repositoryId", repositoryId) }.also { doInit(it, init) }
    fun parent(init: Repository.() -> Unit) =
        Repository("parent").also { doInit(it, init) }
    fun pinnedIssues(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: PinnedIssueConnection.() -> Unit) =
        PinnedIssueConnection("pinnedIssues").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun primaryLanguage(init: Language.() -> Unit) =
        Language("primaryLanguage").also { doInit(it, init) }
    fun project(number: Int, init: Project.() -> Unit) =
        Project("project").apply { addArgs("number", number) }.also { doInit(it, init) }
    fun projects(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: ProjectOrder? = null, search: String? = null, states: ProjectState? = null, init: ProjectConnection.() -> Unit) =
        ProjectConnection("projects").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("search", search) }.apply { addArgs("states", states) }.also { doInit(it, init) }
    val projectsResourcePath get() =
        ScalarNode("projectsResourcePath").also { doInit(it) }
    val projectsUrl get() =
        ScalarNode("projectsUrl").also { doInit(it) }
    fun pullRequest(number: Int, init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").apply { addArgs("number", number) }.also { doInit(it, init) }
    fun pullRequests(after: String? = null, baseRefName: String? = null, before: String? = null, first: Int? = null, headRefName: String? = null, labels: String? = null, last: Int? = null, orderBy: IssueOrder? = null, states: PullRequestState? = null, init: PullRequestConnection.() -> Unit) =
        PullRequestConnection("pullRequests").apply { addArgs("after", after) }.apply { addArgs("baseRefName", baseRefName) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("headRefName", headRefName) }.apply { addArgs("labels", labels) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("states", states) }.also { doInit(it, init) }
    val pushedAt get() =
        ScalarNode("pushedAt").also { doInit(it) }
    val rebaseMergeAllowed get() =
        ScalarNode("rebaseMergeAllowed").also { doInit(it) }
    fun ref(qualifiedName: String, init: Ref.() -> Unit) =
        Ref("ref").apply { addArgs("qualifiedName", qualifiedName) }.also { doInit(it, init) }
    fun refs(after: String? = null, before: String? = null, direction: OrderDirection? = null, first: Int? = null, last: Int? = null, orderBy: RefOrder? = null, query: String? = null, refPrefix: String, init: RefConnection.() -> Unit) =
        RefConnection("refs").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("direction", direction) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("query", query) }.apply { addArgs("refPrefix", refPrefix) }.also { doInit(it, init) }
    fun release(tagName: String, init: Release.() -> Unit) =
        Release("release").apply { addArgs("tagName", tagName) }.also { doInit(it, init) }
    fun releases(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: ReleaseOrder? = null, init: ReleaseConnection.() -> Unit) =
        ReleaseConnection("releases").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun repositoryTopics(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: RepositoryTopicConnection.() -> Unit) =
        RepositoryTopicConnection("repositoryTopics").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val securityPolicyUrl get() =
        ScalarNode("securityPolicyUrl").also { doInit(it) }
    fun shortDescriptionHTML(limit: Int? = null) =
        ScalarWithArgsNode("shortDescriptionHTML", mapOf("limit" to limit)).also { doInit(it) }
    val shortDescriptionHTML get() =
        ScalarNode("shortDescriptionHTML").also { doInit(it) }
    val squashMergeAllowed get() =
        ScalarNode("squashMergeAllowed").also { doInit(it) }
    val sshUrl get() =
        ScalarNode("sshUrl").also { doInit(it) }
    val stargazerCount get() =
        ScalarNode("stargazerCount").also { doInit(it) }
    fun stargazers(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: StarOrder? = null, init: StargazerConnection.() -> Unit) =
        StargazerConnection("stargazers").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun submodules(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: SubmoduleConnection.() -> Unit) =
        SubmoduleConnection("submodules").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val tempCloneToken get() =
        ScalarNode("tempCloneToken").also { doInit(it) }
    fun templateRepository(init: Repository.() -> Unit) =
        Repository("templateRepository").also { doInit(it, init) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    val usesCustomOpenGraphImage get() =
        ScalarNode("usesCustomOpenGraphImage").also { doInit(it) }
    val viewerCanAdminister get() =
        ScalarNode("viewerCanAdminister").also { doInit(it) }
    val viewerCanCreateProjects get() =
        ScalarNode("viewerCanCreateProjects").also { doInit(it) }
    val viewerCanSubscribe get() =
        ScalarNode("viewerCanSubscribe").also { doInit(it) }
    val viewerCanUpdateTopics get() =
        ScalarNode("viewerCanUpdateTopics").also { doInit(it) }
    val viewerDefaultCommitEmail get() =
        ScalarNode("viewerDefaultCommitEmail").also { doInit(it) }
    val viewerDefaultMergeMethod get() =
        ScalarNode("viewerDefaultMergeMethod").also { doInit(it) }
    val viewerHasStarred get() =
        ScalarNode("viewerHasStarred").also { doInit(it) }
    val viewerPermission get() =
        ScalarNode("viewerPermission").also { doInit(it) }
    val viewerPossibleCommitEmails get() =
        ScalarNode("viewerPossibleCommitEmails").also { doInit(it) }
    val viewerSubscription get() =
        ScalarNode("viewerSubscription").also { doInit(it) }
    fun vulnerabilityAlerts(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: RepositoryVulnerabilityAlertConnection.() -> Unit) =
        RepositoryVulnerabilityAlertConnection("vulnerabilityAlerts").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun watchers(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: UserConnection.() -> Unit) =
        UserConnection("watchers").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
}

class RepositoryCollaboratorConnection(__name: String = "RepositoryCollaboratorConnection"): ObjectNode(__name) {
    fun edges(init: RepositoryCollaboratorEdge.() -> Unit) =
        RepositoryCollaboratorEdge("edges").also { doInit(it, init) }
    fun nodes(init: User.() -> Unit) =
        User("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class RepositoryCollaboratorEdge(__name: String = "RepositoryCollaboratorEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: User.() -> Unit) =
        User("node").also { doInit(it, init) }
    val permission get() =
        ScalarNode("permission").also { doInit(it) }
    fun permissionSources(init: PermissionSource.() -> Unit) =
        PermissionSource("permissionSources").also { doInit(it, init) }
}

class RepositoryConnection(__name: String = "RepositoryConnection"): ObjectNode(__name) {
    fun edges(init: RepositoryEdge.() -> Unit) =
        RepositoryEdge("edges").also { doInit(it, init) }
    fun nodes(init: Repository.() -> Unit) =
        Repository("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
    val totalDiskUsage get() =
        ScalarNode("totalDiskUsage").also { doInit(it) }
}

class RepositoryContactLink(__name: String = "RepositoryContactLink"): ObjectNode(__name) {
    val about get() =
        ScalarNode("about").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
}

class RepositoryEdge(__name: String = "RepositoryEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: Repository.() -> Unit) =
        Repository("node").also { doInit(it, init) }
}

class RepositoryInvitation(__name: String = "RepositoryInvitation"): ObjectNode(__name) {
    val email get() =
        ScalarNode("email").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun invitee(init: User.() -> Unit) =
        User("invitee").also { doInit(it, init) }
    fun inviter(init: User.() -> Unit) =
        User("inviter").also { doInit(it, init) }
    val permalink get() =
        ScalarNode("permalink").also { doInit(it) }
    val permission get() =
        ScalarNode("permission").also { doInit(it) }
    fun repository(init: RepositoryInfo.() -> Unit) =
        RepositoryInfo("repository").also { doInit(it, init) }
}

class RepositoryInvitationConnection(__name: String = "RepositoryInvitationConnection"): ObjectNode(__name) {
    fun edges(init: RepositoryInvitationEdge.() -> Unit) =
        RepositoryInvitationEdge("edges").also { doInit(it, init) }
    fun nodes(init: RepositoryInvitation.() -> Unit) =
        RepositoryInvitation("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class RepositoryInvitationEdge(__name: String = "RepositoryInvitationEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: RepositoryInvitation.() -> Unit) =
        RepositoryInvitation("node").also { doInit(it, init) }
}

class RepositoryTopic(__name: String = "RepositoryTopic"): ObjectNode(__name) {
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    fun topic(init: Topic.() -> Unit) =
        Topic("topic").also { doInit(it, init) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
}

class RepositoryTopicConnection(__name: String = "RepositoryTopicConnection"): ObjectNode(__name) {
    fun edges(init: RepositoryTopicEdge.() -> Unit) =
        RepositoryTopicEdge("edges").also { doInit(it, init) }
    fun nodes(init: RepositoryTopic.() -> Unit) =
        RepositoryTopic("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class RepositoryTopicEdge(__name: String = "RepositoryTopicEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: RepositoryTopic.() -> Unit) =
        RepositoryTopic("node").also { doInit(it, init) }
}

class RepositoryVisibilityChangeDisableAuditEntry(__name: String = "RepositoryVisibilityChangeDisableAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val enterpriseResourcePath get() =
        ScalarNode("enterpriseResourcePath").also { doInit(it) }
    val enterpriseSlug get() =
        ScalarNode("enterpriseSlug").also { doInit(it) }
    val enterpriseUrl get() =
        ScalarNode("enterpriseUrl").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class RepositoryVisibilityChangeEnableAuditEntry(__name: String = "RepositoryVisibilityChangeEnableAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val enterpriseResourcePath get() =
        ScalarNode("enterpriseResourcePath").also { doInit(it) }
    val enterpriseSlug get() =
        ScalarNode("enterpriseSlug").also { doInit(it) }
    val enterpriseUrl get() =
        ScalarNode("enterpriseUrl").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class RepositoryVulnerabilityAlert(__name: String = "RepositoryVulnerabilityAlert"): ObjectNode(__name) {
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val dismissReason get() =
        ScalarNode("dismissReason").also { doInit(it) }
    val dismissedAt get() =
        ScalarNode("dismissedAt").also { doInit(it) }
    fun dismisser(init: User.() -> Unit) =
        User("dismisser").also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    fun securityAdvisory(init: SecurityAdvisory.() -> Unit) =
        SecurityAdvisory("securityAdvisory").also { doInit(it, init) }
    fun securityVulnerability(init: SecurityVulnerability.() -> Unit) =
        SecurityVulnerability("securityVulnerability").also { doInit(it, init) }
    val vulnerableManifestFilename get() =
        ScalarNode("vulnerableManifestFilename").also { doInit(it) }
    val vulnerableManifestPath get() =
        ScalarNode("vulnerableManifestPath").also { doInit(it) }
    val vulnerableRequirements get() =
        ScalarNode("vulnerableRequirements").also { doInit(it) }
}

class RepositoryVulnerabilityAlertConnection(__name: String = "RepositoryVulnerabilityAlertConnection"): ObjectNode(__name) {
    fun edges(init: RepositoryVulnerabilityAlertEdge.() -> Unit) =
        RepositoryVulnerabilityAlertEdge("edges").also { doInit(it, init) }
    fun nodes(init: RepositoryVulnerabilityAlert.() -> Unit) =
        RepositoryVulnerabilityAlert("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class RepositoryVulnerabilityAlertEdge(__name: String = "RepositoryVulnerabilityAlertEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: RepositoryVulnerabilityAlert.() -> Unit) =
        RepositoryVulnerabilityAlert("node").also { doInit(it, init) }
}

class RequestReviewsPayload(__name: String = "RequestReviewsPayload"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
    fun requestedReviewersEdge(init: UserEdge.() -> Unit) =
        UserEdge("requestedReviewersEdge").also { doInit(it, init) }
}

class RerequestCheckSuitePayload(__name: String = "RerequestCheckSuitePayload"): ObjectNode(__name) {
    fun checkSuite(init: CheckSuite.() -> Unit) =
        CheckSuite("checkSuite").also { doInit(it, init) }
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
}

class ResolveReviewThreadPayload(__name: String = "ResolveReviewThreadPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun thread(init: PullRequestReviewThread.() -> Unit) =
        PullRequestReviewThread("thread").also { doInit(it, init) }
}

class RestrictedContribution(__name: String = "RestrictedContribution"): ObjectNode(__name) {
    val isRestricted get() =
        ScalarNode("isRestricted").also { doInit(it) }
    val occurredAt get() =
        ScalarNode("occurredAt").also { doInit(it) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
}

class ReviewDismissalAllowance(__name: String = "ReviewDismissalAllowance"): ObjectNode(__name) {
    fun actor(init: ReviewDismissalAllowanceActor.() -> Unit) =
        ReviewDismissalAllowanceActor("actor").also { doInit(it, init) }
    fun branchProtectionRule(init: BranchProtectionRule.() -> Unit) =
        BranchProtectionRule("branchProtectionRule").also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
}

class ReviewDismissalAllowanceConnection(__name: String = "ReviewDismissalAllowanceConnection"): ObjectNode(__name) {
    fun edges(init: ReviewDismissalAllowanceEdge.() -> Unit) =
        ReviewDismissalAllowanceEdge("edges").also { doInit(it, init) }
    fun nodes(init: ReviewDismissalAllowance.() -> Unit) =
        ReviewDismissalAllowance("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class ReviewDismissalAllowanceEdge(__name: String = "ReviewDismissalAllowanceEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: ReviewDismissalAllowance.() -> Unit) =
        ReviewDismissalAllowance("node").also { doInit(it, init) }
}

class ReviewDismissedEvent(__name: String = "ReviewDismissedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val dismissalMessage get() =
        ScalarNode("dismissalMessage").also { doInit(it) }
    val dismissalMessageHTML get() =
        ScalarNode("dismissalMessageHTML").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val previousReviewState get() =
        ScalarNode("previousReviewState").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
    fun pullRequestCommit(init: PullRequestCommit.() -> Unit) =
        PullRequestCommit("pullRequestCommit").also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    fun review(init: PullRequestReview.() -> Unit) =
        PullRequestReview("review").also { doInit(it, init) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
}

class ReviewRequest(__name: String = "ReviewRequest"): ObjectNode(__name) {
    val asCodeOwner get() =
        ScalarNode("asCodeOwner").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
    fun requestedReviewer(init: RequestedReviewer.() -> Unit) =
        RequestedReviewer("requestedReviewer").also { doInit(it, init) }
}

class ReviewRequestConnection(__name: String = "ReviewRequestConnection"): ObjectNode(__name) {
    fun edges(init: ReviewRequestEdge.() -> Unit) =
        ReviewRequestEdge("edges").also { doInit(it, init) }
    fun nodes(init: ReviewRequest.() -> Unit) =
        ReviewRequest("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class ReviewRequestEdge(__name: String = "ReviewRequestEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: ReviewRequest.() -> Unit) =
        ReviewRequest("node").also { doInit(it, init) }
}

class ReviewRequestRemovedEvent(__name: String = "ReviewRequestRemovedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
    fun requestedReviewer(init: RequestedReviewer.() -> Unit) =
        RequestedReviewer("requestedReviewer").also { doInit(it, init) }
}

class ReviewRequestedEvent(__name: String = "ReviewRequestedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
    fun requestedReviewer(init: RequestedReviewer.() -> Unit) =
        RequestedReviewer("requestedReviewer").also { doInit(it, init) }
}

class ReviewStatusHovercardContext(__name: String = "ReviewStatusHovercardContext"): ObjectNode(__name) {
    val message get() =
        ScalarNode("message").also { doInit(it) }
    val octicon get() =
        ScalarNode("octicon").also { doInit(it) }
    val reviewDecision get() =
        ScalarNode("reviewDecision").also { doInit(it) }
}

class SavedReply(__name: String = "SavedReply"): ObjectNode(__name) {
    val body get() =
        ScalarNode("body").also { doInit(it) }
    val bodyHTML get() =
        ScalarNode("bodyHTML").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val title get() =
        ScalarNode("title").also { doInit(it) }
    fun user(init: Actor.() -> Unit) =
        Actor("user").also { doInit(it, init) }
}

class SavedReplyConnection(__name: String = "SavedReplyConnection"): ObjectNode(__name) {
    fun edges(init: SavedReplyEdge.() -> Unit) =
        SavedReplyEdge("edges").also { doInit(it, init) }
    fun nodes(init: SavedReply.() -> Unit) =
        SavedReply("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class SavedReplyEdge(__name: String = "SavedReplyEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: SavedReply.() -> Unit) =
        SavedReply("node").also { doInit(it, init) }
}

class SearchResultItemConnection(__name: String = "SearchResultItemConnection"): ObjectNode(__name) {
    val codeCount get() =
        ScalarNode("codeCount").also { doInit(it) }
    fun edges(init: SearchResultItemEdge.() -> Unit) =
        SearchResultItemEdge("edges").also { doInit(it, init) }
    val issueCount get() =
        ScalarNode("issueCount").also { doInit(it) }
    fun nodes(init: SearchResultItem.() -> Unit) =
        SearchResultItem("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val repositoryCount get() =
        ScalarNode("repositoryCount").also { doInit(it) }
    val userCount get() =
        ScalarNode("userCount").also { doInit(it) }
    val wikiCount get() =
        ScalarNode("wikiCount").also { doInit(it) }
}

class SearchResultItemEdge(__name: String = "SearchResultItemEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: SearchResultItem.() -> Unit) =
        SearchResultItem("node").also { doInit(it, init) }
    fun textMatches(init: TextMatch.() -> Unit) =
        TextMatch("textMatches").also { doInit(it, init) }
}

class SecurityAdvisory(__name: String = "SecurityAdvisory"): ObjectNode(__name) {
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val description get() =
        ScalarNode("description").also { doInit(it) }
    val ghsaId get() =
        ScalarNode("ghsaId").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun identifiers(init: SecurityAdvisoryIdentifier.() -> Unit) =
        SecurityAdvisoryIdentifier("identifiers").also { doInit(it, init) }
    val origin get() =
        ScalarNode("origin").also { doInit(it) }
    val permalink get() =
        ScalarNode("permalink").also { doInit(it) }
    val publishedAt get() =
        ScalarNode("publishedAt").also { doInit(it) }
    fun references(init: SecurityAdvisoryReference.() -> Unit) =
        SecurityAdvisoryReference("references").also { doInit(it, init) }
    val severity get() =
        ScalarNode("severity").also { doInit(it) }
    val summary get() =
        ScalarNode("summary").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    fun vulnerabilities(after: String? = null, before: String? = null, ecosystem: SecurityAdvisoryEcosystem? = null, first: Int? = null, last: Int? = null, orderBy: SecurityVulnerabilityOrder? = null, `package`: String? = null, severities: SecurityAdvisorySeverity? = null, init: SecurityVulnerabilityConnection.() -> Unit) =
        SecurityVulnerabilityConnection("vulnerabilities").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("ecosystem", ecosystem) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("package", `package`) }.apply { addArgs("severities", severities) }.also { doInit(it, init) }
    val withdrawnAt get() =
        ScalarNode("withdrawnAt").also { doInit(it) }
}

class SecurityAdvisoryConnection(__name: String = "SecurityAdvisoryConnection"): ObjectNode(__name) {
    fun edges(init: SecurityAdvisoryEdge.() -> Unit) =
        SecurityAdvisoryEdge("edges").also { doInit(it, init) }
    fun nodes(init: SecurityAdvisory.() -> Unit) =
        SecurityAdvisory("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class SecurityAdvisoryEdge(__name: String = "SecurityAdvisoryEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: SecurityAdvisory.() -> Unit) =
        SecurityAdvisory("node").also { doInit(it, init) }
}

class SecurityAdvisoryIdentifier(__name: String = "SecurityAdvisoryIdentifier"): ObjectNode(__name) {
    val type get() =
        ScalarNode("type").also { doInit(it) }
    val value get() =
        ScalarNode("value").also { doInit(it) }
}

class SecurityAdvisoryPackage(__name: String = "SecurityAdvisoryPackage"): ObjectNode(__name) {
    val ecosystem get() =
        ScalarNode("ecosystem").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
}

class SecurityAdvisoryPackageVersion(__name: String = "SecurityAdvisoryPackageVersion"): ObjectNode(__name) {
    val identifier get() =
        ScalarNode("identifier").also { doInit(it) }
}

class SecurityAdvisoryReference(__name: String = "SecurityAdvisoryReference"): ObjectNode(__name) {
    val url get() =
        ScalarNode("url").also { doInit(it) }
}

class SecurityVulnerability(__name: String = "SecurityVulnerability"): ObjectNode(__name) {
    fun advisory(init: SecurityAdvisory.() -> Unit) =
        SecurityAdvisory("advisory").also { doInit(it, init) }
    fun firstPatchedVersion(init: SecurityAdvisoryPackageVersion.() -> Unit) =
        SecurityAdvisoryPackageVersion("firstPatchedVersion").also { doInit(it, init) }
    fun `package`(init: SecurityAdvisoryPackage.() -> Unit) =
        SecurityAdvisoryPackage("package").also { doInit(it, init) }
    val severity get() =
        ScalarNode("severity").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    val vulnerableVersionRange get() =
        ScalarNode("vulnerableVersionRange").also { doInit(it) }
}

class SecurityVulnerabilityConnection(__name: String = "SecurityVulnerabilityConnection"): ObjectNode(__name) {
    fun edges(init: SecurityVulnerabilityEdge.() -> Unit) =
        SecurityVulnerabilityEdge("edges").also { doInit(it, init) }
    fun nodes(init: SecurityVulnerability.() -> Unit) =
        SecurityVulnerability("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class SecurityVulnerabilityEdge(__name: String = "SecurityVulnerabilityEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: SecurityVulnerability.() -> Unit) =
        SecurityVulnerability("node").also { doInit(it, init) }
}

class SetEnterpriseIdentityProviderPayload(__name: String = "SetEnterpriseIdentityProviderPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun identityProvider(init: EnterpriseIdentityProvider.() -> Unit) =
        EnterpriseIdentityProvider("identityProvider").also { doInit(it, init) }
}

class SmimeSignature(__name: String = "SmimeSignature"): ObjectNode(__name) {
    val email get() =
        ScalarNode("email").also { doInit(it) }
    val isValid get() =
        ScalarNode("isValid").also { doInit(it) }
    val payload get() =
        ScalarNode("payload").also { doInit(it) }
    val signature get() =
        ScalarNode("signature").also { doInit(it) }
    fun signer(init: User.() -> Unit) =
        User("signer").also { doInit(it, init) }
    val state get() =
        ScalarNode("state").also { doInit(it) }
    val wasSignedByGitHub get() =
        ScalarNode("wasSignedByGitHub").also { doInit(it) }
}

class SponsorsListing(__name: String = "SponsorsListing"): ObjectNode(__name) {
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val fullDescription get() =
        ScalarNode("fullDescription").also { doInit(it) }
    val fullDescriptionHTML get() =
        ScalarNode("fullDescriptionHTML").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    val shortDescription get() =
        ScalarNode("shortDescription").also { doInit(it) }
    val slug get() =
        ScalarNode("slug").also { doInit(it) }
    fun tiers(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: SponsorsTierOrder? = null, init: SponsorsTierConnection.() -> Unit) =
        SponsorsTierConnection("tiers").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
}

class SponsorsTier(__name: String = "SponsorsTier"): ObjectNode(__name) {
    fun adminInfo(init: SponsorsTierAdminInfo.() -> Unit) =
        SponsorsTierAdminInfo("adminInfo").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val description get() =
        ScalarNode("description").also { doInit(it) }
    val descriptionHTML get() =
        ScalarNode("descriptionHTML").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val monthlyPriceInCents get() =
        ScalarNode("monthlyPriceInCents").also { doInit(it) }
    val monthlyPriceInDollars get() =
        ScalarNode("monthlyPriceInDollars").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    fun sponsorsListing(init: SponsorsListing.() -> Unit) =
        SponsorsListing("sponsorsListing").also { doInit(it, init) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
}

class SponsorsTierAdminInfo(__name: String = "SponsorsTierAdminInfo"): ObjectNode(__name) {
    fun sponsorships(after: String? = null, before: String? = null, first: Int? = null, includePrivate: Boolean? = null, last: Int? = null, orderBy: SponsorshipOrder? = null, init: SponsorshipConnection.() -> Unit) =
        SponsorshipConnection("sponsorships").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("includePrivate", includePrivate) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
}

class SponsorsTierConnection(__name: String = "SponsorsTierConnection"): ObjectNode(__name) {
    fun edges(init: SponsorsTierEdge.() -> Unit) =
        SponsorsTierEdge("edges").also { doInit(it, init) }
    fun nodes(init: SponsorsTier.() -> Unit) =
        SponsorsTier("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class SponsorsTierEdge(__name: String = "SponsorsTierEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: SponsorsTier.() -> Unit) =
        SponsorsTier("node").also { doInit(it, init) }
}

class Sponsorship(__name: String = "Sponsorship"): ObjectNode(__name) {
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    @Deprecated("`Sponsorship.maintainer` will be removed. Use `Sponsorship.sponsorable` instead. Removal on 2020-04-01 UTC.")
    fun maintainer(init: User.() -> Unit) =
        User("maintainer").also { doInit(it, init) }
    val privacyLevel get() =
        ScalarNode("privacyLevel").also { doInit(it) }
    @Deprecated("`Sponsorship.sponsor` will be removed. Use `Sponsorship.sponsorEntity` instead. Removal on 2020-10-01 UTC.")
    fun sponsor(init: User.() -> Unit) =
        User("sponsor").also { doInit(it, init) }
    fun sponsorEntity(init: Sponsor.() -> Unit) =
        Sponsor("sponsorEntity").also { doInit(it, init) }
    fun sponsorable(init: Sponsorable.() -> Unit) =
        Sponsorable("sponsorable").also { doInit(it, init) }
    fun tier(init: SponsorsTier.() -> Unit) =
        SponsorsTier("tier").also { doInit(it, init) }
}

class SponsorshipConnection(__name: String = "SponsorshipConnection"): ObjectNode(__name) {
    fun edges(init: SponsorshipEdge.() -> Unit) =
        SponsorshipEdge("edges").also { doInit(it, init) }
    fun nodes(init: Sponsorship.() -> Unit) =
        Sponsorship("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class SponsorshipEdge(__name: String = "SponsorshipEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: Sponsorship.() -> Unit) =
        Sponsorship("node").also { doInit(it, init) }
}

class StargazerConnection(__name: String = "StargazerConnection"): ObjectNode(__name) {
    fun edges(init: StargazerEdge.() -> Unit) =
        StargazerEdge("edges").also { doInit(it, init) }
    fun nodes(init: User.() -> Unit) =
        User("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class StargazerEdge(__name: String = "StargazerEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: User.() -> Unit) =
        User("node").also { doInit(it, init) }
    val starredAt get() =
        ScalarNode("starredAt").also { doInit(it) }
}

class StarredRepositoryConnection(__name: String = "StarredRepositoryConnection"): ObjectNode(__name) {
    fun edges(init: StarredRepositoryEdge.() -> Unit) =
        StarredRepositoryEdge("edges").also { doInit(it, init) }
    val isOverLimit get() =
        ScalarNode("isOverLimit").also { doInit(it) }
    fun nodes(init: Repository.() -> Unit) =
        Repository("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class StarredRepositoryEdge(__name: String = "StarredRepositoryEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: Repository.() -> Unit) =
        Repository("node").also { doInit(it, init) }
    val starredAt get() =
        ScalarNode("starredAt").also { doInit(it) }
}

class Status(__name: String = "Status"): ObjectNode(__name) {
    fun combinedContexts(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: StatusCheckRollupContextConnection.() -> Unit) =
        StatusCheckRollupContextConnection("combinedContexts").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun commit(init: Commit.() -> Unit) =
        Commit("commit").also { doInit(it, init) }
    fun context(name: String, init: StatusContext.() -> Unit) =
        StatusContext("context").apply { addArgs("name", name) }.also { doInit(it, init) }
    fun contexts(init: StatusContext.() -> Unit) =
        StatusContext("contexts").also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val state get() =
        ScalarNode("state").also { doInit(it) }
}

class StatusCheckRollup(__name: String = "StatusCheckRollup"): ObjectNode(__name) {
    fun commit(init: Commit.() -> Unit) =
        Commit("commit").also { doInit(it, init) }
    fun contexts(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: StatusCheckRollupContextConnection.() -> Unit) =
        StatusCheckRollupContextConnection("contexts").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val state get() =
        ScalarNode("state").also { doInit(it) }
}

class StatusCheckRollupContextConnection(__name: String = "StatusCheckRollupContextConnection"): ObjectNode(__name) {
    fun edges(init: StatusCheckRollupContextEdge.() -> Unit) =
        StatusCheckRollupContextEdge("edges").also { doInit(it, init) }
    fun nodes(init: StatusCheckRollupContext.() -> Unit) =
        StatusCheckRollupContext("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class StatusCheckRollupContextEdge(__name: String = "StatusCheckRollupContextEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: StatusCheckRollupContext.() -> Unit) =
        StatusCheckRollupContext("node").also { doInit(it, init) }
}

class StatusContext(__name: String = "StatusContext"): ObjectNode(__name) {
    fun avatarUrl(size: Int? = null) =
        ScalarWithArgsNode("avatarUrl", mapOf("size" to size)).also { doInit(it) }
    val avatarUrl get() =
        ScalarNode("avatarUrl").also { doInit(it) }
    fun commit(init: Commit.() -> Unit) =
        Commit("commit").also { doInit(it, init) }
    val context get() =
        ScalarNode("context").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    fun creator(init: Actor.() -> Unit) =
        Actor("creator").also { doInit(it, init) }
    val description get() =
        ScalarNode("description").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val state get() =
        ScalarNode("state").also { doInit(it) }
    val targetUrl get() =
        ScalarNode("targetUrl").also { doInit(it) }
}

class SubmitPullRequestReviewPayload(__name: String = "SubmitPullRequestReviewPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun pullRequestReview(init: PullRequestReview.() -> Unit) =
        PullRequestReview("pullRequestReview").also { doInit(it, init) }
}

class Submodule(__name: String = "Submodule"): ObjectNode(__name) {
    val branch get() =
        ScalarNode("branch").also { doInit(it) }
    val gitUrl get() =
        ScalarNode("gitUrl").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    val path get() =
        ScalarNode("path").also { doInit(it) }
    val subprojectCommitOid get() =
        ScalarNode("subprojectCommitOid").also { doInit(it) }
}

class SubmoduleConnection(__name: String = "SubmoduleConnection"): ObjectNode(__name) {
    fun edges(init: SubmoduleEdge.() -> Unit) =
        SubmoduleEdge("edges").also { doInit(it, init) }
    fun nodes(init: Submodule.() -> Unit) =
        Submodule("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class SubmoduleEdge(__name: String = "SubmoduleEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: Submodule.() -> Unit) =
        Submodule("node").also { doInit(it, init) }
}

class SubscribedEvent(__name: String = "SubscribedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun subscribable(init: Subscribable.() -> Unit) =
        Subscribable("subscribable").also { doInit(it, init) }
}

class SuggestedReviewer(__name: String = "SuggestedReviewer"): ObjectNode(__name) {
    val isAuthor get() =
        ScalarNode("isAuthor").also { doInit(it) }
    val isCommenter get() =
        ScalarNode("isCommenter").also { doInit(it) }
    fun reviewer(init: User.() -> Unit) =
        User("reviewer").also { doInit(it, init) }
}

class Tag(__name: String = "Tag"): ObjectNode(__name) {
    val abbreviatedOid get() =
        ScalarNode("abbreviatedOid").also { doInit(it) }
    val commitResourcePath get() =
        ScalarNode("commitResourcePath").also { doInit(it) }
    val commitUrl get() =
        ScalarNode("commitUrl").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val message get() =
        ScalarNode("message").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    val oid get() =
        ScalarNode("oid").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    fun tagger(init: GitActor.() -> Unit) =
        GitActor("tagger").also { doInit(it, init) }
    fun target(init: GitObject.() -> Unit) =
        GitObject("target").also { doInit(it, init) }
}

class Team(__name: String = "Team"): ObjectNode(__name) {
    fun ancestors(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: TeamConnection.() -> Unit) =
        TeamConnection("ancestors").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun avatarUrl(size: Int? = null) =
        ScalarWithArgsNode("avatarUrl", mapOf("size" to size)).also { doInit(it) }
    val avatarUrl get() =
        ScalarNode("avatarUrl").also { doInit(it) }
    fun childTeams(after: String? = null, before: String? = null, first: Int? = null, immediateOnly: Boolean? = null, last: Int? = null, orderBy: TeamOrder? = null, userLogins: String? = null, init: TeamConnection.() -> Unit) =
        TeamConnection("childTeams").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("immediateOnly", immediateOnly) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("userLogins", userLogins) }.also { doInit(it, init) }
    val combinedSlug get() =
        ScalarNode("combinedSlug").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val description get() =
        ScalarNode("description").also { doInit(it) }
    fun discussion(number: Int, init: TeamDiscussion.() -> Unit) =
        TeamDiscussion("discussion").apply { addArgs("number", number) }.also { doInit(it, init) }
    fun discussions(after: String? = null, before: String? = null, first: Int? = null, isPinned: Boolean? = null, last: Int? = null, orderBy: TeamDiscussionOrder? = null, init: TeamDiscussionConnection.() -> Unit) =
        TeamDiscussionConnection("discussions").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("isPinned", isPinned) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    val discussionsResourcePath get() =
        ScalarNode("discussionsResourcePath").also { doInit(it) }
    val discussionsUrl get() =
        ScalarNode("discussionsUrl").also { doInit(it) }
    val editTeamResourcePath get() =
        ScalarNode("editTeamResourcePath").also { doInit(it) }
    val editTeamUrl get() =
        ScalarNode("editTeamUrl").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun invitations(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: OrganizationInvitationConnection.() -> Unit) =
        OrganizationInvitationConnection("invitations").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun memberStatuses(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: UserStatusOrder? = null, init: UserStatusConnection.() -> Unit) =
        UserStatusConnection("memberStatuses").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun members(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, membership: TeamMembershipType? = null, orderBy: TeamMemberOrder? = null, query: String? = null, role: TeamMemberRole? = null, init: TeamMemberConnection.() -> Unit) =
        TeamMemberConnection("members").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("membership", membership) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("query", query) }.apply { addArgs("role", role) }.also { doInit(it, init) }
    val membersResourcePath get() =
        ScalarNode("membersResourcePath").also { doInit(it) }
    val membersUrl get() =
        ScalarNode("membersUrl").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    val newTeamResourcePath get() =
        ScalarNode("newTeamResourcePath").also { doInit(it) }
    val newTeamUrl get() =
        ScalarNode("newTeamUrl").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    fun parentTeam(init: Team.() -> Unit) =
        Team("parentTeam").also { doInit(it, init) }
    val privacy get() =
        ScalarNode("privacy").also { doInit(it) }
    fun repositories(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: TeamRepositoryOrder? = null, query: String? = null, init: TeamRepositoryConnection.() -> Unit) =
        TeamRepositoryConnection("repositories").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("query", query) }.also { doInit(it, init) }
    val repositoriesResourcePath get() =
        ScalarNode("repositoriesResourcePath").also { doInit(it) }
    val repositoriesUrl get() =
        ScalarNode("repositoriesUrl").also { doInit(it) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val reviewRequestDelegationAlgorithm get() =
        ScalarNode("reviewRequestDelegationAlgorithm").also { doInit(it) }
    val reviewRequestDelegationEnabled get() =
        ScalarNode("reviewRequestDelegationEnabled").also { doInit(it) }
    val reviewRequestDelegationMemberCount get() =
        ScalarNode("reviewRequestDelegationMemberCount").also { doInit(it) }
    val reviewRequestDelegationNotifyTeam get() =
        ScalarNode("reviewRequestDelegationNotifyTeam").also { doInit(it) }
    val slug get() =
        ScalarNode("slug").also { doInit(it) }
    val teamsResourcePath get() =
        ScalarNode("teamsResourcePath").also { doInit(it) }
    val teamsUrl get() =
        ScalarNode("teamsUrl").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    val viewerCanAdminister get() =
        ScalarNode("viewerCanAdminister").also { doInit(it) }
    val viewerCanSubscribe get() =
        ScalarNode("viewerCanSubscribe").also { doInit(it) }
    val viewerSubscription get() =
        ScalarNode("viewerSubscription").also { doInit(it) }
}

class TeamAddMemberAuditEntry(__name: String = "TeamAddMemberAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val isLdapMapped get() =
        ScalarNode("isLdapMapped").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun team(init: Team.() -> Unit) =
        Team("team").also { doInit(it, init) }
    val teamName get() =
        ScalarNode("teamName").also { doInit(it) }
    val teamResourcePath get() =
        ScalarNode("teamResourcePath").also { doInit(it) }
    val teamUrl get() =
        ScalarNode("teamUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class TeamAddRepositoryAuditEntry(__name: String = "TeamAddRepositoryAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val isLdapMapped get() =
        ScalarNode("isLdapMapped").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val repositoryName get() =
        ScalarNode("repositoryName").also { doInit(it) }
    val repositoryResourcePath get() =
        ScalarNode("repositoryResourcePath").also { doInit(it) }
    val repositoryUrl get() =
        ScalarNode("repositoryUrl").also { doInit(it) }
    fun team(init: Team.() -> Unit) =
        Team("team").also { doInit(it, init) }
    val teamName get() =
        ScalarNode("teamName").also { doInit(it) }
    val teamResourcePath get() =
        ScalarNode("teamResourcePath").also { doInit(it) }
    val teamUrl get() =
        ScalarNode("teamUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class TeamChangeParentTeamAuditEntry(__name: String = "TeamChangeParentTeamAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val isLdapMapped get() =
        ScalarNode("isLdapMapped").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun parentTeam(init: Team.() -> Unit) =
        Team("parentTeam").also { doInit(it, init) }
    val parentTeamName get() =
        ScalarNode("parentTeamName").also { doInit(it) }
    val parentTeamNameWas get() =
        ScalarNode("parentTeamNameWas").also { doInit(it) }
    val parentTeamResourcePath get() =
        ScalarNode("parentTeamResourcePath").also { doInit(it) }
    val parentTeamUrl get() =
        ScalarNode("parentTeamUrl").also { doInit(it) }
    fun parentTeamWas(init: Team.() -> Unit) =
        Team("parentTeamWas").also { doInit(it, init) }
    val parentTeamWasResourcePath get() =
        ScalarNode("parentTeamWasResourcePath").also { doInit(it) }
    val parentTeamWasUrl get() =
        ScalarNode("parentTeamWasUrl").also { doInit(it) }
    fun team(init: Team.() -> Unit) =
        Team("team").also { doInit(it, init) }
    val teamName get() =
        ScalarNode("teamName").also { doInit(it) }
    val teamResourcePath get() =
        ScalarNode("teamResourcePath").also { doInit(it) }
    val teamUrl get() =
        ScalarNode("teamUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class TeamConnection(__name: String = "TeamConnection"): ObjectNode(__name) {
    fun edges(init: TeamEdge.() -> Unit) =
        TeamEdge("edges").also { doInit(it, init) }
    fun nodes(init: Team.() -> Unit) =
        Team("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class TeamDiscussion(__name: String = "TeamDiscussion"): ObjectNode(__name) {
    fun author(init: Actor.() -> Unit) =
        Actor("author").also { doInit(it, init) }
    val authorAssociation get() =
        ScalarNode("authorAssociation").also { doInit(it) }
    val body get() =
        ScalarNode("body").also { doInit(it) }
    val bodyHTML get() =
        ScalarNode("bodyHTML").also { doInit(it) }
    val bodyText get() =
        ScalarNode("bodyText").also { doInit(it) }
    val bodyVersion get() =
        ScalarNode("bodyVersion").also { doInit(it) }
    fun comments(after: String? = null, before: String? = null, first: Int? = null, fromComment: Int? = null, last: Int? = null, orderBy: TeamDiscussionCommentOrder? = null, init: TeamDiscussionCommentConnection.() -> Unit) =
        TeamDiscussionCommentConnection("comments").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("fromComment", fromComment) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    val commentsResourcePath get() =
        ScalarNode("commentsResourcePath").also { doInit(it) }
    val commentsUrl get() =
        ScalarNode("commentsUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val createdViaEmail get() =
        ScalarNode("createdViaEmail").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    fun editor(init: Actor.() -> Unit) =
        Actor("editor").also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val includesCreatedEdit get() =
        ScalarNode("includesCreatedEdit").also { doInit(it) }
    val isPinned get() =
        ScalarNode("isPinned").also { doInit(it) }
    val isPrivate get() =
        ScalarNode("isPrivate").also { doInit(it) }
    val lastEditedAt get() =
        ScalarNode("lastEditedAt").also { doInit(it) }
    val number get() =
        ScalarNode("number").also { doInit(it) }
    val publishedAt get() =
        ScalarNode("publishedAt").also { doInit(it) }
    fun reactionGroups(init: ReactionGroup.() -> Unit) =
        ReactionGroup("reactionGroups").also { doInit(it, init) }
    fun reactions(after: String? = null, before: String? = null, content: ReactionContent? = null, first: Int? = null, last: Int? = null, orderBy: ReactionOrder? = null, init: ReactionConnection.() -> Unit) =
        ReactionConnection("reactions").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("content", content) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    fun team(init: Team.() -> Unit) =
        Team("team").also { doInit(it, init) }
    val title get() =
        ScalarNode("title").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    fun userContentEdits(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: UserContentEditConnection.() -> Unit) =
        UserContentEditConnection("userContentEdits").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val viewerCanDelete get() =
        ScalarNode("viewerCanDelete").also { doInit(it) }
    val viewerCanPin get() =
        ScalarNode("viewerCanPin").also { doInit(it) }
    val viewerCanReact get() =
        ScalarNode("viewerCanReact").also { doInit(it) }
    val viewerCanSubscribe get() =
        ScalarNode("viewerCanSubscribe").also { doInit(it) }
    val viewerCanUpdate get() =
        ScalarNode("viewerCanUpdate").also { doInit(it) }
    val viewerCannotUpdateReasons get() =
        ScalarNode("viewerCannotUpdateReasons").also { doInit(it) }
    val viewerDidAuthor get() =
        ScalarNode("viewerDidAuthor").also { doInit(it) }
    val viewerSubscription get() =
        ScalarNode("viewerSubscription").also { doInit(it) }
}

class TeamDiscussionComment(__name: String = "TeamDiscussionComment"): ObjectNode(__name) {
    fun author(init: Actor.() -> Unit) =
        Actor("author").also { doInit(it, init) }
    val authorAssociation get() =
        ScalarNode("authorAssociation").also { doInit(it) }
    val body get() =
        ScalarNode("body").also { doInit(it) }
    val bodyHTML get() =
        ScalarNode("bodyHTML").also { doInit(it) }
    val bodyText get() =
        ScalarNode("bodyText").also { doInit(it) }
    val bodyVersion get() =
        ScalarNode("bodyVersion").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val createdViaEmail get() =
        ScalarNode("createdViaEmail").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    fun discussion(init: TeamDiscussion.() -> Unit) =
        TeamDiscussion("discussion").also { doInit(it, init) }
    fun editor(init: Actor.() -> Unit) =
        Actor("editor").also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val includesCreatedEdit get() =
        ScalarNode("includesCreatedEdit").also { doInit(it) }
    val lastEditedAt get() =
        ScalarNode("lastEditedAt").also { doInit(it) }
    val number get() =
        ScalarNode("number").also { doInit(it) }
    val publishedAt get() =
        ScalarNode("publishedAt").also { doInit(it) }
    fun reactionGroups(init: ReactionGroup.() -> Unit) =
        ReactionGroup("reactionGroups").also { doInit(it, init) }
    fun reactions(after: String? = null, before: String? = null, content: ReactionContent? = null, first: Int? = null, last: Int? = null, orderBy: ReactionOrder? = null, init: ReactionConnection.() -> Unit) =
        ReactionConnection("reactions").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("content", content) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    fun userContentEdits(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: UserContentEditConnection.() -> Unit) =
        UserContentEditConnection("userContentEdits").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val viewerCanDelete get() =
        ScalarNode("viewerCanDelete").also { doInit(it) }
    val viewerCanReact get() =
        ScalarNode("viewerCanReact").also { doInit(it) }
    val viewerCanUpdate get() =
        ScalarNode("viewerCanUpdate").also { doInit(it) }
    val viewerCannotUpdateReasons get() =
        ScalarNode("viewerCannotUpdateReasons").also { doInit(it) }
    val viewerDidAuthor get() =
        ScalarNode("viewerDidAuthor").also { doInit(it) }
}

class TeamDiscussionCommentConnection(__name: String = "TeamDiscussionCommentConnection"): ObjectNode(__name) {
    fun edges(init: TeamDiscussionCommentEdge.() -> Unit) =
        TeamDiscussionCommentEdge("edges").also { doInit(it, init) }
    fun nodes(init: TeamDiscussionComment.() -> Unit) =
        TeamDiscussionComment("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class TeamDiscussionCommentEdge(__name: String = "TeamDiscussionCommentEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: TeamDiscussionComment.() -> Unit) =
        TeamDiscussionComment("node").also { doInit(it, init) }
}

class TeamDiscussionConnection(__name: String = "TeamDiscussionConnection"): ObjectNode(__name) {
    fun edges(init: TeamDiscussionEdge.() -> Unit) =
        TeamDiscussionEdge("edges").also { doInit(it, init) }
    fun nodes(init: TeamDiscussion.() -> Unit) =
        TeamDiscussion("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class TeamDiscussionEdge(__name: String = "TeamDiscussionEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: TeamDiscussion.() -> Unit) =
        TeamDiscussion("node").also { doInit(it, init) }
}

class TeamEdge(__name: String = "TeamEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: Team.() -> Unit) =
        Team("node").also { doInit(it, init) }
}

class TeamMemberConnection(__name: String = "TeamMemberConnection"): ObjectNode(__name) {
    fun edges(init: TeamMemberEdge.() -> Unit) =
        TeamMemberEdge("edges").also { doInit(it, init) }
    fun nodes(init: User.() -> Unit) =
        User("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class TeamMemberEdge(__name: String = "TeamMemberEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    val memberAccessResourcePath get() =
        ScalarNode("memberAccessResourcePath").also { doInit(it) }
    val memberAccessUrl get() =
        ScalarNode("memberAccessUrl").also { doInit(it) }
    fun node(init: User.() -> Unit) =
        User("node").also { doInit(it, init) }
    val role get() =
        ScalarNode("role").also { doInit(it) }
}

class TeamRemoveMemberAuditEntry(__name: String = "TeamRemoveMemberAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val isLdapMapped get() =
        ScalarNode("isLdapMapped").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun team(init: Team.() -> Unit) =
        Team("team").also { doInit(it, init) }
    val teamName get() =
        ScalarNode("teamName").also { doInit(it) }
    val teamResourcePath get() =
        ScalarNode("teamResourcePath").also { doInit(it) }
    val teamUrl get() =
        ScalarNode("teamUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class TeamRemoveRepositoryAuditEntry(__name: String = "TeamRemoveRepositoryAuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val isLdapMapped get() =
        ScalarNode("isLdapMapped").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val repositoryName get() =
        ScalarNode("repositoryName").also { doInit(it) }
    val repositoryResourcePath get() =
        ScalarNode("repositoryResourcePath").also { doInit(it) }
    val repositoryUrl get() =
        ScalarNode("repositoryUrl").also { doInit(it) }
    fun team(init: Team.() -> Unit) =
        Team("team").also { doInit(it, init) }
    val teamName get() =
        ScalarNode("teamName").also { doInit(it) }
    val teamResourcePath get() =
        ScalarNode("teamResourcePath").also { doInit(it) }
    val teamUrl get() =
        ScalarNode("teamUrl").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
}

class TeamRepositoryConnection(__name: String = "TeamRepositoryConnection"): ObjectNode(__name) {
    fun edges(init: TeamRepositoryEdge.() -> Unit) =
        TeamRepositoryEdge("edges").also { doInit(it, init) }
    fun nodes(init: Repository.() -> Unit) =
        Repository("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class TeamRepositoryEdge(__name: String = "TeamRepositoryEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: Repository.() -> Unit) =
        Repository("node").also { doInit(it, init) }
    val permission get() =
        ScalarNode("permission").also { doInit(it) }
}

class TextMatch(__name: String = "TextMatch"): ObjectNode(__name) {
    val fragment get() =
        ScalarNode("fragment").also { doInit(it) }
    fun highlights(init: TextMatchHighlight.() -> Unit) =
        TextMatchHighlight("highlights").also { doInit(it, init) }
    val property get() =
        ScalarNode("property").also { doInit(it) }
}

class TextMatchHighlight(__name: String = "TextMatchHighlight"): ObjectNode(__name) {
    val beginIndice get() =
        ScalarNode("beginIndice").also { doInit(it) }
    val endIndice get() =
        ScalarNode("endIndice").also { doInit(it) }
    val text get() =
        ScalarNode("text").also { doInit(it) }
}

class Topic(__name: String = "Topic"): ObjectNode(__name) {
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    fun relatedTopics(first: Int? = null, init: Topic.() -> Unit) =
        Topic("relatedTopics").apply { addArgs("first", first) }.also { doInit(it, init) }
    val stargazerCount get() =
        ScalarNode("stargazerCount").also { doInit(it) }
    fun stargazers(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: StarOrder? = null, init: StargazerConnection.() -> Unit) =
        StargazerConnection("stargazers").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    val viewerHasStarred get() =
        ScalarNode("viewerHasStarred").also { doInit(it) }
}

class TransferIssuePayload(__name: String = "TransferIssuePayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun issue(init: Issue.() -> Unit) =
        Issue("issue").also { doInit(it, init) }
}

class TransferredEvent(__name: String = "TransferredEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    fun fromRepository(init: Repository.() -> Unit) =
        Repository("fromRepository").also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun issue(init: Issue.() -> Unit) =
        Issue("issue").also { doInit(it, init) }
}

class Tree(__name: String = "Tree"): ObjectNode(__name) {
    val abbreviatedOid get() =
        ScalarNode("abbreviatedOid").also { doInit(it) }
    val commitResourcePath get() =
        ScalarNode("commitResourcePath").also { doInit(it) }
    val commitUrl get() =
        ScalarNode("commitUrl").also { doInit(it) }
    fun entries(init: TreeEntry.() -> Unit) =
        TreeEntry("entries").also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val oid get() =
        ScalarNode("oid").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
}

class TreeEntry(__name: String = "TreeEntry"): ObjectNode(__name) {
    val extension get() =
        ScalarNode("extension").also { doInit(it) }
    val isGenerated get() =
        ScalarNode("isGenerated").also { doInit(it) }
    val mode get() =
        ScalarNode("mode").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    fun `object`(init: GitObject.() -> Unit) =
        GitObject("object").also { doInit(it, init) }
    val oid get() =
        ScalarNode("oid").also { doInit(it) }
    val path get() =
        ScalarNode("path").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    fun submodule(init: Submodule.() -> Unit) =
        Submodule("submodule").also { doInit(it, init) }
    val type get() =
        ScalarNode("type").also { doInit(it) }
}

class UnarchiveRepositoryPayload(__name: String = "UnarchiveRepositoryPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
}

class UnassignedEvent(__name: String = "UnassignedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    fun assignable(init: Assignable.() -> Unit) =
        Assignable("assignable").also { doInit(it, init) }
    fun assignee(init: Assignee.() -> Unit) =
        Assignee("assignee").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    @Deprecated("Assignees can now be mannequins. Use the `assignee` field instead. Removal on 2020-01-01 UTC.")
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
}

class UnfollowUserPayload(__name: String = "UnfollowUserPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
}

class UnknownSignature(__name: String = "UnknownSignature"): ObjectNode(__name) {
    val email get() =
        ScalarNode("email").also { doInit(it) }
    val isValid get() =
        ScalarNode("isValid").also { doInit(it) }
    val payload get() =
        ScalarNode("payload").also { doInit(it) }
    val signature get() =
        ScalarNode("signature").also { doInit(it) }
    fun signer(init: User.() -> Unit) =
        User("signer").also { doInit(it, init) }
    val state get() =
        ScalarNode("state").also { doInit(it) }
    val wasSignedByGitHub get() =
        ScalarNode("wasSignedByGitHub").also { doInit(it) }
}

class UnlabeledEvent(__name: String = "UnlabeledEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun label(init: Label.() -> Unit) =
        Label("label").also { doInit(it, init) }
    fun labelable(init: Labelable.() -> Unit) =
        Labelable("labelable").also { doInit(it, init) }
}

class UnlinkRepositoryFromProjectPayload(__name: String = "UnlinkRepositoryFromProjectPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun project(init: Project.() -> Unit) =
        Project("project").also { doInit(it, init) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
}

class UnlockLockablePayload(__name: String = "UnlockLockablePayload"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun unlockedRecord(init: Lockable.() -> Unit) =
        Lockable("unlockedRecord").also { doInit(it, init) }
}

class UnlockedEvent(__name: String = "UnlockedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun lockable(init: Lockable.() -> Unit) =
        Lockable("lockable").also { doInit(it, init) }
}

class UnmarkFileAsViewedPayload(__name: String = "UnmarkFileAsViewedPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
}

class UnmarkIssueAsDuplicatePayload(__name: String = "UnmarkIssueAsDuplicatePayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun duplicate(init: IssueOrPullRequest.() -> Unit) =
        IssueOrPullRequest("duplicate").also { doInit(it, init) }
}

class UnmarkedAsDuplicateEvent(__name: String = "UnmarkedAsDuplicateEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    fun canonical(init: IssueOrPullRequest.() -> Unit) =
        IssueOrPullRequest("canonical").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    fun duplicate(init: IssueOrPullRequest.() -> Unit) =
        IssueOrPullRequest("duplicate").also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val isCrossRepository get() =
        ScalarNode("isCrossRepository").also { doInit(it) }
}

class UnminimizeCommentPayload(__name: String = "UnminimizeCommentPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun unminimizedComment(init: Minimizable.() -> Unit) =
        Minimizable("unminimizedComment").also { doInit(it, init) }
}

class UnpinIssuePayload(__name: String = "UnpinIssuePayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun issue(init: Issue.() -> Unit) =
        Issue("issue").also { doInit(it, init) }
}

class UnpinnedEvent(__name: String = "UnpinnedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun issue(init: Issue.() -> Unit) =
        Issue("issue").also { doInit(it, init) }
}

class UnresolveReviewThreadPayload(__name: String = "UnresolveReviewThreadPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun thread(init: PullRequestReviewThread.() -> Unit) =
        PullRequestReviewThread("thread").also { doInit(it, init) }
}

class UnsubscribedEvent(__name: String = "UnsubscribedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun subscribable(init: Subscribable.() -> Unit) =
        Subscribable("subscribable").also { doInit(it, init) }
}

class UpdateBranchProtectionRulePayload(__name: String = "UpdateBranchProtectionRulePayload"): ObjectNode(__name) {
    fun branchProtectionRule(init: BranchProtectionRule.() -> Unit) =
        BranchProtectionRule("branchProtectionRule").also { doInit(it, init) }
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
}

class UpdateCheckRunPayload(__name: String = "UpdateCheckRunPayload"): ObjectNode(__name) {
    fun checkRun(init: CheckRun.() -> Unit) =
        CheckRun("checkRun").also { doInit(it, init) }
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
}

class UpdateCheckSuitePreferencesPayload(__name: String = "UpdateCheckSuitePreferencesPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
}

class UpdateEnterpriseAdministratorRolePayload(__name: String = "UpdateEnterpriseAdministratorRolePayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    val message get() =
        ScalarNode("message").also { doInit(it) }
}

class UpdateEnterpriseAllowPrivateRepositoryForkingSettingPayload(__name: String = "UpdateEnterpriseAllowPrivateRepositoryForkingSettingPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun enterprise(init: Enterprise.() -> Unit) =
        Enterprise("enterprise").also { doInit(it, init) }
    val message get() =
        ScalarNode("message").also { doInit(it) }
}

class UpdateEnterpriseDefaultRepositoryPermissionSettingPayload(__name: String = "UpdateEnterpriseDefaultRepositoryPermissionSettingPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun enterprise(init: Enterprise.() -> Unit) =
        Enterprise("enterprise").also { doInit(it, init) }
    val message get() =
        ScalarNode("message").also { doInit(it) }
}

class UpdateEnterpriseMembersCanChangeRepositoryVisibilitySettingPayload(__name: String = "UpdateEnterpriseMembersCanChangeRepositoryVisibilitySettingPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun enterprise(init: Enterprise.() -> Unit) =
        Enterprise("enterprise").also { doInit(it, init) }
    val message get() =
        ScalarNode("message").also { doInit(it) }
}

class UpdateEnterpriseMembersCanCreateRepositoriesSettingPayload(__name: String = "UpdateEnterpriseMembersCanCreateRepositoriesSettingPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun enterprise(init: Enterprise.() -> Unit) =
        Enterprise("enterprise").also { doInit(it, init) }
    val message get() =
        ScalarNode("message").also { doInit(it) }
}

class UpdateEnterpriseMembersCanDeleteIssuesSettingPayload(__name: String = "UpdateEnterpriseMembersCanDeleteIssuesSettingPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun enterprise(init: Enterprise.() -> Unit) =
        Enterprise("enterprise").also { doInit(it, init) }
    val message get() =
        ScalarNode("message").also { doInit(it) }
}

class UpdateEnterpriseMembersCanDeleteRepositoriesSettingPayload(__name: String = "UpdateEnterpriseMembersCanDeleteRepositoriesSettingPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun enterprise(init: Enterprise.() -> Unit) =
        Enterprise("enterprise").also { doInit(it, init) }
    val message get() =
        ScalarNode("message").also { doInit(it) }
}

class UpdateEnterpriseMembersCanInviteCollaboratorsSettingPayload(__name: String = "UpdateEnterpriseMembersCanInviteCollaboratorsSettingPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun enterprise(init: Enterprise.() -> Unit) =
        Enterprise("enterprise").also { doInit(it, init) }
    val message get() =
        ScalarNode("message").also { doInit(it) }
}

class UpdateEnterpriseMembersCanMakePurchasesSettingPayload(__name: String = "UpdateEnterpriseMembersCanMakePurchasesSettingPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun enterprise(init: Enterprise.() -> Unit) =
        Enterprise("enterprise").also { doInit(it, init) }
    val message get() =
        ScalarNode("message").also { doInit(it) }
}

class UpdateEnterpriseMembersCanUpdateProtectedBranchesSettingPayload(__name: String = "UpdateEnterpriseMembersCanUpdateProtectedBranchesSettingPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun enterprise(init: Enterprise.() -> Unit) =
        Enterprise("enterprise").also { doInit(it, init) }
    val message get() =
        ScalarNode("message").also { doInit(it) }
}

class UpdateEnterpriseMembersCanViewDependencyInsightsSettingPayload(__name: String = "UpdateEnterpriseMembersCanViewDependencyInsightsSettingPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun enterprise(init: Enterprise.() -> Unit) =
        Enterprise("enterprise").also { doInit(it, init) }
    val message get() =
        ScalarNode("message").also { doInit(it) }
}

class UpdateEnterpriseOrganizationProjectsSettingPayload(__name: String = "UpdateEnterpriseOrganizationProjectsSettingPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun enterprise(init: Enterprise.() -> Unit) =
        Enterprise("enterprise").also { doInit(it, init) }
    val message get() =
        ScalarNode("message").also { doInit(it) }
}

class UpdateEnterpriseProfilePayload(__name: String = "UpdateEnterpriseProfilePayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun enterprise(init: Enterprise.() -> Unit) =
        Enterprise("enterprise").also { doInit(it, init) }
}

class UpdateEnterpriseRepositoryProjectsSettingPayload(__name: String = "UpdateEnterpriseRepositoryProjectsSettingPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun enterprise(init: Enterprise.() -> Unit) =
        Enterprise("enterprise").also { doInit(it, init) }
    val message get() =
        ScalarNode("message").also { doInit(it) }
}

class UpdateEnterpriseTeamDiscussionsSettingPayload(__name: String = "UpdateEnterpriseTeamDiscussionsSettingPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun enterprise(init: Enterprise.() -> Unit) =
        Enterprise("enterprise").also { doInit(it, init) }
    val message get() =
        ScalarNode("message").also { doInit(it) }
}

class UpdateEnterpriseTwoFactorAuthenticationRequiredSettingPayload(__name: String = "UpdateEnterpriseTwoFactorAuthenticationRequiredSettingPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun enterprise(init: Enterprise.() -> Unit) =
        Enterprise("enterprise").also { doInit(it, init) }
    val message get() =
        ScalarNode("message").also { doInit(it) }
}

class UpdateIpAllowListEnabledSettingPayload(__name: String = "UpdateIpAllowListEnabledSettingPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun owner(init: IpAllowListOwner.() -> Unit) =
        IpAllowListOwner("owner").also { doInit(it, init) }
}

class UpdateIpAllowListEntryPayload(__name: String = "UpdateIpAllowListEntryPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun ipAllowListEntry(init: IpAllowListEntry.() -> Unit) =
        IpAllowListEntry("ipAllowListEntry").also { doInit(it, init) }
}

class UpdateIssueCommentPayload(__name: String = "UpdateIssueCommentPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun issueComment(init: IssueComment.() -> Unit) =
        IssueComment("issueComment").also { doInit(it, init) }
}

class UpdateIssuePayload(__name: String = "UpdateIssuePayload"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun issue(init: Issue.() -> Unit) =
        Issue("issue").also { doInit(it, init) }
}

class UpdateLabelPayload(__name: String = "UpdateLabelPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun label(init: Label.() -> Unit) =
        Label("label").also { doInit(it, init) }
}

class UpdateProjectCardPayload(__name: String = "UpdateProjectCardPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun projectCard(init: ProjectCard.() -> Unit) =
        ProjectCard("projectCard").also { doInit(it, init) }
}

class UpdateProjectColumnPayload(__name: String = "UpdateProjectColumnPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun projectColumn(init: ProjectColumn.() -> Unit) =
        ProjectColumn("projectColumn").also { doInit(it, init) }
}

class UpdateProjectPayload(__name: String = "UpdateProjectPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun project(init: Project.() -> Unit) =
        Project("project").also { doInit(it, init) }
}

class UpdatePullRequestPayload(__name: String = "UpdatePullRequestPayload"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun pullRequest(init: PullRequest.() -> Unit) =
        PullRequest("pullRequest").also { doInit(it, init) }
}

class UpdatePullRequestReviewCommentPayload(__name: String = "UpdatePullRequestReviewCommentPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun pullRequestReviewComment(init: PullRequestReviewComment.() -> Unit) =
        PullRequestReviewComment("pullRequestReviewComment").also { doInit(it, init) }
}

class UpdatePullRequestReviewPayload(__name: String = "UpdatePullRequestReviewPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun pullRequestReview(init: PullRequestReview.() -> Unit) =
        PullRequestReview("pullRequestReview").also { doInit(it, init) }
}

class UpdateRefPayload(__name: String = "UpdateRefPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun ref(init: Ref.() -> Unit) =
        Ref("ref").also { doInit(it, init) }
}

class UpdateRefsPayload(__name: String = "UpdateRefsPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
}

class UpdateRepositoryPayload(__name: String = "UpdateRepositoryPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
}

class UpdateSubscriptionPayload(__name: String = "UpdateSubscriptionPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun subscribable(init: Subscribable.() -> Unit) =
        Subscribable("subscribable").also { doInit(it, init) }
}

class UpdateTeamDiscussionCommentPayload(__name: String = "UpdateTeamDiscussionCommentPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun teamDiscussionComment(init: TeamDiscussionComment.() -> Unit) =
        TeamDiscussionComment("teamDiscussionComment").also { doInit(it, init) }
}

class UpdateTeamDiscussionPayload(__name: String = "UpdateTeamDiscussionPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun teamDiscussion(init: TeamDiscussion.() -> Unit) =
        TeamDiscussion("teamDiscussion").also { doInit(it, init) }
}

class UpdateTeamReviewAssignmentPayload(__name: String = "UpdateTeamReviewAssignmentPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    fun team(init: Team.() -> Unit) =
        Team("team").also { doInit(it, init) }
}

class UpdateTopicsPayload(__name: String = "UpdateTopicsPayload"): ObjectNode(__name) {
    val clientMutationId get() =
        ScalarNode("clientMutationId").also { doInit(it) }
    val invalidTopicNames get() =
        ScalarNode("invalidTopicNames").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
}

class User(__name: String = "User"): ObjectNode(__name) {
    fun anyPinnableItems(type: PinnableItemType? = null) =
        ScalarWithArgsNode("anyPinnableItems", mapOf("type" to type)).also { doInit(it) }
    val anyPinnableItems get() =
        ScalarNode("anyPinnableItems").also { doInit(it) }
    fun avatarUrl(size: Int? = null) =
        ScalarWithArgsNode("avatarUrl", mapOf("size" to size)).also { doInit(it) }
    val avatarUrl get() =
        ScalarNode("avatarUrl").also { doInit(it) }
    val bio get() =
        ScalarNode("bio").also { doInit(it) }
    val bioHTML get() =
        ScalarNode("bioHTML").also { doInit(it) }
    fun commitComments(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: CommitCommentConnection.() -> Unit) =
        CommitCommentConnection("commitComments").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val company get() =
        ScalarNode("company").also { doInit(it) }
    val companyHTML get() =
        ScalarNode("companyHTML").also { doInit(it) }
    fun contributionsCollection(from: DateTime? = null, organizationID: ID? = null, to: DateTime? = null, init: ContributionsCollection.() -> Unit) =
        ContributionsCollection("contributionsCollection").apply { addArgs("from", from) }.apply { addArgs("organizationID", organizationID) }.apply { addArgs("to", to) }.also { doInit(it, init) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val email get() =
        ScalarNode("email").also { doInit(it) }
    fun followers(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: FollowerConnection.() -> Unit) =
        FollowerConnection("followers").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun following(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: FollowingConnection.() -> Unit) =
        FollowingConnection("following").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun gist(name: String, init: Gist.() -> Unit) =
        Gist("gist").apply { addArgs("name", name) }.also { doInit(it, init) }
    fun gistComments(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: GistCommentConnection.() -> Unit) =
        GistCommentConnection("gistComments").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun gists(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: GistOrder? = null, privacy: GistPrivacy? = null, init: GistConnection.() -> Unit) =
        GistConnection("gists").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("privacy", privacy) }.also { doInit(it, init) }
    fun hovercard(primarySubjectId: ID? = null, init: Hovercard.() -> Unit) =
        Hovercard("hovercard").apply { addArgs("primarySubjectId", primarySubjectId) }.also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val isBountyHunter get() =
        ScalarNode("isBountyHunter").also { doInit(it) }
    val isCampusExpert get() =
        ScalarNode("isCampusExpert").also { doInit(it) }
    val isDeveloperProgramMember get() =
        ScalarNode("isDeveloperProgramMember").also { doInit(it) }
    val isEmployee get() =
        ScalarNode("isEmployee").also { doInit(it) }
    val isHireable get() =
        ScalarNode("isHireable").also { doInit(it) }
    val isSiteAdmin get() =
        ScalarNode("isSiteAdmin").also { doInit(it) }
    val isViewer get() =
        ScalarNode("isViewer").also { doInit(it) }
    fun issueComments(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: IssueCommentConnection.() -> Unit) =
        IssueCommentConnection("issueComments").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun issues(after: String? = null, before: String? = null, filterBy: IssueFilters? = null, first: Int? = null, labels: String? = null, last: Int? = null, orderBy: IssueOrder? = null, states: IssueState? = null, init: IssueConnection.() -> Unit) =
        IssueConnection("issues").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("filterBy", filterBy) }.apply { addArgs("first", first) }.apply { addArgs("labels", labels) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("states", states) }.also { doInit(it, init) }
    fun itemShowcase(init: ProfileItemShowcase.() -> Unit) =
        ProfileItemShowcase("itemShowcase").also { doInit(it, init) }
    val location get() =
        ScalarNode("location").also { doInit(it) }
    val login get() =
        ScalarNode("login").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    fun organization(login: String, init: Organization.() -> Unit) =
        Organization("organization").apply { addArgs("login", login) }.also { doInit(it, init) }
    fun organizationVerifiedDomainEmails(login: String) =
        ScalarWithArgsNode("organizationVerifiedDomainEmails", mapOf("login" to login)).also { doInit(it) }
    fun organizations(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: OrganizationConnection.() -> Unit) =
        OrganizationConnection("organizations").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun packages(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, names: String? = null, orderBy: PackageOrder? = null, packageType: PackageType? = null, repositoryId: ID? = null, init: PackageConnection.() -> Unit) =
        PackageConnection("packages").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("names", names) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("packageType", packageType) }.apply { addArgs("repositoryId", repositoryId) }.also { doInit(it, init) }
    fun pinnableItems(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, types: PinnableItemType? = null, init: PinnableItemConnection.() -> Unit) =
        PinnableItemConnection("pinnableItems").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("types", types) }.also { doInit(it, init) }
    fun pinnedItems(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, types: PinnableItemType? = null, init: PinnableItemConnection.() -> Unit) =
        PinnableItemConnection("pinnedItems").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("types", types) }.also { doInit(it, init) }
    val pinnedItemsRemaining get() =
        ScalarNode("pinnedItemsRemaining").also { doInit(it) }
    fun project(number: Int, init: Project.() -> Unit) =
        Project("project").apply { addArgs("number", number) }.also { doInit(it, init) }
    fun projects(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: ProjectOrder? = null, search: String? = null, states: ProjectState? = null, init: ProjectConnection.() -> Unit) =
        ProjectConnection("projects").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("search", search) }.apply { addArgs("states", states) }.also { doInit(it, init) }
    val projectsResourcePath get() =
        ScalarNode("projectsResourcePath").also { doInit(it) }
    val projectsUrl get() =
        ScalarNode("projectsUrl").also { doInit(it) }
    fun publicKeys(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: PublicKeyConnection.() -> Unit) =
        PublicKeyConnection("publicKeys").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun pullRequests(after: String? = null, baseRefName: String? = null, before: String? = null, first: Int? = null, headRefName: String? = null, labels: String? = null, last: Int? = null, orderBy: IssueOrder? = null, states: PullRequestState? = null, init: PullRequestConnection.() -> Unit) =
        PullRequestConnection("pullRequests").apply { addArgs("after", after) }.apply { addArgs("baseRefName", baseRefName) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("headRefName", headRefName) }.apply { addArgs("labels", labels) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("states", states) }.also { doInit(it, init) }
    fun repositories(affiliations: RepositoryAffiliation? = null, after: String? = null, before: String? = null, first: Int? = null, isFork: Boolean? = null, isLocked: Boolean? = null, last: Int? = null, orderBy: RepositoryOrder? = null, ownerAffiliations: RepositoryAffiliation? = null, privacy: RepositoryPrivacy? = null, init: RepositoryConnection.() -> Unit) =
        RepositoryConnection("repositories").apply { addArgs("affiliations", affiliations) }.apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("isFork", isFork) }.apply { addArgs("isLocked", isLocked) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("ownerAffiliations", ownerAffiliations) }.apply { addArgs("privacy", privacy) }.also { doInit(it, init) }
    fun repositoriesContributedTo(after: String? = null, before: String? = null, contributionTypes: RepositoryContributionType? = null, first: Int? = null, includeUserRepositories: Boolean? = null, isLocked: Boolean? = null, last: Int? = null, orderBy: RepositoryOrder? = null, privacy: RepositoryPrivacy? = null, init: RepositoryConnection.() -> Unit) =
        RepositoryConnection("repositoriesContributedTo").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("contributionTypes", contributionTypes) }.apply { addArgs("first", first) }.apply { addArgs("includeUserRepositories", includeUserRepositories) }.apply { addArgs("isLocked", isLocked) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("privacy", privacy) }.also { doInit(it, init) }
    fun repository(name: String, init: Repository.() -> Unit) =
        Repository("repository").apply { addArgs("name", name) }.also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    fun savedReplies(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: SavedReplyOrder? = null, init: SavedReplyConnection.() -> Unit) =
        SavedReplyConnection("savedReplies").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun sponsorsListing(init: SponsorsListing.() -> Unit) =
        SponsorsListing("sponsorsListing").also { doInit(it, init) }
    fun sponsorshipsAsMaintainer(after: String? = null, before: String? = null, first: Int? = null, includePrivate: Boolean? = null, last: Int? = null, orderBy: SponsorshipOrder? = null, init: SponsorshipConnection.() -> Unit) =
        SponsorshipConnection("sponsorshipsAsMaintainer").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("includePrivate", includePrivate) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun sponsorshipsAsSponsor(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: SponsorshipOrder? = null, init: SponsorshipConnection.() -> Unit) =
        SponsorshipConnection("sponsorshipsAsSponsor").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun starredRepositories(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: StarOrder? = null, ownedByViewer: Boolean? = null, init: StarredRepositoryConnection.() -> Unit) =
        StarredRepositoryConnection("starredRepositories").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("ownedByViewer", ownedByViewer) }.also { doInit(it, init) }
    fun status(init: UserStatus.() -> Unit) =
        UserStatus("status").also { doInit(it, init) }
    fun topRepositories(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: RepositoryOrder, since: DateTime? = null, init: RepositoryConnection.() -> Unit) =
        RepositoryConnection("topRepositories").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("since", since) }.also { doInit(it, init) }
    val twitterUsername get() =
        ScalarNode("twitterUsername").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    val viewerCanChangePinnedItems get() =
        ScalarNode("viewerCanChangePinnedItems").also { doInit(it) }
    val viewerCanCreateProjects get() =
        ScalarNode("viewerCanCreateProjects").also { doInit(it) }
    val viewerCanFollow get() =
        ScalarNode("viewerCanFollow").also { doInit(it) }
    val viewerIsFollowing get() =
        ScalarNode("viewerIsFollowing").also { doInit(it) }
    fun watching(affiliations: RepositoryAffiliation? = null, after: String? = null, before: String? = null, first: Int? = null, isLocked: Boolean? = null, last: Int? = null, orderBy: RepositoryOrder? = null, ownerAffiliations: RepositoryAffiliation? = null, privacy: RepositoryPrivacy? = null, init: RepositoryConnection.() -> Unit) =
        RepositoryConnection("watching").apply { addArgs("affiliations", affiliations) }.apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("isLocked", isLocked) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("ownerAffiliations", ownerAffiliations) }.apply { addArgs("privacy", privacy) }.also { doInit(it, init) }
    val websiteUrl get() =
        ScalarNode("websiteUrl").also { doInit(it) }
}

class UserBlockedEvent(__name: String = "UserBlockedEvent"): ObjectNode(__name) {
    fun actor(init: Actor.() -> Unit) =
        Actor("actor").also { doInit(it, init) }
    val blockDuration get() =
        ScalarNode("blockDuration").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun subject(init: User.() -> Unit) =
        User("subject").also { doInit(it, init) }
}

class UserConnection(__name: String = "UserConnection"): ObjectNode(__name) {
    fun edges(init: UserEdge.() -> Unit) =
        UserEdge("edges").also { doInit(it, init) }
    fun nodes(init: User.() -> Unit) =
        User("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class UserContentEdit(__name: String = "UserContentEdit"): ObjectNode(__name) {
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val deletedAt get() =
        ScalarNode("deletedAt").also { doInit(it) }
    fun deletedBy(init: Actor.() -> Unit) =
        Actor("deletedBy").also { doInit(it, init) }
    val diff get() =
        ScalarNode("diff").also { doInit(it) }
    val editedAt get() =
        ScalarNode("editedAt").also { doInit(it) }
    fun editor(init: Actor.() -> Unit) =
        Actor("editor").also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
}

class UserContentEditConnection(__name: String = "UserContentEditConnection"): ObjectNode(__name) {
    fun edges(init: UserContentEditEdge.() -> Unit) =
        UserContentEditEdge("edges").also { doInit(it, init) }
    fun nodes(init: UserContentEdit.() -> Unit) =
        UserContentEdit("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class UserContentEditEdge(__name: String = "UserContentEditEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: UserContentEdit.() -> Unit) =
        UserContentEdit("node").also { doInit(it, init) }
}

class UserEdge(__name: String = "UserEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: User.() -> Unit) =
        User("node").also { doInit(it, init) }
}

class UserEmailMetadata(__name: String = "UserEmailMetadata"): ObjectNode(__name) {
    val primary get() =
        ScalarNode("primary").also { doInit(it) }
    val type get() =
        ScalarNode("type").also { doInit(it) }
    val value get() =
        ScalarNode("value").also { doInit(it) }
}

class UserStatus(__name: String = "UserStatus"): ObjectNode(__name) {
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val emoji get() =
        ScalarNode("emoji").also { doInit(it) }
    val emojiHTML get() =
        ScalarNode("emojiHTML").also { doInit(it) }
    val expiresAt get() =
        ScalarNode("expiresAt").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val indicatesLimitedAvailability get() =
        ScalarNode("indicatesLimitedAvailability").also { doInit(it) }
    val message get() =
        ScalarNode("message").also { doInit(it) }
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
}

class UserStatusConnection(__name: String = "UserStatusConnection"): ObjectNode(__name) {
    fun edges(init: UserStatusEdge.() -> Unit) =
        UserStatusEdge("edges").also { doInit(it, init) }
    fun nodes(init: UserStatus.() -> Unit) =
        UserStatus("nodes").also { doInit(it, init) }
    fun pageInfo(init: PageInfo.() -> Unit) =
        PageInfo("pageInfo").also { doInit(it, init) }
    val totalCount get() =
        ScalarNode("totalCount").also { doInit(it) }
}

class UserStatusEdge(__name: String = "UserStatusEdge"): ObjectNode(__name) {
    val cursor get() =
        ScalarNode("cursor").also { doInit(it) }
    fun node(init: UserStatus.() -> Unit) =
        UserStatus("node").also { doInit(it, init) }
}

class ViewerHovercardContext(__name: String = "ViewerHovercardContext"): ObjectNode(__name) {
    val message get() =
        ScalarNode("message").also { doInit(it) }
    val octicon get() =
        ScalarNode("octicon").also { doInit(it) }
    fun viewer(init: User.() -> Unit) =
        User("viewer").also { doInit(it, init) }
}

class Actor(__name: String = "Actor"): ObjectNode(__name) {
    fun avatarUrl(size: Int? = null) =
        ScalarWithArgsNode("avatarUrl", mapOf("size" to size)).also { doInit(it) }
    val avatarUrl get() =
        ScalarNode("avatarUrl").also { doInit(it) }
    val login get() =
        ScalarNode("login").also { doInit(it) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    fun `on Bot`(init: Bot.() -> Unit) =
        Bot("...on Bot").also { doInit(it, init) }
    fun `on EnterpriseUserAccount`(init: EnterpriseUserAccount.() -> Unit) =
        EnterpriseUserAccount("...on EnterpriseUserAccount").also { doInit(it, init) }
    fun `on Mannequin`(init: Mannequin.() -> Unit) =
        Mannequin("...on Mannequin").also { doInit(it, init) }
    fun `on Organization`(init: Organization.() -> Unit) =
        Organization("...on Organization").also { doInit(it, init) }
    fun `on User`(init: User.() -> Unit) =
        User("...on User").also { doInit(it, init) }
}

class Assignable(__name: String = "Assignable"): ObjectNode(__name) {
    fun assignees(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: UserConnection.() -> Unit) =
        UserConnection("assignees").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    fun `on Issue`(init: Issue.() -> Unit) =
        Issue("...on Issue").also { doInit(it, init) }
    fun `on PullRequest`(init: PullRequest.() -> Unit) =
        PullRequest("...on PullRequest").also { doInit(it, init) }
}

class AuditEntry(__name: String = "AuditEntry"): ObjectNode(__name) {
    val action get() =
        ScalarNode("action").also { doInit(it) }
    fun actor(init: AuditEntryActor.() -> Unit) =
        AuditEntryActor("actor").also { doInit(it, init) }
    val actorIp get() =
        ScalarNode("actorIp").also { doInit(it) }
    fun actorLocation(init: ActorLocation.() -> Unit) =
        ActorLocation("actorLocation").also { doInit(it, init) }
    val actorLogin get() =
        ScalarNode("actorLogin").also { doInit(it) }
    val actorResourcePath get() =
        ScalarNode("actorResourcePath").also { doInit(it) }
    val actorUrl get() =
        ScalarNode("actorUrl").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val operationType get() =
        ScalarNode("operationType").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    val userLogin get() =
        ScalarNode("userLogin").also { doInit(it) }
    val userResourcePath get() =
        ScalarNode("userResourcePath").also { doInit(it) }
    val userUrl get() =
        ScalarNode("userUrl").also { doInit(it) }
    fun `on MembersCanDeleteReposClearAuditEntry`(init: MembersCanDeleteReposClearAuditEntry.() -> Unit) =
        MembersCanDeleteReposClearAuditEntry("...on MembersCanDeleteReposClearAuditEntry").also { doInit(it, init) }
    fun `on MembersCanDeleteReposDisableAuditEntry`(init: MembersCanDeleteReposDisableAuditEntry.() -> Unit) =
        MembersCanDeleteReposDisableAuditEntry("...on MembersCanDeleteReposDisableAuditEntry").also { doInit(it, init) }
    fun `on MembersCanDeleteReposEnableAuditEntry`(init: MembersCanDeleteReposEnableAuditEntry.() -> Unit) =
        MembersCanDeleteReposEnableAuditEntry("...on MembersCanDeleteReposEnableAuditEntry").also { doInit(it, init) }
    fun `on OauthApplicationCreateAuditEntry`(init: OauthApplicationCreateAuditEntry.() -> Unit) =
        OauthApplicationCreateAuditEntry("...on OauthApplicationCreateAuditEntry").also { doInit(it, init) }
    fun `on OrgAddBillingManagerAuditEntry`(init: OrgAddBillingManagerAuditEntry.() -> Unit) =
        OrgAddBillingManagerAuditEntry("...on OrgAddBillingManagerAuditEntry").also { doInit(it, init) }
    fun `on OrgAddMemberAuditEntry`(init: OrgAddMemberAuditEntry.() -> Unit) =
        OrgAddMemberAuditEntry("...on OrgAddMemberAuditEntry").also { doInit(it, init) }
    fun `on OrgBlockUserAuditEntry`(init: OrgBlockUserAuditEntry.() -> Unit) =
        OrgBlockUserAuditEntry("...on OrgBlockUserAuditEntry").also { doInit(it, init) }
    fun `on OrgConfigDisableCollaboratorsOnlyAuditEntry`(init: OrgConfigDisableCollaboratorsOnlyAuditEntry.() -> Unit) =
        OrgConfigDisableCollaboratorsOnlyAuditEntry("...on OrgConfigDisableCollaboratorsOnlyAuditEntry").also { doInit(it, init) }
    fun `on OrgConfigEnableCollaboratorsOnlyAuditEntry`(init: OrgConfigEnableCollaboratorsOnlyAuditEntry.() -> Unit) =
        OrgConfigEnableCollaboratorsOnlyAuditEntry("...on OrgConfigEnableCollaboratorsOnlyAuditEntry").also { doInit(it, init) }
    fun `on OrgCreateAuditEntry`(init: OrgCreateAuditEntry.() -> Unit) =
        OrgCreateAuditEntry("...on OrgCreateAuditEntry").also { doInit(it, init) }
    fun `on OrgDisableOauthAppRestrictionsAuditEntry`(init: OrgDisableOauthAppRestrictionsAuditEntry.() -> Unit) =
        OrgDisableOauthAppRestrictionsAuditEntry("...on OrgDisableOauthAppRestrictionsAuditEntry").also { doInit(it, init) }
    fun `on OrgDisableSamlAuditEntry`(init: OrgDisableSamlAuditEntry.() -> Unit) =
        OrgDisableSamlAuditEntry("...on OrgDisableSamlAuditEntry").also { doInit(it, init) }
    fun `on OrgDisableTwoFactorRequirementAuditEntry`(init: OrgDisableTwoFactorRequirementAuditEntry.() -> Unit) =
        OrgDisableTwoFactorRequirementAuditEntry("...on OrgDisableTwoFactorRequirementAuditEntry").also { doInit(it, init) }
    fun `on OrgEnableOauthAppRestrictionsAuditEntry`(init: OrgEnableOauthAppRestrictionsAuditEntry.() -> Unit) =
        OrgEnableOauthAppRestrictionsAuditEntry("...on OrgEnableOauthAppRestrictionsAuditEntry").also { doInit(it, init) }
    fun `on OrgEnableSamlAuditEntry`(init: OrgEnableSamlAuditEntry.() -> Unit) =
        OrgEnableSamlAuditEntry("...on OrgEnableSamlAuditEntry").also { doInit(it, init) }
    fun `on OrgEnableTwoFactorRequirementAuditEntry`(init: OrgEnableTwoFactorRequirementAuditEntry.() -> Unit) =
        OrgEnableTwoFactorRequirementAuditEntry("...on OrgEnableTwoFactorRequirementAuditEntry").also { doInit(it, init) }
    fun `on OrgInviteMemberAuditEntry`(init: OrgInviteMemberAuditEntry.() -> Unit) =
        OrgInviteMemberAuditEntry("...on OrgInviteMemberAuditEntry").also { doInit(it, init) }
    fun `on OrgInviteToBusinessAuditEntry`(init: OrgInviteToBusinessAuditEntry.() -> Unit) =
        OrgInviteToBusinessAuditEntry("...on OrgInviteToBusinessAuditEntry").also { doInit(it, init) }
    fun `on OrgOauthAppAccessApprovedAuditEntry`(init: OrgOauthAppAccessApprovedAuditEntry.() -> Unit) =
        OrgOauthAppAccessApprovedAuditEntry("...on OrgOauthAppAccessApprovedAuditEntry").also { doInit(it, init) }
    fun `on OrgOauthAppAccessDeniedAuditEntry`(init: OrgOauthAppAccessDeniedAuditEntry.() -> Unit) =
        OrgOauthAppAccessDeniedAuditEntry("...on OrgOauthAppAccessDeniedAuditEntry").also { doInit(it, init) }
    fun `on OrgOauthAppAccessRequestedAuditEntry`(init: OrgOauthAppAccessRequestedAuditEntry.() -> Unit) =
        OrgOauthAppAccessRequestedAuditEntry("...on OrgOauthAppAccessRequestedAuditEntry").also { doInit(it, init) }
    fun `on OrgRemoveBillingManagerAuditEntry`(init: OrgRemoveBillingManagerAuditEntry.() -> Unit) =
        OrgRemoveBillingManagerAuditEntry("...on OrgRemoveBillingManagerAuditEntry").also { doInit(it, init) }
    fun `on OrgRemoveMemberAuditEntry`(init: OrgRemoveMemberAuditEntry.() -> Unit) =
        OrgRemoveMemberAuditEntry("...on OrgRemoveMemberAuditEntry").also { doInit(it, init) }
    fun `on OrgRemoveOutsideCollaboratorAuditEntry`(init: OrgRemoveOutsideCollaboratorAuditEntry.() -> Unit) =
        OrgRemoveOutsideCollaboratorAuditEntry("...on OrgRemoveOutsideCollaboratorAuditEntry").also { doInit(it, init) }
    fun `on OrgRestoreMemberAuditEntry`(init: OrgRestoreMemberAuditEntry.() -> Unit) =
        OrgRestoreMemberAuditEntry("...on OrgRestoreMemberAuditEntry").also { doInit(it, init) }
    fun `on OrgUnblockUserAuditEntry`(init: OrgUnblockUserAuditEntry.() -> Unit) =
        OrgUnblockUserAuditEntry("...on OrgUnblockUserAuditEntry").also { doInit(it, init) }
    fun `on OrgUpdateDefaultRepositoryPermissionAuditEntry`(init: OrgUpdateDefaultRepositoryPermissionAuditEntry.() -> Unit) =
        OrgUpdateDefaultRepositoryPermissionAuditEntry("...on OrgUpdateDefaultRepositoryPermissionAuditEntry").also { doInit(it, init) }
    fun `on OrgUpdateMemberAuditEntry`(init: OrgUpdateMemberAuditEntry.() -> Unit) =
        OrgUpdateMemberAuditEntry("...on OrgUpdateMemberAuditEntry").also { doInit(it, init) }
    fun `on OrgUpdateMemberRepositoryCreationPermissionAuditEntry`(init: OrgUpdateMemberRepositoryCreationPermissionAuditEntry.() -> Unit) =
        OrgUpdateMemberRepositoryCreationPermissionAuditEntry("...on OrgUpdateMemberRepositoryCreationPermissionAuditEntry").also { doInit(it, init) }
    fun `on OrgUpdateMemberRepositoryInvitationPermissionAuditEntry`(init: OrgUpdateMemberRepositoryInvitationPermissionAuditEntry.() -> Unit) =
        OrgUpdateMemberRepositoryInvitationPermissionAuditEntry("...on OrgUpdateMemberRepositoryInvitationPermissionAuditEntry").also { doInit(it, init) }
    fun `on PrivateRepositoryForkingDisableAuditEntry`(init: PrivateRepositoryForkingDisableAuditEntry.() -> Unit) =
        PrivateRepositoryForkingDisableAuditEntry("...on PrivateRepositoryForkingDisableAuditEntry").also { doInit(it, init) }
    fun `on PrivateRepositoryForkingEnableAuditEntry`(init: PrivateRepositoryForkingEnableAuditEntry.() -> Unit) =
        PrivateRepositoryForkingEnableAuditEntry("...on PrivateRepositoryForkingEnableAuditEntry").also { doInit(it, init) }
    fun `on RepoAccessAuditEntry`(init: RepoAccessAuditEntry.() -> Unit) =
        RepoAccessAuditEntry("...on RepoAccessAuditEntry").also { doInit(it, init) }
    fun `on RepoAddMemberAuditEntry`(init: RepoAddMemberAuditEntry.() -> Unit) =
        RepoAddMemberAuditEntry("...on RepoAddMemberAuditEntry").also { doInit(it, init) }
    fun `on RepoAddTopicAuditEntry`(init: RepoAddTopicAuditEntry.() -> Unit) =
        RepoAddTopicAuditEntry("...on RepoAddTopicAuditEntry").also { doInit(it, init) }
    fun `on RepoArchivedAuditEntry`(init: RepoArchivedAuditEntry.() -> Unit) =
        RepoArchivedAuditEntry("...on RepoArchivedAuditEntry").also { doInit(it, init) }
    fun `on RepoChangeMergeSettingAuditEntry`(init: RepoChangeMergeSettingAuditEntry.() -> Unit) =
        RepoChangeMergeSettingAuditEntry("...on RepoChangeMergeSettingAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigDisableAnonymousGitAccessAuditEntry`(init: RepoConfigDisableAnonymousGitAccessAuditEntry.() -> Unit) =
        RepoConfigDisableAnonymousGitAccessAuditEntry("...on RepoConfigDisableAnonymousGitAccessAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigDisableCollaboratorsOnlyAuditEntry`(init: RepoConfigDisableCollaboratorsOnlyAuditEntry.() -> Unit) =
        RepoConfigDisableCollaboratorsOnlyAuditEntry("...on RepoConfigDisableCollaboratorsOnlyAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigDisableContributorsOnlyAuditEntry`(init: RepoConfigDisableContributorsOnlyAuditEntry.() -> Unit) =
        RepoConfigDisableContributorsOnlyAuditEntry("...on RepoConfigDisableContributorsOnlyAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigDisableSockpuppetDisallowedAuditEntry`(init: RepoConfigDisableSockpuppetDisallowedAuditEntry.() -> Unit) =
        RepoConfigDisableSockpuppetDisallowedAuditEntry("...on RepoConfigDisableSockpuppetDisallowedAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigEnableAnonymousGitAccessAuditEntry`(init: RepoConfigEnableAnonymousGitAccessAuditEntry.() -> Unit) =
        RepoConfigEnableAnonymousGitAccessAuditEntry("...on RepoConfigEnableAnonymousGitAccessAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigEnableCollaboratorsOnlyAuditEntry`(init: RepoConfigEnableCollaboratorsOnlyAuditEntry.() -> Unit) =
        RepoConfigEnableCollaboratorsOnlyAuditEntry("...on RepoConfigEnableCollaboratorsOnlyAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigEnableContributorsOnlyAuditEntry`(init: RepoConfigEnableContributorsOnlyAuditEntry.() -> Unit) =
        RepoConfigEnableContributorsOnlyAuditEntry("...on RepoConfigEnableContributorsOnlyAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigEnableSockpuppetDisallowedAuditEntry`(init: RepoConfigEnableSockpuppetDisallowedAuditEntry.() -> Unit) =
        RepoConfigEnableSockpuppetDisallowedAuditEntry("...on RepoConfigEnableSockpuppetDisallowedAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigLockAnonymousGitAccessAuditEntry`(init: RepoConfigLockAnonymousGitAccessAuditEntry.() -> Unit) =
        RepoConfigLockAnonymousGitAccessAuditEntry("...on RepoConfigLockAnonymousGitAccessAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigUnlockAnonymousGitAccessAuditEntry`(init: RepoConfigUnlockAnonymousGitAccessAuditEntry.() -> Unit) =
        RepoConfigUnlockAnonymousGitAccessAuditEntry("...on RepoConfigUnlockAnonymousGitAccessAuditEntry").also { doInit(it, init) }
    fun `on RepoCreateAuditEntry`(init: RepoCreateAuditEntry.() -> Unit) =
        RepoCreateAuditEntry("...on RepoCreateAuditEntry").also { doInit(it, init) }
    fun `on RepoDestroyAuditEntry`(init: RepoDestroyAuditEntry.() -> Unit) =
        RepoDestroyAuditEntry("...on RepoDestroyAuditEntry").also { doInit(it, init) }
    fun `on RepoRemoveMemberAuditEntry`(init: RepoRemoveMemberAuditEntry.() -> Unit) =
        RepoRemoveMemberAuditEntry("...on RepoRemoveMemberAuditEntry").also { doInit(it, init) }
    fun `on RepoRemoveTopicAuditEntry`(init: RepoRemoveTopicAuditEntry.() -> Unit) =
        RepoRemoveTopicAuditEntry("...on RepoRemoveTopicAuditEntry").also { doInit(it, init) }
    fun `on RepositoryVisibilityChangeDisableAuditEntry`(init: RepositoryVisibilityChangeDisableAuditEntry.() -> Unit) =
        RepositoryVisibilityChangeDisableAuditEntry("...on RepositoryVisibilityChangeDisableAuditEntry").also { doInit(it, init) }
    fun `on RepositoryVisibilityChangeEnableAuditEntry`(init: RepositoryVisibilityChangeEnableAuditEntry.() -> Unit) =
        RepositoryVisibilityChangeEnableAuditEntry("...on RepositoryVisibilityChangeEnableAuditEntry").also { doInit(it, init) }
    fun `on TeamAddMemberAuditEntry`(init: TeamAddMemberAuditEntry.() -> Unit) =
        TeamAddMemberAuditEntry("...on TeamAddMemberAuditEntry").also { doInit(it, init) }
    fun `on TeamAddRepositoryAuditEntry`(init: TeamAddRepositoryAuditEntry.() -> Unit) =
        TeamAddRepositoryAuditEntry("...on TeamAddRepositoryAuditEntry").also { doInit(it, init) }
    fun `on TeamChangeParentTeamAuditEntry`(init: TeamChangeParentTeamAuditEntry.() -> Unit) =
        TeamChangeParentTeamAuditEntry("...on TeamChangeParentTeamAuditEntry").also { doInit(it, init) }
    fun `on TeamRemoveMemberAuditEntry`(init: TeamRemoveMemberAuditEntry.() -> Unit) =
        TeamRemoveMemberAuditEntry("...on TeamRemoveMemberAuditEntry").also { doInit(it, init) }
    fun `on TeamRemoveRepositoryAuditEntry`(init: TeamRemoveRepositoryAuditEntry.() -> Unit) =
        TeamRemoveRepositoryAuditEntry("...on TeamRemoveRepositoryAuditEntry").also { doInit(it, init) }
}

class Closable(__name: String = "Closable"): ObjectNode(__name) {
    val closed get() =
        ScalarNode("closed").also { doInit(it) }
    val closedAt get() =
        ScalarNode("closedAt").also { doInit(it) }
    fun `on Issue`(init: Issue.() -> Unit) =
        Issue("...on Issue").also { doInit(it, init) }
    fun `on Milestone`(init: Milestone.() -> Unit) =
        Milestone("...on Milestone").also { doInit(it, init) }
    fun `on Project`(init: Project.() -> Unit) =
        Project("...on Project").also { doInit(it, init) }
    fun `on PullRequest`(init: PullRequest.() -> Unit) =
        PullRequest("...on PullRequest").also { doInit(it, init) }
}

class Comment(__name: String = "Comment"): ObjectNode(__name) {
    fun author(init: Actor.() -> Unit) =
        Actor("author").also { doInit(it, init) }
    val authorAssociation get() =
        ScalarNode("authorAssociation").also { doInit(it) }
    val body get() =
        ScalarNode("body").also { doInit(it) }
    val bodyHTML get() =
        ScalarNode("bodyHTML").also { doInit(it) }
    val bodyText get() =
        ScalarNode("bodyText").also { doInit(it) }
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val createdViaEmail get() =
        ScalarNode("createdViaEmail").also { doInit(it) }
    fun editor(init: Actor.() -> Unit) =
        Actor("editor").also { doInit(it, init) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val includesCreatedEdit get() =
        ScalarNode("includesCreatedEdit").also { doInit(it) }
    val lastEditedAt get() =
        ScalarNode("lastEditedAt").also { doInit(it) }
    val publishedAt get() =
        ScalarNode("publishedAt").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    fun userContentEdits(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, init: UserContentEditConnection.() -> Unit) =
        UserContentEditConnection("userContentEdits").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.also { doInit(it, init) }
    val viewerDidAuthor get() =
        ScalarNode("viewerDidAuthor").also { doInit(it) }
    fun `on CommitComment`(init: CommitComment.() -> Unit) =
        CommitComment("...on CommitComment").also { doInit(it, init) }
    fun `on GistComment`(init: GistComment.() -> Unit) =
        GistComment("...on GistComment").also { doInit(it, init) }
    fun `on Issue`(init: Issue.() -> Unit) =
        Issue("...on Issue").also { doInit(it, init) }
    fun `on IssueComment`(init: IssueComment.() -> Unit) =
        IssueComment("...on IssueComment").also { doInit(it, init) }
    fun `on PullRequest`(init: PullRequest.() -> Unit) =
        PullRequest("...on PullRequest").also { doInit(it, init) }
    fun `on PullRequestReview`(init: PullRequestReview.() -> Unit) =
        PullRequestReview("...on PullRequestReview").also { doInit(it, init) }
    fun `on PullRequestReviewComment`(init: PullRequestReviewComment.() -> Unit) =
        PullRequestReviewComment("...on PullRequestReviewComment").also { doInit(it, init) }
    fun `on TeamDiscussion`(init: TeamDiscussion.() -> Unit) =
        TeamDiscussion("...on TeamDiscussion").also { doInit(it, init) }
    fun `on TeamDiscussionComment`(init: TeamDiscussionComment.() -> Unit) =
        TeamDiscussionComment("...on TeamDiscussionComment").also { doInit(it, init) }
}

class Contribution(__name: String = "Contribution"): ObjectNode(__name) {
    val isRestricted get() =
        ScalarNode("isRestricted").also { doInit(it) }
    val occurredAt get() =
        ScalarNode("occurredAt").also { doInit(it) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    fun user(init: User.() -> Unit) =
        User("user").also { doInit(it, init) }
    fun `on CreatedCommitContribution`(init: CreatedCommitContribution.() -> Unit) =
        CreatedCommitContribution("...on CreatedCommitContribution").also { doInit(it, init) }
    fun `on CreatedIssueContribution`(init: CreatedIssueContribution.() -> Unit) =
        CreatedIssueContribution("...on CreatedIssueContribution").also { doInit(it, init) }
    fun `on CreatedPullRequestContribution`(init: CreatedPullRequestContribution.() -> Unit) =
        CreatedPullRequestContribution("...on CreatedPullRequestContribution").also { doInit(it, init) }
    fun `on CreatedPullRequestReviewContribution`(init: CreatedPullRequestReviewContribution.() -> Unit) =
        CreatedPullRequestReviewContribution("...on CreatedPullRequestReviewContribution").also { doInit(it, init) }
    fun `on CreatedRepositoryContribution`(init: CreatedRepositoryContribution.() -> Unit) =
        CreatedRepositoryContribution("...on CreatedRepositoryContribution").also { doInit(it, init) }
    fun `on JoinedGitHubContribution`(init: JoinedGitHubContribution.() -> Unit) =
        JoinedGitHubContribution("...on JoinedGitHubContribution").also { doInit(it, init) }
    fun `on RestrictedContribution`(init: RestrictedContribution.() -> Unit) =
        RestrictedContribution("...on RestrictedContribution").also { doInit(it, init) }
}

class Deletable(__name: String = "Deletable"): ObjectNode(__name) {
    val viewerCanDelete get() =
        ScalarNode("viewerCanDelete").also { doInit(it) }
    fun `on CommitComment`(init: CommitComment.() -> Unit) =
        CommitComment("...on CommitComment").also { doInit(it, init) }
    fun `on GistComment`(init: GistComment.() -> Unit) =
        GistComment("...on GistComment").also { doInit(it, init) }
    fun `on IssueComment`(init: IssueComment.() -> Unit) =
        IssueComment("...on IssueComment").also { doInit(it, init) }
    fun `on PullRequestReview`(init: PullRequestReview.() -> Unit) =
        PullRequestReview("...on PullRequestReview").also { doInit(it, init) }
    fun `on PullRequestReviewComment`(init: PullRequestReviewComment.() -> Unit) =
        PullRequestReviewComment("...on PullRequestReviewComment").also { doInit(it, init) }
    fun `on TeamDiscussion`(init: TeamDiscussion.() -> Unit) =
        TeamDiscussion("...on TeamDiscussion").also { doInit(it, init) }
    fun `on TeamDiscussionComment`(init: TeamDiscussionComment.() -> Unit) =
        TeamDiscussionComment("...on TeamDiscussionComment").also { doInit(it, init) }
}

class EnterpriseAuditEntryData(__name: String = "EnterpriseAuditEntryData"): ObjectNode(__name) {
    val enterpriseResourcePath get() =
        ScalarNode("enterpriseResourcePath").also { doInit(it) }
    val enterpriseSlug get() =
        ScalarNode("enterpriseSlug").also { doInit(it) }
    val enterpriseUrl get() =
        ScalarNode("enterpriseUrl").also { doInit(it) }
    fun `on MembersCanDeleteReposClearAuditEntry`(init: MembersCanDeleteReposClearAuditEntry.() -> Unit) =
        MembersCanDeleteReposClearAuditEntry("...on MembersCanDeleteReposClearAuditEntry").also { doInit(it, init) }
    fun `on MembersCanDeleteReposDisableAuditEntry`(init: MembersCanDeleteReposDisableAuditEntry.() -> Unit) =
        MembersCanDeleteReposDisableAuditEntry("...on MembersCanDeleteReposDisableAuditEntry").also { doInit(it, init) }
    fun `on MembersCanDeleteReposEnableAuditEntry`(init: MembersCanDeleteReposEnableAuditEntry.() -> Unit) =
        MembersCanDeleteReposEnableAuditEntry("...on MembersCanDeleteReposEnableAuditEntry").also { doInit(it, init) }
    fun `on OrgInviteToBusinessAuditEntry`(init: OrgInviteToBusinessAuditEntry.() -> Unit) =
        OrgInviteToBusinessAuditEntry("...on OrgInviteToBusinessAuditEntry").also { doInit(it, init) }
    fun `on PrivateRepositoryForkingDisableAuditEntry`(init: PrivateRepositoryForkingDisableAuditEntry.() -> Unit) =
        PrivateRepositoryForkingDisableAuditEntry("...on PrivateRepositoryForkingDisableAuditEntry").also { doInit(it, init) }
    fun `on PrivateRepositoryForkingEnableAuditEntry`(init: PrivateRepositoryForkingEnableAuditEntry.() -> Unit) =
        PrivateRepositoryForkingEnableAuditEntry("...on PrivateRepositoryForkingEnableAuditEntry").also { doInit(it, init) }
    fun `on RepositoryVisibilityChangeDisableAuditEntry`(init: RepositoryVisibilityChangeDisableAuditEntry.() -> Unit) =
        RepositoryVisibilityChangeDisableAuditEntry("...on RepositoryVisibilityChangeDisableAuditEntry").also { doInit(it, init) }
    fun `on RepositoryVisibilityChangeEnableAuditEntry`(init: RepositoryVisibilityChangeEnableAuditEntry.() -> Unit) =
        RepositoryVisibilityChangeEnableAuditEntry("...on RepositoryVisibilityChangeEnableAuditEntry").also { doInit(it, init) }
}

class GitObject(__name: String = "GitObject"): ObjectNode(__name) {
    val abbreviatedOid get() =
        ScalarNode("abbreviatedOid").also { doInit(it) }
    val commitResourcePath get() =
        ScalarNode("commitResourcePath").also { doInit(it) }
    val commitUrl get() =
        ScalarNode("commitUrl").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val oid get() =
        ScalarNode("oid").also { doInit(it) }
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    fun `on Blob`(init: Blob.() -> Unit) =
        Blob("...on Blob").also { doInit(it, init) }
    fun `on Commit`(init: Commit.() -> Unit) =
        Commit("...on Commit").also { doInit(it, init) }
    fun `on Tag`(init: Tag.() -> Unit) =
        Tag("...on Tag").also { doInit(it, init) }
    fun `on Tree`(init: Tree.() -> Unit) =
        Tree("...on Tree").also { doInit(it, init) }
}

class GitSignature(__name: String = "GitSignature"): ObjectNode(__name) {
    val email get() =
        ScalarNode("email").also { doInit(it) }
    val isValid get() =
        ScalarNode("isValid").also { doInit(it) }
    val payload get() =
        ScalarNode("payload").also { doInit(it) }
    val signature get() =
        ScalarNode("signature").also { doInit(it) }
    fun signer(init: User.() -> Unit) =
        User("signer").also { doInit(it, init) }
    val state get() =
        ScalarNode("state").also { doInit(it) }
    val wasSignedByGitHub get() =
        ScalarNode("wasSignedByGitHub").also { doInit(it) }
    fun `on GpgSignature`(init: GpgSignature.() -> Unit) =
        GpgSignature("...on GpgSignature").also { doInit(it, init) }
    fun `on SmimeSignature`(init: SmimeSignature.() -> Unit) =
        SmimeSignature("...on SmimeSignature").also { doInit(it, init) }
    fun `on UnknownSignature`(init: UnknownSignature.() -> Unit) =
        UnknownSignature("...on UnknownSignature").also { doInit(it, init) }
}

class HovercardContext(__name: String = "HovercardContext"): ObjectNode(__name) {
    val message get() =
        ScalarNode("message").also { doInit(it) }
    val octicon get() =
        ScalarNode("octicon").also { doInit(it) }
    fun `on GenericHovercardContext`(init: GenericHovercardContext.() -> Unit) =
        GenericHovercardContext("...on GenericHovercardContext").also { doInit(it, init) }
    fun `on OrganizationTeamsHovercardContext`(init: OrganizationTeamsHovercardContext.() -> Unit) =
        OrganizationTeamsHovercardContext("...on OrganizationTeamsHovercardContext").also { doInit(it, init) }
    fun `on OrganizationsHovercardContext`(init: OrganizationsHovercardContext.() -> Unit) =
        OrganizationsHovercardContext("...on OrganizationsHovercardContext").also { doInit(it, init) }
    fun `on ReviewStatusHovercardContext`(init: ReviewStatusHovercardContext.() -> Unit) =
        ReviewStatusHovercardContext("...on ReviewStatusHovercardContext").also { doInit(it, init) }
    fun `on ViewerHovercardContext`(init: ViewerHovercardContext.() -> Unit) =
        ViewerHovercardContext("...on ViewerHovercardContext").also { doInit(it, init) }
}

class Labelable(__name: String = "Labelable"): ObjectNode(__name) {
    fun labels(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: LabelOrder? = null, init: LabelConnection.() -> Unit) =
        LabelConnection("labels").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun `on Issue`(init: Issue.() -> Unit) =
        Issue("...on Issue").also { doInit(it, init) }
    fun `on PullRequest`(init: PullRequest.() -> Unit) =
        PullRequest("...on PullRequest").also { doInit(it, init) }
}

class Lockable(__name: String = "Lockable"): ObjectNode(__name) {
    val activeLockReason get() =
        ScalarNode("activeLockReason").also { doInit(it) }
    val locked get() =
        ScalarNode("locked").also { doInit(it) }
    fun `on Issue`(init: Issue.() -> Unit) =
        Issue("...on Issue").also { doInit(it, init) }
    fun `on PullRequest`(init: PullRequest.() -> Unit) =
        PullRequest("...on PullRequest").also { doInit(it, init) }
}

class MemberStatusable(__name: String = "MemberStatusable"): ObjectNode(__name) {
    fun memberStatuses(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: UserStatusOrder? = null, init: UserStatusConnection.() -> Unit) =
        UserStatusConnection("memberStatuses").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun `on Organization`(init: Organization.() -> Unit) =
        Organization("...on Organization").also { doInit(it, init) }
    fun `on Team`(init: Team.() -> Unit) =
        Team("...on Team").also { doInit(it, init) }
}

class Minimizable(__name: String = "Minimizable"): ObjectNode(__name) {
    val isMinimized get() =
        ScalarNode("isMinimized").also { doInit(it) }
    val minimizedReason get() =
        ScalarNode("minimizedReason").also { doInit(it) }
    val viewerCanMinimize get() =
        ScalarNode("viewerCanMinimize").also { doInit(it) }
    fun `on CommitComment`(init: CommitComment.() -> Unit) =
        CommitComment("...on CommitComment").also { doInit(it, init) }
    fun `on GistComment`(init: GistComment.() -> Unit) =
        GistComment("...on GistComment").also { doInit(it, init) }
    fun `on IssueComment`(init: IssueComment.() -> Unit) =
        IssueComment("...on IssueComment").also { doInit(it, init) }
    fun `on PullRequestReviewComment`(init: PullRequestReviewComment.() -> Unit) =
        PullRequestReviewComment("...on PullRequestReviewComment").also { doInit(it, init) }
}

class Node(__name: String = "Node"): ObjectNode(__name) {
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun `on AddedToProjectEvent`(init: AddedToProjectEvent.() -> Unit) =
        AddedToProjectEvent("...on AddedToProjectEvent").also { doInit(it, init) }
    fun `on App`(init: App.() -> Unit) =
        App("...on App").also { doInit(it, init) }
    fun `on AssignedEvent`(init: AssignedEvent.() -> Unit) =
        AssignedEvent("...on AssignedEvent").also { doInit(it, init) }
    fun `on AutomaticBaseChangeFailedEvent`(init: AutomaticBaseChangeFailedEvent.() -> Unit) =
        AutomaticBaseChangeFailedEvent("...on AutomaticBaseChangeFailedEvent").also { doInit(it, init) }
    fun `on AutomaticBaseChangeSucceededEvent`(init: AutomaticBaseChangeSucceededEvent.() -> Unit) =
        AutomaticBaseChangeSucceededEvent("...on AutomaticBaseChangeSucceededEvent").also { doInit(it, init) }
    fun `on BaseRefChangedEvent`(init: BaseRefChangedEvent.() -> Unit) =
        BaseRefChangedEvent("...on BaseRefChangedEvent").also { doInit(it, init) }
    fun `on BaseRefDeletedEvent`(init: BaseRefDeletedEvent.() -> Unit) =
        BaseRefDeletedEvent("...on BaseRefDeletedEvent").also { doInit(it, init) }
    fun `on BaseRefForcePushedEvent`(init: BaseRefForcePushedEvent.() -> Unit) =
        BaseRefForcePushedEvent("...on BaseRefForcePushedEvent").also { doInit(it, init) }
    fun `on Blob`(init: Blob.() -> Unit) =
        Blob("...on Blob").also { doInit(it, init) }
    fun `on Bot`(init: Bot.() -> Unit) =
        Bot("...on Bot").also { doInit(it, init) }
    fun `on BranchProtectionRule`(init: BranchProtectionRule.() -> Unit) =
        BranchProtectionRule("...on BranchProtectionRule").also { doInit(it, init) }
    fun `on CheckRun`(init: CheckRun.() -> Unit) =
        CheckRun("...on CheckRun").also { doInit(it, init) }
    fun `on CheckSuite`(init: CheckSuite.() -> Unit) =
        CheckSuite("...on CheckSuite").also { doInit(it, init) }
    fun `on ClosedEvent`(init: ClosedEvent.() -> Unit) =
        ClosedEvent("...on ClosedEvent").also { doInit(it, init) }
    fun `on CodeOfConduct`(init: CodeOfConduct.() -> Unit) =
        CodeOfConduct("...on CodeOfConduct").also { doInit(it, init) }
    fun `on CommentDeletedEvent`(init: CommentDeletedEvent.() -> Unit) =
        CommentDeletedEvent("...on CommentDeletedEvent").also { doInit(it, init) }
    fun `on Commit`(init: Commit.() -> Unit) =
        Commit("...on Commit").also { doInit(it, init) }
    fun `on CommitComment`(init: CommitComment.() -> Unit) =
        CommitComment("...on CommitComment").also { doInit(it, init) }
    fun `on CommitCommentThread`(init: CommitCommentThread.() -> Unit) =
        CommitCommentThread("...on CommitCommentThread").also { doInit(it, init) }
    fun `on ConnectedEvent`(init: ConnectedEvent.() -> Unit) =
        ConnectedEvent("...on ConnectedEvent").also { doInit(it, init) }
    fun `on ConvertToDraftEvent`(init: ConvertToDraftEvent.() -> Unit) =
        ConvertToDraftEvent("...on ConvertToDraftEvent").also { doInit(it, init) }
    fun `on ConvertedNoteToIssueEvent`(init: ConvertedNoteToIssueEvent.() -> Unit) =
        ConvertedNoteToIssueEvent("...on ConvertedNoteToIssueEvent").also { doInit(it, init) }
    fun `on CrossReferencedEvent`(init: CrossReferencedEvent.() -> Unit) =
        CrossReferencedEvent("...on CrossReferencedEvent").also { doInit(it, init) }
    fun `on DemilestonedEvent`(init: DemilestonedEvent.() -> Unit) =
        DemilestonedEvent("...on DemilestonedEvent").also { doInit(it, init) }
    fun `on DependencyGraphManifest`(init: DependencyGraphManifest.() -> Unit) =
        DependencyGraphManifest("...on DependencyGraphManifest").also { doInit(it, init) }
    fun `on DeployKey`(init: DeployKey.() -> Unit) =
        DeployKey("...on DeployKey").also { doInit(it, init) }
    fun `on DeployedEvent`(init: DeployedEvent.() -> Unit) =
        DeployedEvent("...on DeployedEvent").also { doInit(it, init) }
    fun `on Deployment`(init: Deployment.() -> Unit) =
        Deployment("...on Deployment").also { doInit(it, init) }
    fun `on DeploymentEnvironmentChangedEvent`(init: DeploymentEnvironmentChangedEvent.() -> Unit) =
        DeploymentEnvironmentChangedEvent("...on DeploymentEnvironmentChangedEvent").also { doInit(it, init) }
    fun `on DeploymentStatus`(init: DeploymentStatus.() -> Unit) =
        DeploymentStatus("...on DeploymentStatus").also { doInit(it, init) }
    fun `on DisconnectedEvent`(init: DisconnectedEvent.() -> Unit) =
        DisconnectedEvent("...on DisconnectedEvent").also { doInit(it, init) }
    fun `on Enterprise`(init: Enterprise.() -> Unit) =
        Enterprise("...on Enterprise").also { doInit(it, init) }
    fun `on EnterpriseAdministratorInvitation`(init: EnterpriseAdministratorInvitation.() -> Unit) =
        EnterpriseAdministratorInvitation("...on EnterpriseAdministratorInvitation").also { doInit(it, init) }
    fun `on EnterpriseIdentityProvider`(init: EnterpriseIdentityProvider.() -> Unit) =
        EnterpriseIdentityProvider("...on EnterpriseIdentityProvider").also { doInit(it, init) }
    fun `on EnterpriseRepositoryInfo`(init: EnterpriseRepositoryInfo.() -> Unit) =
        EnterpriseRepositoryInfo("...on EnterpriseRepositoryInfo").also { doInit(it, init) }
    fun `on EnterpriseServerInstallation`(init: EnterpriseServerInstallation.() -> Unit) =
        EnterpriseServerInstallation("...on EnterpriseServerInstallation").also { doInit(it, init) }
    fun `on EnterpriseServerUserAccount`(init: EnterpriseServerUserAccount.() -> Unit) =
        EnterpriseServerUserAccount("...on EnterpriseServerUserAccount").also { doInit(it, init) }
    fun `on EnterpriseServerUserAccountEmail`(init: EnterpriseServerUserAccountEmail.() -> Unit) =
        EnterpriseServerUserAccountEmail("...on EnterpriseServerUserAccountEmail").also { doInit(it, init) }
    fun `on EnterpriseServerUserAccountsUpload`(init: EnterpriseServerUserAccountsUpload.() -> Unit) =
        EnterpriseServerUserAccountsUpload("...on EnterpriseServerUserAccountsUpload").also { doInit(it, init) }
    fun `on EnterpriseUserAccount`(init: EnterpriseUserAccount.() -> Unit) =
        EnterpriseUserAccount("...on EnterpriseUserAccount").also { doInit(it, init) }
    fun `on ExternalIdentity`(init: ExternalIdentity.() -> Unit) =
        ExternalIdentity("...on ExternalIdentity").also { doInit(it, init) }
    fun `on Gist`(init: Gist.() -> Unit) =
        Gist("...on Gist").also { doInit(it, init) }
    fun `on GistComment`(init: GistComment.() -> Unit) =
        GistComment("...on GistComment").also { doInit(it, init) }
    fun `on HeadRefDeletedEvent`(init: HeadRefDeletedEvent.() -> Unit) =
        HeadRefDeletedEvent("...on HeadRefDeletedEvent").also { doInit(it, init) }
    fun `on HeadRefForcePushedEvent`(init: HeadRefForcePushedEvent.() -> Unit) =
        HeadRefForcePushedEvent("...on HeadRefForcePushedEvent").also { doInit(it, init) }
    fun `on HeadRefRestoredEvent`(init: HeadRefRestoredEvent.() -> Unit) =
        HeadRefRestoredEvent("...on HeadRefRestoredEvent").also { doInit(it, init) }
    fun `on IpAllowListEntry`(init: IpAllowListEntry.() -> Unit) =
        IpAllowListEntry("...on IpAllowListEntry").also { doInit(it, init) }
    fun `on Issue`(init: Issue.() -> Unit) =
        Issue("...on Issue").also { doInit(it, init) }
    fun `on IssueComment`(init: IssueComment.() -> Unit) =
        IssueComment("...on IssueComment").also { doInit(it, init) }
    fun `on Label`(init: Label.() -> Unit) =
        Label("...on Label").also { doInit(it, init) }
    fun `on LabeledEvent`(init: LabeledEvent.() -> Unit) =
        LabeledEvent("...on LabeledEvent").also { doInit(it, init) }
    fun `on Language`(init: Language.() -> Unit) =
        Language("...on Language").also { doInit(it, init) }
    fun `on License`(init: License.() -> Unit) =
        License("...on License").also { doInit(it, init) }
    fun `on LockedEvent`(init: LockedEvent.() -> Unit) =
        LockedEvent("...on LockedEvent").also { doInit(it, init) }
    fun `on Mannequin`(init: Mannequin.() -> Unit) =
        Mannequin("...on Mannequin").also { doInit(it, init) }
    fun `on MarkedAsDuplicateEvent`(init: MarkedAsDuplicateEvent.() -> Unit) =
        MarkedAsDuplicateEvent("...on MarkedAsDuplicateEvent").also { doInit(it, init) }
    fun `on MarketplaceCategory`(init: MarketplaceCategory.() -> Unit) =
        MarketplaceCategory("...on MarketplaceCategory").also { doInit(it, init) }
    fun `on MarketplaceListing`(init: MarketplaceListing.() -> Unit) =
        MarketplaceListing("...on MarketplaceListing").also { doInit(it, init) }
    fun `on MembersCanDeleteReposClearAuditEntry`(init: MembersCanDeleteReposClearAuditEntry.() -> Unit) =
        MembersCanDeleteReposClearAuditEntry("...on MembersCanDeleteReposClearAuditEntry").also { doInit(it, init) }
    fun `on MembersCanDeleteReposDisableAuditEntry`(init: MembersCanDeleteReposDisableAuditEntry.() -> Unit) =
        MembersCanDeleteReposDisableAuditEntry("...on MembersCanDeleteReposDisableAuditEntry").also { doInit(it, init) }
    fun `on MembersCanDeleteReposEnableAuditEntry`(init: MembersCanDeleteReposEnableAuditEntry.() -> Unit) =
        MembersCanDeleteReposEnableAuditEntry("...on MembersCanDeleteReposEnableAuditEntry").also { doInit(it, init) }
    fun `on MentionedEvent`(init: MentionedEvent.() -> Unit) =
        MentionedEvent("...on MentionedEvent").also { doInit(it, init) }
    fun `on MergedEvent`(init: MergedEvent.() -> Unit) =
        MergedEvent("...on MergedEvent").also { doInit(it, init) }
    fun `on Milestone`(init: Milestone.() -> Unit) =
        Milestone("...on Milestone").also { doInit(it, init) }
    fun `on MilestonedEvent`(init: MilestonedEvent.() -> Unit) =
        MilestonedEvent("...on MilestonedEvent").also { doInit(it, init) }
    fun `on MovedColumnsInProjectEvent`(init: MovedColumnsInProjectEvent.() -> Unit) =
        MovedColumnsInProjectEvent("...on MovedColumnsInProjectEvent").also { doInit(it, init) }
    fun `on OauthApplicationCreateAuditEntry`(init: OauthApplicationCreateAuditEntry.() -> Unit) =
        OauthApplicationCreateAuditEntry("...on OauthApplicationCreateAuditEntry").also { doInit(it, init) }
    fun `on OrgAddBillingManagerAuditEntry`(init: OrgAddBillingManagerAuditEntry.() -> Unit) =
        OrgAddBillingManagerAuditEntry("...on OrgAddBillingManagerAuditEntry").also { doInit(it, init) }
    fun `on OrgAddMemberAuditEntry`(init: OrgAddMemberAuditEntry.() -> Unit) =
        OrgAddMemberAuditEntry("...on OrgAddMemberAuditEntry").also { doInit(it, init) }
    fun `on OrgBlockUserAuditEntry`(init: OrgBlockUserAuditEntry.() -> Unit) =
        OrgBlockUserAuditEntry("...on OrgBlockUserAuditEntry").also { doInit(it, init) }
    fun `on OrgConfigDisableCollaboratorsOnlyAuditEntry`(init: OrgConfigDisableCollaboratorsOnlyAuditEntry.() -> Unit) =
        OrgConfigDisableCollaboratorsOnlyAuditEntry("...on OrgConfigDisableCollaboratorsOnlyAuditEntry").also { doInit(it, init) }
    fun `on OrgConfigEnableCollaboratorsOnlyAuditEntry`(init: OrgConfigEnableCollaboratorsOnlyAuditEntry.() -> Unit) =
        OrgConfigEnableCollaboratorsOnlyAuditEntry("...on OrgConfigEnableCollaboratorsOnlyAuditEntry").also { doInit(it, init) }
    fun `on OrgCreateAuditEntry`(init: OrgCreateAuditEntry.() -> Unit) =
        OrgCreateAuditEntry("...on OrgCreateAuditEntry").also { doInit(it, init) }
    fun `on OrgDisableOauthAppRestrictionsAuditEntry`(init: OrgDisableOauthAppRestrictionsAuditEntry.() -> Unit) =
        OrgDisableOauthAppRestrictionsAuditEntry("...on OrgDisableOauthAppRestrictionsAuditEntry").also { doInit(it, init) }
    fun `on OrgDisableSamlAuditEntry`(init: OrgDisableSamlAuditEntry.() -> Unit) =
        OrgDisableSamlAuditEntry("...on OrgDisableSamlAuditEntry").also { doInit(it, init) }
    fun `on OrgDisableTwoFactorRequirementAuditEntry`(init: OrgDisableTwoFactorRequirementAuditEntry.() -> Unit) =
        OrgDisableTwoFactorRequirementAuditEntry("...on OrgDisableTwoFactorRequirementAuditEntry").also { doInit(it, init) }
    fun `on OrgEnableOauthAppRestrictionsAuditEntry`(init: OrgEnableOauthAppRestrictionsAuditEntry.() -> Unit) =
        OrgEnableOauthAppRestrictionsAuditEntry("...on OrgEnableOauthAppRestrictionsAuditEntry").also { doInit(it, init) }
    fun `on OrgEnableSamlAuditEntry`(init: OrgEnableSamlAuditEntry.() -> Unit) =
        OrgEnableSamlAuditEntry("...on OrgEnableSamlAuditEntry").also { doInit(it, init) }
    fun `on OrgEnableTwoFactorRequirementAuditEntry`(init: OrgEnableTwoFactorRequirementAuditEntry.() -> Unit) =
        OrgEnableTwoFactorRequirementAuditEntry("...on OrgEnableTwoFactorRequirementAuditEntry").also { doInit(it, init) }
    fun `on OrgInviteMemberAuditEntry`(init: OrgInviteMemberAuditEntry.() -> Unit) =
        OrgInviteMemberAuditEntry("...on OrgInviteMemberAuditEntry").also { doInit(it, init) }
    fun `on OrgInviteToBusinessAuditEntry`(init: OrgInviteToBusinessAuditEntry.() -> Unit) =
        OrgInviteToBusinessAuditEntry("...on OrgInviteToBusinessAuditEntry").also { doInit(it, init) }
    fun `on OrgOauthAppAccessApprovedAuditEntry`(init: OrgOauthAppAccessApprovedAuditEntry.() -> Unit) =
        OrgOauthAppAccessApprovedAuditEntry("...on OrgOauthAppAccessApprovedAuditEntry").also { doInit(it, init) }
    fun `on OrgOauthAppAccessDeniedAuditEntry`(init: OrgOauthAppAccessDeniedAuditEntry.() -> Unit) =
        OrgOauthAppAccessDeniedAuditEntry("...on OrgOauthAppAccessDeniedAuditEntry").also { doInit(it, init) }
    fun `on OrgOauthAppAccessRequestedAuditEntry`(init: OrgOauthAppAccessRequestedAuditEntry.() -> Unit) =
        OrgOauthAppAccessRequestedAuditEntry("...on OrgOauthAppAccessRequestedAuditEntry").also { doInit(it, init) }
    fun `on OrgRemoveBillingManagerAuditEntry`(init: OrgRemoveBillingManagerAuditEntry.() -> Unit) =
        OrgRemoveBillingManagerAuditEntry("...on OrgRemoveBillingManagerAuditEntry").also { doInit(it, init) }
    fun `on OrgRemoveMemberAuditEntry`(init: OrgRemoveMemberAuditEntry.() -> Unit) =
        OrgRemoveMemberAuditEntry("...on OrgRemoveMemberAuditEntry").also { doInit(it, init) }
    fun `on OrgRemoveOutsideCollaboratorAuditEntry`(init: OrgRemoveOutsideCollaboratorAuditEntry.() -> Unit) =
        OrgRemoveOutsideCollaboratorAuditEntry("...on OrgRemoveOutsideCollaboratorAuditEntry").also { doInit(it, init) }
    fun `on OrgRestoreMemberAuditEntry`(init: OrgRestoreMemberAuditEntry.() -> Unit) =
        OrgRestoreMemberAuditEntry("...on OrgRestoreMemberAuditEntry").also { doInit(it, init) }
    fun `on OrgUnblockUserAuditEntry`(init: OrgUnblockUserAuditEntry.() -> Unit) =
        OrgUnblockUserAuditEntry("...on OrgUnblockUserAuditEntry").also { doInit(it, init) }
    fun `on OrgUpdateDefaultRepositoryPermissionAuditEntry`(init: OrgUpdateDefaultRepositoryPermissionAuditEntry.() -> Unit) =
        OrgUpdateDefaultRepositoryPermissionAuditEntry("...on OrgUpdateDefaultRepositoryPermissionAuditEntry").also { doInit(it, init) }
    fun `on OrgUpdateMemberAuditEntry`(init: OrgUpdateMemberAuditEntry.() -> Unit) =
        OrgUpdateMemberAuditEntry("...on OrgUpdateMemberAuditEntry").also { doInit(it, init) }
    fun `on OrgUpdateMemberRepositoryCreationPermissionAuditEntry`(init: OrgUpdateMemberRepositoryCreationPermissionAuditEntry.() -> Unit) =
        OrgUpdateMemberRepositoryCreationPermissionAuditEntry("...on OrgUpdateMemberRepositoryCreationPermissionAuditEntry").also { doInit(it, init) }
    fun `on OrgUpdateMemberRepositoryInvitationPermissionAuditEntry`(init: OrgUpdateMemberRepositoryInvitationPermissionAuditEntry.() -> Unit) =
        OrgUpdateMemberRepositoryInvitationPermissionAuditEntry("...on OrgUpdateMemberRepositoryInvitationPermissionAuditEntry").also { doInit(it, init) }
    fun `on Organization`(init: Organization.() -> Unit) =
        Organization("...on Organization").also { doInit(it, init) }
    fun `on OrganizationIdentityProvider`(init: OrganizationIdentityProvider.() -> Unit) =
        OrganizationIdentityProvider("...on OrganizationIdentityProvider").also { doInit(it, init) }
    fun `on OrganizationInvitation`(init: OrganizationInvitation.() -> Unit) =
        OrganizationInvitation("...on OrganizationInvitation").also { doInit(it, init) }
    fun `on Package`(init: Package.() -> Unit) =
        Package("...on Package").also { doInit(it, init) }
    fun `on PackageFile`(init: PackageFile.() -> Unit) =
        PackageFile("...on PackageFile").also { doInit(it, init) }
    fun `on PackageTag`(init: PackageTag.() -> Unit) =
        PackageTag("...on PackageTag").also { doInit(it, init) }
    fun `on PackageVersion`(init: PackageVersion.() -> Unit) =
        PackageVersion("...on PackageVersion").also { doInit(it, init) }
    fun `on PinnedEvent`(init: PinnedEvent.() -> Unit) =
        PinnedEvent("...on PinnedEvent").also { doInit(it, init) }
    fun `on PinnedIssue`(init: PinnedIssue.() -> Unit) =
        PinnedIssue("...on PinnedIssue").also { doInit(it, init) }
    fun `on PrivateRepositoryForkingDisableAuditEntry`(init: PrivateRepositoryForkingDisableAuditEntry.() -> Unit) =
        PrivateRepositoryForkingDisableAuditEntry("...on PrivateRepositoryForkingDisableAuditEntry").also { doInit(it, init) }
    fun `on PrivateRepositoryForkingEnableAuditEntry`(init: PrivateRepositoryForkingEnableAuditEntry.() -> Unit) =
        PrivateRepositoryForkingEnableAuditEntry("...on PrivateRepositoryForkingEnableAuditEntry").also { doInit(it, init) }
    fun `on Project`(init: Project.() -> Unit) =
        Project("...on Project").also { doInit(it, init) }
    fun `on ProjectCard`(init: ProjectCard.() -> Unit) =
        ProjectCard("...on ProjectCard").also { doInit(it, init) }
    fun `on ProjectColumn`(init: ProjectColumn.() -> Unit) =
        ProjectColumn("...on ProjectColumn").also { doInit(it, init) }
    fun `on PublicKey`(init: PublicKey.() -> Unit) =
        PublicKey("...on PublicKey").also { doInit(it, init) }
    fun `on PullRequest`(init: PullRequest.() -> Unit) =
        PullRequest("...on PullRequest").also { doInit(it, init) }
    fun `on PullRequestCommit`(init: PullRequestCommit.() -> Unit) =
        PullRequestCommit("...on PullRequestCommit").also { doInit(it, init) }
    fun `on PullRequestCommitCommentThread`(init: PullRequestCommitCommentThread.() -> Unit) =
        PullRequestCommitCommentThread("...on PullRequestCommitCommentThread").also { doInit(it, init) }
    fun `on PullRequestReview`(init: PullRequestReview.() -> Unit) =
        PullRequestReview("...on PullRequestReview").also { doInit(it, init) }
    fun `on PullRequestReviewComment`(init: PullRequestReviewComment.() -> Unit) =
        PullRequestReviewComment("...on PullRequestReviewComment").also { doInit(it, init) }
    fun `on PullRequestReviewThread`(init: PullRequestReviewThread.() -> Unit) =
        PullRequestReviewThread("...on PullRequestReviewThread").also { doInit(it, init) }
    fun `on Push`(init: Push.() -> Unit) =
        Push("...on Push").also { doInit(it, init) }
    fun `on PushAllowance`(init: PushAllowance.() -> Unit) =
        PushAllowance("...on PushAllowance").also { doInit(it, init) }
    fun `on Reaction`(init: Reaction.() -> Unit) =
        Reaction("...on Reaction").also { doInit(it, init) }
    fun `on ReadyForReviewEvent`(init: ReadyForReviewEvent.() -> Unit) =
        ReadyForReviewEvent("...on ReadyForReviewEvent").also { doInit(it, init) }
    fun `on Ref`(init: Ref.() -> Unit) =
        Ref("...on Ref").also { doInit(it, init) }
    fun `on ReferencedEvent`(init: ReferencedEvent.() -> Unit) =
        ReferencedEvent("...on ReferencedEvent").also { doInit(it, init) }
    fun `on Release`(init: Release.() -> Unit) =
        Release("...on Release").also { doInit(it, init) }
    fun `on ReleaseAsset`(init: ReleaseAsset.() -> Unit) =
        ReleaseAsset("...on ReleaseAsset").also { doInit(it, init) }
    fun `on RemovedFromProjectEvent`(init: RemovedFromProjectEvent.() -> Unit) =
        RemovedFromProjectEvent("...on RemovedFromProjectEvent").also { doInit(it, init) }
    fun `on RenamedTitleEvent`(init: RenamedTitleEvent.() -> Unit) =
        RenamedTitleEvent("...on RenamedTitleEvent").also { doInit(it, init) }
    fun `on ReopenedEvent`(init: ReopenedEvent.() -> Unit) =
        ReopenedEvent("...on ReopenedEvent").also { doInit(it, init) }
    fun `on RepoAccessAuditEntry`(init: RepoAccessAuditEntry.() -> Unit) =
        RepoAccessAuditEntry("...on RepoAccessAuditEntry").also { doInit(it, init) }
    fun `on RepoAddMemberAuditEntry`(init: RepoAddMemberAuditEntry.() -> Unit) =
        RepoAddMemberAuditEntry("...on RepoAddMemberAuditEntry").also { doInit(it, init) }
    fun `on RepoAddTopicAuditEntry`(init: RepoAddTopicAuditEntry.() -> Unit) =
        RepoAddTopicAuditEntry("...on RepoAddTopicAuditEntry").also { doInit(it, init) }
    fun `on RepoArchivedAuditEntry`(init: RepoArchivedAuditEntry.() -> Unit) =
        RepoArchivedAuditEntry("...on RepoArchivedAuditEntry").also { doInit(it, init) }
    fun `on RepoChangeMergeSettingAuditEntry`(init: RepoChangeMergeSettingAuditEntry.() -> Unit) =
        RepoChangeMergeSettingAuditEntry("...on RepoChangeMergeSettingAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigDisableAnonymousGitAccessAuditEntry`(init: RepoConfigDisableAnonymousGitAccessAuditEntry.() -> Unit) =
        RepoConfigDisableAnonymousGitAccessAuditEntry("...on RepoConfigDisableAnonymousGitAccessAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigDisableCollaboratorsOnlyAuditEntry`(init: RepoConfigDisableCollaboratorsOnlyAuditEntry.() -> Unit) =
        RepoConfigDisableCollaboratorsOnlyAuditEntry("...on RepoConfigDisableCollaboratorsOnlyAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigDisableContributorsOnlyAuditEntry`(init: RepoConfigDisableContributorsOnlyAuditEntry.() -> Unit) =
        RepoConfigDisableContributorsOnlyAuditEntry("...on RepoConfigDisableContributorsOnlyAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigDisableSockpuppetDisallowedAuditEntry`(init: RepoConfigDisableSockpuppetDisallowedAuditEntry.() -> Unit) =
        RepoConfigDisableSockpuppetDisallowedAuditEntry("...on RepoConfigDisableSockpuppetDisallowedAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigEnableAnonymousGitAccessAuditEntry`(init: RepoConfigEnableAnonymousGitAccessAuditEntry.() -> Unit) =
        RepoConfigEnableAnonymousGitAccessAuditEntry("...on RepoConfigEnableAnonymousGitAccessAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigEnableCollaboratorsOnlyAuditEntry`(init: RepoConfigEnableCollaboratorsOnlyAuditEntry.() -> Unit) =
        RepoConfigEnableCollaboratorsOnlyAuditEntry("...on RepoConfigEnableCollaboratorsOnlyAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigEnableContributorsOnlyAuditEntry`(init: RepoConfigEnableContributorsOnlyAuditEntry.() -> Unit) =
        RepoConfigEnableContributorsOnlyAuditEntry("...on RepoConfigEnableContributorsOnlyAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigEnableSockpuppetDisallowedAuditEntry`(init: RepoConfigEnableSockpuppetDisallowedAuditEntry.() -> Unit) =
        RepoConfigEnableSockpuppetDisallowedAuditEntry("...on RepoConfigEnableSockpuppetDisallowedAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigLockAnonymousGitAccessAuditEntry`(init: RepoConfigLockAnonymousGitAccessAuditEntry.() -> Unit) =
        RepoConfigLockAnonymousGitAccessAuditEntry("...on RepoConfigLockAnonymousGitAccessAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigUnlockAnonymousGitAccessAuditEntry`(init: RepoConfigUnlockAnonymousGitAccessAuditEntry.() -> Unit) =
        RepoConfigUnlockAnonymousGitAccessAuditEntry("...on RepoConfigUnlockAnonymousGitAccessAuditEntry").also { doInit(it, init) }
    fun `on RepoCreateAuditEntry`(init: RepoCreateAuditEntry.() -> Unit) =
        RepoCreateAuditEntry("...on RepoCreateAuditEntry").also { doInit(it, init) }
    fun `on RepoDestroyAuditEntry`(init: RepoDestroyAuditEntry.() -> Unit) =
        RepoDestroyAuditEntry("...on RepoDestroyAuditEntry").also { doInit(it, init) }
    fun `on RepoRemoveMemberAuditEntry`(init: RepoRemoveMemberAuditEntry.() -> Unit) =
        RepoRemoveMemberAuditEntry("...on RepoRemoveMemberAuditEntry").also { doInit(it, init) }
    fun `on RepoRemoveTopicAuditEntry`(init: RepoRemoveTopicAuditEntry.() -> Unit) =
        RepoRemoveTopicAuditEntry("...on RepoRemoveTopicAuditEntry").also { doInit(it, init) }
    fun `on Repository`(init: Repository.() -> Unit) =
        Repository("...on Repository").also { doInit(it, init) }
    fun `on RepositoryInvitation`(init: RepositoryInvitation.() -> Unit) =
        RepositoryInvitation("...on RepositoryInvitation").also { doInit(it, init) }
    fun `on RepositoryTopic`(init: RepositoryTopic.() -> Unit) =
        RepositoryTopic("...on RepositoryTopic").also { doInit(it, init) }
    fun `on RepositoryVisibilityChangeDisableAuditEntry`(init: RepositoryVisibilityChangeDisableAuditEntry.() -> Unit) =
        RepositoryVisibilityChangeDisableAuditEntry("...on RepositoryVisibilityChangeDisableAuditEntry").also { doInit(it, init) }
    fun `on RepositoryVisibilityChangeEnableAuditEntry`(init: RepositoryVisibilityChangeEnableAuditEntry.() -> Unit) =
        RepositoryVisibilityChangeEnableAuditEntry("...on RepositoryVisibilityChangeEnableAuditEntry").also { doInit(it, init) }
    fun `on RepositoryVulnerabilityAlert`(init: RepositoryVulnerabilityAlert.() -> Unit) =
        RepositoryVulnerabilityAlert("...on RepositoryVulnerabilityAlert").also { doInit(it, init) }
    fun `on ReviewDismissalAllowance`(init: ReviewDismissalAllowance.() -> Unit) =
        ReviewDismissalAllowance("...on ReviewDismissalAllowance").also { doInit(it, init) }
    fun `on ReviewDismissedEvent`(init: ReviewDismissedEvent.() -> Unit) =
        ReviewDismissedEvent("...on ReviewDismissedEvent").also { doInit(it, init) }
    fun `on ReviewRequest`(init: ReviewRequest.() -> Unit) =
        ReviewRequest("...on ReviewRequest").also { doInit(it, init) }
    fun `on ReviewRequestRemovedEvent`(init: ReviewRequestRemovedEvent.() -> Unit) =
        ReviewRequestRemovedEvent("...on ReviewRequestRemovedEvent").also { doInit(it, init) }
    fun `on ReviewRequestedEvent`(init: ReviewRequestedEvent.() -> Unit) =
        ReviewRequestedEvent("...on ReviewRequestedEvent").also { doInit(it, init) }
    fun `on SavedReply`(init: SavedReply.() -> Unit) =
        SavedReply("...on SavedReply").also { doInit(it, init) }
    fun `on SecurityAdvisory`(init: SecurityAdvisory.() -> Unit) =
        SecurityAdvisory("...on SecurityAdvisory").also { doInit(it, init) }
    fun `on SponsorsListing`(init: SponsorsListing.() -> Unit) =
        SponsorsListing("...on SponsorsListing").also { doInit(it, init) }
    fun `on SponsorsTier`(init: SponsorsTier.() -> Unit) =
        SponsorsTier("...on SponsorsTier").also { doInit(it, init) }
    fun `on Sponsorship`(init: Sponsorship.() -> Unit) =
        Sponsorship("...on Sponsorship").also { doInit(it, init) }
    fun `on Status`(init: Status.() -> Unit) =
        Status("...on Status").also { doInit(it, init) }
    fun `on StatusCheckRollup`(init: StatusCheckRollup.() -> Unit) =
        StatusCheckRollup("...on StatusCheckRollup").also { doInit(it, init) }
    fun `on StatusContext`(init: StatusContext.() -> Unit) =
        StatusContext("...on StatusContext").also { doInit(it, init) }
    fun `on SubscribedEvent`(init: SubscribedEvent.() -> Unit) =
        SubscribedEvent("...on SubscribedEvent").also { doInit(it, init) }
    fun `on Tag`(init: Tag.() -> Unit) =
        Tag("...on Tag").also { doInit(it, init) }
    fun `on Team`(init: Team.() -> Unit) =
        Team("...on Team").also { doInit(it, init) }
    fun `on TeamAddMemberAuditEntry`(init: TeamAddMemberAuditEntry.() -> Unit) =
        TeamAddMemberAuditEntry("...on TeamAddMemberAuditEntry").also { doInit(it, init) }
    fun `on TeamAddRepositoryAuditEntry`(init: TeamAddRepositoryAuditEntry.() -> Unit) =
        TeamAddRepositoryAuditEntry("...on TeamAddRepositoryAuditEntry").also { doInit(it, init) }
    fun `on TeamChangeParentTeamAuditEntry`(init: TeamChangeParentTeamAuditEntry.() -> Unit) =
        TeamChangeParentTeamAuditEntry("...on TeamChangeParentTeamAuditEntry").also { doInit(it, init) }
    fun `on TeamDiscussion`(init: TeamDiscussion.() -> Unit) =
        TeamDiscussion("...on TeamDiscussion").also { doInit(it, init) }
    fun `on TeamDiscussionComment`(init: TeamDiscussionComment.() -> Unit) =
        TeamDiscussionComment("...on TeamDiscussionComment").also { doInit(it, init) }
    fun `on TeamRemoveMemberAuditEntry`(init: TeamRemoveMemberAuditEntry.() -> Unit) =
        TeamRemoveMemberAuditEntry("...on TeamRemoveMemberAuditEntry").also { doInit(it, init) }
    fun `on TeamRemoveRepositoryAuditEntry`(init: TeamRemoveRepositoryAuditEntry.() -> Unit) =
        TeamRemoveRepositoryAuditEntry("...on TeamRemoveRepositoryAuditEntry").also { doInit(it, init) }
    fun `on Topic`(init: Topic.() -> Unit) =
        Topic("...on Topic").also { doInit(it, init) }
    fun `on TransferredEvent`(init: TransferredEvent.() -> Unit) =
        TransferredEvent("...on TransferredEvent").also { doInit(it, init) }
    fun `on Tree`(init: Tree.() -> Unit) =
        Tree("...on Tree").also { doInit(it, init) }
    fun `on UnassignedEvent`(init: UnassignedEvent.() -> Unit) =
        UnassignedEvent("...on UnassignedEvent").also { doInit(it, init) }
    fun `on UnlabeledEvent`(init: UnlabeledEvent.() -> Unit) =
        UnlabeledEvent("...on UnlabeledEvent").also { doInit(it, init) }
    fun `on UnlockedEvent`(init: UnlockedEvent.() -> Unit) =
        UnlockedEvent("...on UnlockedEvent").also { doInit(it, init) }
    fun `on UnmarkedAsDuplicateEvent`(init: UnmarkedAsDuplicateEvent.() -> Unit) =
        UnmarkedAsDuplicateEvent("...on UnmarkedAsDuplicateEvent").also { doInit(it, init) }
    fun `on UnpinnedEvent`(init: UnpinnedEvent.() -> Unit) =
        UnpinnedEvent("...on UnpinnedEvent").also { doInit(it, init) }
    fun `on UnsubscribedEvent`(init: UnsubscribedEvent.() -> Unit) =
        UnsubscribedEvent("...on UnsubscribedEvent").also { doInit(it, init) }
    fun `on User`(init: User.() -> Unit) =
        User("...on User").also { doInit(it, init) }
    fun `on UserBlockedEvent`(init: UserBlockedEvent.() -> Unit) =
        UserBlockedEvent("...on UserBlockedEvent").also { doInit(it, init) }
    fun `on UserContentEdit`(init: UserContentEdit.() -> Unit) =
        UserContentEdit("...on UserContentEdit").also { doInit(it, init) }
    fun `on UserStatus`(init: UserStatus.() -> Unit) =
        UserStatus("...on UserStatus").also { doInit(it, init) }
}

class OauthApplicationAuditEntryData(__name: String = "OauthApplicationAuditEntryData"): ObjectNode(__name) {
    val oauthApplicationName get() =
        ScalarNode("oauthApplicationName").also { doInit(it) }
    val oauthApplicationResourcePath get() =
        ScalarNode("oauthApplicationResourcePath").also { doInit(it) }
    val oauthApplicationUrl get() =
        ScalarNode("oauthApplicationUrl").also { doInit(it) }
    fun `on OauthApplicationCreateAuditEntry`(init: OauthApplicationCreateAuditEntry.() -> Unit) =
        OauthApplicationCreateAuditEntry("...on OauthApplicationCreateAuditEntry").also { doInit(it, init) }
    fun `on OrgOauthAppAccessApprovedAuditEntry`(init: OrgOauthAppAccessApprovedAuditEntry.() -> Unit) =
        OrgOauthAppAccessApprovedAuditEntry("...on OrgOauthAppAccessApprovedAuditEntry").also { doInit(it, init) }
    fun `on OrgOauthAppAccessDeniedAuditEntry`(init: OrgOauthAppAccessDeniedAuditEntry.() -> Unit) =
        OrgOauthAppAccessDeniedAuditEntry("...on OrgOauthAppAccessDeniedAuditEntry").also { doInit(it, init) }
    fun `on OrgOauthAppAccessRequestedAuditEntry`(init: OrgOauthAppAccessRequestedAuditEntry.() -> Unit) =
        OrgOauthAppAccessRequestedAuditEntry("...on OrgOauthAppAccessRequestedAuditEntry").also { doInit(it, init) }
}

class OrganizationAuditEntryData(__name: String = "OrganizationAuditEntryData"): ObjectNode(__name) {
    fun organization(init: Organization.() -> Unit) =
        Organization("organization").also { doInit(it, init) }
    val organizationName get() =
        ScalarNode("organizationName").also { doInit(it) }
    val organizationResourcePath get() =
        ScalarNode("organizationResourcePath").also { doInit(it) }
    val organizationUrl get() =
        ScalarNode("organizationUrl").also { doInit(it) }
    fun `on MembersCanDeleteReposClearAuditEntry`(init: MembersCanDeleteReposClearAuditEntry.() -> Unit) =
        MembersCanDeleteReposClearAuditEntry("...on MembersCanDeleteReposClearAuditEntry").also { doInit(it, init) }
    fun `on MembersCanDeleteReposDisableAuditEntry`(init: MembersCanDeleteReposDisableAuditEntry.() -> Unit) =
        MembersCanDeleteReposDisableAuditEntry("...on MembersCanDeleteReposDisableAuditEntry").also { doInit(it, init) }
    fun `on MembersCanDeleteReposEnableAuditEntry`(init: MembersCanDeleteReposEnableAuditEntry.() -> Unit) =
        MembersCanDeleteReposEnableAuditEntry("...on MembersCanDeleteReposEnableAuditEntry").also { doInit(it, init) }
    fun `on OauthApplicationCreateAuditEntry`(init: OauthApplicationCreateAuditEntry.() -> Unit) =
        OauthApplicationCreateAuditEntry("...on OauthApplicationCreateAuditEntry").also { doInit(it, init) }
    fun `on OrgAddBillingManagerAuditEntry`(init: OrgAddBillingManagerAuditEntry.() -> Unit) =
        OrgAddBillingManagerAuditEntry("...on OrgAddBillingManagerAuditEntry").also { doInit(it, init) }
    fun `on OrgAddMemberAuditEntry`(init: OrgAddMemberAuditEntry.() -> Unit) =
        OrgAddMemberAuditEntry("...on OrgAddMemberAuditEntry").also { doInit(it, init) }
    fun `on OrgBlockUserAuditEntry`(init: OrgBlockUserAuditEntry.() -> Unit) =
        OrgBlockUserAuditEntry("...on OrgBlockUserAuditEntry").also { doInit(it, init) }
    fun `on OrgConfigDisableCollaboratorsOnlyAuditEntry`(init: OrgConfigDisableCollaboratorsOnlyAuditEntry.() -> Unit) =
        OrgConfigDisableCollaboratorsOnlyAuditEntry("...on OrgConfigDisableCollaboratorsOnlyAuditEntry").also { doInit(it, init) }
    fun `on OrgConfigEnableCollaboratorsOnlyAuditEntry`(init: OrgConfigEnableCollaboratorsOnlyAuditEntry.() -> Unit) =
        OrgConfigEnableCollaboratorsOnlyAuditEntry("...on OrgConfigEnableCollaboratorsOnlyAuditEntry").also { doInit(it, init) }
    fun `on OrgCreateAuditEntry`(init: OrgCreateAuditEntry.() -> Unit) =
        OrgCreateAuditEntry("...on OrgCreateAuditEntry").also { doInit(it, init) }
    fun `on OrgDisableOauthAppRestrictionsAuditEntry`(init: OrgDisableOauthAppRestrictionsAuditEntry.() -> Unit) =
        OrgDisableOauthAppRestrictionsAuditEntry("...on OrgDisableOauthAppRestrictionsAuditEntry").also { doInit(it, init) }
    fun `on OrgDisableSamlAuditEntry`(init: OrgDisableSamlAuditEntry.() -> Unit) =
        OrgDisableSamlAuditEntry("...on OrgDisableSamlAuditEntry").also { doInit(it, init) }
    fun `on OrgDisableTwoFactorRequirementAuditEntry`(init: OrgDisableTwoFactorRequirementAuditEntry.() -> Unit) =
        OrgDisableTwoFactorRequirementAuditEntry("...on OrgDisableTwoFactorRequirementAuditEntry").also { doInit(it, init) }
    fun `on OrgEnableOauthAppRestrictionsAuditEntry`(init: OrgEnableOauthAppRestrictionsAuditEntry.() -> Unit) =
        OrgEnableOauthAppRestrictionsAuditEntry("...on OrgEnableOauthAppRestrictionsAuditEntry").also { doInit(it, init) }
    fun `on OrgEnableSamlAuditEntry`(init: OrgEnableSamlAuditEntry.() -> Unit) =
        OrgEnableSamlAuditEntry("...on OrgEnableSamlAuditEntry").also { doInit(it, init) }
    fun `on OrgEnableTwoFactorRequirementAuditEntry`(init: OrgEnableTwoFactorRequirementAuditEntry.() -> Unit) =
        OrgEnableTwoFactorRequirementAuditEntry("...on OrgEnableTwoFactorRequirementAuditEntry").also { doInit(it, init) }
    fun `on OrgInviteMemberAuditEntry`(init: OrgInviteMemberAuditEntry.() -> Unit) =
        OrgInviteMemberAuditEntry("...on OrgInviteMemberAuditEntry").also { doInit(it, init) }
    fun `on OrgInviteToBusinessAuditEntry`(init: OrgInviteToBusinessAuditEntry.() -> Unit) =
        OrgInviteToBusinessAuditEntry("...on OrgInviteToBusinessAuditEntry").also { doInit(it, init) }
    fun `on OrgOauthAppAccessApprovedAuditEntry`(init: OrgOauthAppAccessApprovedAuditEntry.() -> Unit) =
        OrgOauthAppAccessApprovedAuditEntry("...on OrgOauthAppAccessApprovedAuditEntry").also { doInit(it, init) }
    fun `on OrgOauthAppAccessDeniedAuditEntry`(init: OrgOauthAppAccessDeniedAuditEntry.() -> Unit) =
        OrgOauthAppAccessDeniedAuditEntry("...on OrgOauthAppAccessDeniedAuditEntry").also { doInit(it, init) }
    fun `on OrgOauthAppAccessRequestedAuditEntry`(init: OrgOauthAppAccessRequestedAuditEntry.() -> Unit) =
        OrgOauthAppAccessRequestedAuditEntry("...on OrgOauthAppAccessRequestedAuditEntry").also { doInit(it, init) }
    fun `on OrgRemoveBillingManagerAuditEntry`(init: OrgRemoveBillingManagerAuditEntry.() -> Unit) =
        OrgRemoveBillingManagerAuditEntry("...on OrgRemoveBillingManagerAuditEntry").also { doInit(it, init) }
    fun `on OrgRemoveMemberAuditEntry`(init: OrgRemoveMemberAuditEntry.() -> Unit) =
        OrgRemoveMemberAuditEntry("...on OrgRemoveMemberAuditEntry").also { doInit(it, init) }
    fun `on OrgRemoveOutsideCollaboratorAuditEntry`(init: OrgRemoveOutsideCollaboratorAuditEntry.() -> Unit) =
        OrgRemoveOutsideCollaboratorAuditEntry("...on OrgRemoveOutsideCollaboratorAuditEntry").also { doInit(it, init) }
    fun `on OrgRestoreMemberAuditEntry`(init: OrgRestoreMemberAuditEntry.() -> Unit) =
        OrgRestoreMemberAuditEntry("...on OrgRestoreMemberAuditEntry").also { doInit(it, init) }
    fun `on OrgRestoreMemberMembershipOrganizationAuditEntryData`(init: OrgRestoreMemberMembershipOrganizationAuditEntryData.() -> Unit) =
        OrgRestoreMemberMembershipOrganizationAuditEntryData("...on OrgRestoreMemberMembershipOrganizationAuditEntryData").also { doInit(it, init) }
    fun `on OrgUnblockUserAuditEntry`(init: OrgUnblockUserAuditEntry.() -> Unit) =
        OrgUnblockUserAuditEntry("...on OrgUnblockUserAuditEntry").also { doInit(it, init) }
    fun `on OrgUpdateDefaultRepositoryPermissionAuditEntry`(init: OrgUpdateDefaultRepositoryPermissionAuditEntry.() -> Unit) =
        OrgUpdateDefaultRepositoryPermissionAuditEntry("...on OrgUpdateDefaultRepositoryPermissionAuditEntry").also { doInit(it, init) }
    fun `on OrgUpdateMemberAuditEntry`(init: OrgUpdateMemberAuditEntry.() -> Unit) =
        OrgUpdateMemberAuditEntry("...on OrgUpdateMemberAuditEntry").also { doInit(it, init) }
    fun `on OrgUpdateMemberRepositoryCreationPermissionAuditEntry`(init: OrgUpdateMemberRepositoryCreationPermissionAuditEntry.() -> Unit) =
        OrgUpdateMemberRepositoryCreationPermissionAuditEntry("...on OrgUpdateMemberRepositoryCreationPermissionAuditEntry").also { doInit(it, init) }
    fun `on OrgUpdateMemberRepositoryInvitationPermissionAuditEntry`(init: OrgUpdateMemberRepositoryInvitationPermissionAuditEntry.() -> Unit) =
        OrgUpdateMemberRepositoryInvitationPermissionAuditEntry("...on OrgUpdateMemberRepositoryInvitationPermissionAuditEntry").also { doInit(it, init) }
    fun `on PrivateRepositoryForkingDisableAuditEntry`(init: PrivateRepositoryForkingDisableAuditEntry.() -> Unit) =
        PrivateRepositoryForkingDisableAuditEntry("...on PrivateRepositoryForkingDisableAuditEntry").also { doInit(it, init) }
    fun `on PrivateRepositoryForkingEnableAuditEntry`(init: PrivateRepositoryForkingEnableAuditEntry.() -> Unit) =
        PrivateRepositoryForkingEnableAuditEntry("...on PrivateRepositoryForkingEnableAuditEntry").also { doInit(it, init) }
    fun `on RepoAccessAuditEntry`(init: RepoAccessAuditEntry.() -> Unit) =
        RepoAccessAuditEntry("...on RepoAccessAuditEntry").also { doInit(it, init) }
    fun `on RepoAddMemberAuditEntry`(init: RepoAddMemberAuditEntry.() -> Unit) =
        RepoAddMemberAuditEntry("...on RepoAddMemberAuditEntry").also { doInit(it, init) }
    fun `on RepoAddTopicAuditEntry`(init: RepoAddTopicAuditEntry.() -> Unit) =
        RepoAddTopicAuditEntry("...on RepoAddTopicAuditEntry").also { doInit(it, init) }
    fun `on RepoArchivedAuditEntry`(init: RepoArchivedAuditEntry.() -> Unit) =
        RepoArchivedAuditEntry("...on RepoArchivedAuditEntry").also { doInit(it, init) }
    fun `on RepoChangeMergeSettingAuditEntry`(init: RepoChangeMergeSettingAuditEntry.() -> Unit) =
        RepoChangeMergeSettingAuditEntry("...on RepoChangeMergeSettingAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigDisableAnonymousGitAccessAuditEntry`(init: RepoConfigDisableAnonymousGitAccessAuditEntry.() -> Unit) =
        RepoConfigDisableAnonymousGitAccessAuditEntry("...on RepoConfigDisableAnonymousGitAccessAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigDisableCollaboratorsOnlyAuditEntry`(init: RepoConfigDisableCollaboratorsOnlyAuditEntry.() -> Unit) =
        RepoConfigDisableCollaboratorsOnlyAuditEntry("...on RepoConfigDisableCollaboratorsOnlyAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigDisableContributorsOnlyAuditEntry`(init: RepoConfigDisableContributorsOnlyAuditEntry.() -> Unit) =
        RepoConfigDisableContributorsOnlyAuditEntry("...on RepoConfigDisableContributorsOnlyAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigDisableSockpuppetDisallowedAuditEntry`(init: RepoConfigDisableSockpuppetDisallowedAuditEntry.() -> Unit) =
        RepoConfigDisableSockpuppetDisallowedAuditEntry("...on RepoConfigDisableSockpuppetDisallowedAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigEnableAnonymousGitAccessAuditEntry`(init: RepoConfigEnableAnonymousGitAccessAuditEntry.() -> Unit) =
        RepoConfigEnableAnonymousGitAccessAuditEntry("...on RepoConfigEnableAnonymousGitAccessAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigEnableCollaboratorsOnlyAuditEntry`(init: RepoConfigEnableCollaboratorsOnlyAuditEntry.() -> Unit) =
        RepoConfigEnableCollaboratorsOnlyAuditEntry("...on RepoConfigEnableCollaboratorsOnlyAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigEnableContributorsOnlyAuditEntry`(init: RepoConfigEnableContributorsOnlyAuditEntry.() -> Unit) =
        RepoConfigEnableContributorsOnlyAuditEntry("...on RepoConfigEnableContributorsOnlyAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigEnableSockpuppetDisallowedAuditEntry`(init: RepoConfigEnableSockpuppetDisallowedAuditEntry.() -> Unit) =
        RepoConfigEnableSockpuppetDisallowedAuditEntry("...on RepoConfigEnableSockpuppetDisallowedAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigLockAnonymousGitAccessAuditEntry`(init: RepoConfigLockAnonymousGitAccessAuditEntry.() -> Unit) =
        RepoConfigLockAnonymousGitAccessAuditEntry("...on RepoConfigLockAnonymousGitAccessAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigUnlockAnonymousGitAccessAuditEntry`(init: RepoConfigUnlockAnonymousGitAccessAuditEntry.() -> Unit) =
        RepoConfigUnlockAnonymousGitAccessAuditEntry("...on RepoConfigUnlockAnonymousGitAccessAuditEntry").also { doInit(it, init) }
    fun `on RepoCreateAuditEntry`(init: RepoCreateAuditEntry.() -> Unit) =
        RepoCreateAuditEntry("...on RepoCreateAuditEntry").also { doInit(it, init) }
    fun `on RepoDestroyAuditEntry`(init: RepoDestroyAuditEntry.() -> Unit) =
        RepoDestroyAuditEntry("...on RepoDestroyAuditEntry").also { doInit(it, init) }
    fun `on RepoRemoveMemberAuditEntry`(init: RepoRemoveMemberAuditEntry.() -> Unit) =
        RepoRemoveMemberAuditEntry("...on RepoRemoveMemberAuditEntry").also { doInit(it, init) }
    fun `on RepoRemoveTopicAuditEntry`(init: RepoRemoveTopicAuditEntry.() -> Unit) =
        RepoRemoveTopicAuditEntry("...on RepoRemoveTopicAuditEntry").also { doInit(it, init) }
    fun `on RepositoryVisibilityChangeDisableAuditEntry`(init: RepositoryVisibilityChangeDisableAuditEntry.() -> Unit) =
        RepositoryVisibilityChangeDisableAuditEntry("...on RepositoryVisibilityChangeDisableAuditEntry").also { doInit(it, init) }
    fun `on RepositoryVisibilityChangeEnableAuditEntry`(init: RepositoryVisibilityChangeEnableAuditEntry.() -> Unit) =
        RepositoryVisibilityChangeEnableAuditEntry("...on RepositoryVisibilityChangeEnableAuditEntry").also { doInit(it, init) }
    fun `on TeamAddMemberAuditEntry`(init: TeamAddMemberAuditEntry.() -> Unit) =
        TeamAddMemberAuditEntry("...on TeamAddMemberAuditEntry").also { doInit(it, init) }
    fun `on TeamAddRepositoryAuditEntry`(init: TeamAddRepositoryAuditEntry.() -> Unit) =
        TeamAddRepositoryAuditEntry("...on TeamAddRepositoryAuditEntry").also { doInit(it, init) }
    fun `on TeamChangeParentTeamAuditEntry`(init: TeamChangeParentTeamAuditEntry.() -> Unit) =
        TeamChangeParentTeamAuditEntry("...on TeamChangeParentTeamAuditEntry").also { doInit(it, init) }
    fun `on TeamRemoveMemberAuditEntry`(init: TeamRemoveMemberAuditEntry.() -> Unit) =
        TeamRemoveMemberAuditEntry("...on TeamRemoveMemberAuditEntry").also { doInit(it, init) }
    fun `on TeamRemoveRepositoryAuditEntry`(init: TeamRemoveRepositoryAuditEntry.() -> Unit) =
        TeamRemoveRepositoryAuditEntry("...on TeamRemoveRepositoryAuditEntry").also { doInit(it, init) }
}

class PackageOwner(__name: String = "PackageOwner"): ObjectNode(__name) {
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun packages(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, names: String? = null, orderBy: PackageOrder? = null, packageType: PackageType? = null, repositoryId: ID? = null, init: PackageConnection.() -> Unit) =
        PackageConnection("packages").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("names", names) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("packageType", packageType) }.apply { addArgs("repositoryId", repositoryId) }.also { doInit(it, init) }
    fun `on Organization`(init: Organization.() -> Unit) =
        Organization("...on Organization").also { doInit(it, init) }
    fun `on Repository`(init: Repository.() -> Unit) =
        Repository("...on Repository").also { doInit(it, init) }
    fun `on User`(init: User.() -> Unit) =
        User("...on User").also { doInit(it, init) }
}

class ProfileOwner(__name: String = "ProfileOwner"): ObjectNode(__name) {
    fun anyPinnableItems(type: PinnableItemType? = null) =
        ScalarWithArgsNode("anyPinnableItems", mapOf("type" to type)).also { doInit(it) }
    val anyPinnableItems get() =
        ScalarNode("anyPinnableItems").also { doInit(it) }
    val email get() =
        ScalarNode("email").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun itemShowcase(init: ProfileItemShowcase.() -> Unit) =
        ProfileItemShowcase("itemShowcase").also { doInit(it, init) }
    val location get() =
        ScalarNode("location").also { doInit(it) }
    val login get() =
        ScalarNode("login").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    fun pinnableItems(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, types: PinnableItemType? = null, init: PinnableItemConnection.() -> Unit) =
        PinnableItemConnection("pinnableItems").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("types", types) }.also { doInit(it, init) }
    fun pinnedItems(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, types: PinnableItemType? = null, init: PinnableItemConnection.() -> Unit) =
        PinnableItemConnection("pinnedItems").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("types", types) }.also { doInit(it, init) }
    val pinnedItemsRemaining get() =
        ScalarNode("pinnedItemsRemaining").also { doInit(it) }
    val viewerCanChangePinnedItems get() =
        ScalarNode("viewerCanChangePinnedItems").also { doInit(it) }
    val websiteUrl get() =
        ScalarNode("websiteUrl").also { doInit(it) }
    fun `on Organization`(init: Organization.() -> Unit) =
        Organization("...on Organization").also { doInit(it, init) }
    fun `on User`(init: User.() -> Unit) =
        User("...on User").also { doInit(it, init) }
}

class ProjectOwner(__name: String = "ProjectOwner"): ObjectNode(__name) {
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun project(number: Int, init: Project.() -> Unit) =
        Project("project").apply { addArgs("number", number) }.also { doInit(it, init) }
    fun projects(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: ProjectOrder? = null, search: String? = null, states: ProjectState? = null, init: ProjectConnection.() -> Unit) =
        ProjectConnection("projects").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("search", search) }.apply { addArgs("states", states) }.also { doInit(it, init) }
    val projectsResourcePath get() =
        ScalarNode("projectsResourcePath").also { doInit(it) }
    val projectsUrl get() =
        ScalarNode("projectsUrl").also { doInit(it) }
    val viewerCanCreateProjects get() =
        ScalarNode("viewerCanCreateProjects").also { doInit(it) }
    fun `on Organization`(init: Organization.() -> Unit) =
        Organization("...on Organization").also { doInit(it, init) }
    fun `on Repository`(init: Repository.() -> Unit) =
        Repository("...on Repository").also { doInit(it, init) }
    fun `on User`(init: User.() -> Unit) =
        User("...on User").also { doInit(it, init) }
}

class Reactable(__name: String = "Reactable"): ObjectNode(__name) {
    val databaseId get() =
        ScalarNode("databaseId").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    fun reactionGroups(init: ReactionGroup.() -> Unit) =
        ReactionGroup("reactionGroups").also { doInit(it, init) }
    fun reactions(after: String? = null, before: String? = null, content: ReactionContent? = null, first: Int? = null, last: Int? = null, orderBy: ReactionOrder? = null, init: ReactionConnection.() -> Unit) =
        ReactionConnection("reactions").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("content", content) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    val viewerCanReact get() =
        ScalarNode("viewerCanReact").also { doInit(it) }
    fun `on CommitComment`(init: CommitComment.() -> Unit) =
        CommitComment("...on CommitComment").also { doInit(it, init) }
    fun `on Issue`(init: Issue.() -> Unit) =
        Issue("...on Issue").also { doInit(it, init) }
    fun `on IssueComment`(init: IssueComment.() -> Unit) =
        IssueComment("...on IssueComment").also { doInit(it, init) }
    fun `on PullRequest`(init: PullRequest.() -> Unit) =
        PullRequest("...on PullRequest").also { doInit(it, init) }
    fun `on PullRequestReview`(init: PullRequestReview.() -> Unit) =
        PullRequestReview("...on PullRequestReview").also { doInit(it, init) }
    fun `on PullRequestReviewComment`(init: PullRequestReviewComment.() -> Unit) =
        PullRequestReviewComment("...on PullRequestReviewComment").also { doInit(it, init) }
    fun `on TeamDiscussion`(init: TeamDiscussion.() -> Unit) =
        TeamDiscussion("...on TeamDiscussion").also { doInit(it, init) }
    fun `on TeamDiscussionComment`(init: TeamDiscussionComment.() -> Unit) =
        TeamDiscussionComment("...on TeamDiscussionComment").also { doInit(it, init) }
}

class RepositoryAuditEntryData(__name: String = "RepositoryAuditEntryData"): ObjectNode(__name) {
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    val repositoryName get() =
        ScalarNode("repositoryName").also { doInit(it) }
    val repositoryResourcePath get() =
        ScalarNode("repositoryResourcePath").also { doInit(it) }
    val repositoryUrl get() =
        ScalarNode("repositoryUrl").also { doInit(it) }
    fun `on OrgRestoreMemberMembershipRepositoryAuditEntryData`(init: OrgRestoreMemberMembershipRepositoryAuditEntryData.() -> Unit) =
        OrgRestoreMemberMembershipRepositoryAuditEntryData("...on OrgRestoreMemberMembershipRepositoryAuditEntryData").also { doInit(it, init) }
    fun `on PrivateRepositoryForkingDisableAuditEntry`(init: PrivateRepositoryForkingDisableAuditEntry.() -> Unit) =
        PrivateRepositoryForkingDisableAuditEntry("...on PrivateRepositoryForkingDisableAuditEntry").also { doInit(it, init) }
    fun `on PrivateRepositoryForkingEnableAuditEntry`(init: PrivateRepositoryForkingEnableAuditEntry.() -> Unit) =
        PrivateRepositoryForkingEnableAuditEntry("...on PrivateRepositoryForkingEnableAuditEntry").also { doInit(it, init) }
    fun `on RepoAccessAuditEntry`(init: RepoAccessAuditEntry.() -> Unit) =
        RepoAccessAuditEntry("...on RepoAccessAuditEntry").also { doInit(it, init) }
    fun `on RepoAddMemberAuditEntry`(init: RepoAddMemberAuditEntry.() -> Unit) =
        RepoAddMemberAuditEntry("...on RepoAddMemberAuditEntry").also { doInit(it, init) }
    fun `on RepoAddTopicAuditEntry`(init: RepoAddTopicAuditEntry.() -> Unit) =
        RepoAddTopicAuditEntry("...on RepoAddTopicAuditEntry").also { doInit(it, init) }
    fun `on RepoArchivedAuditEntry`(init: RepoArchivedAuditEntry.() -> Unit) =
        RepoArchivedAuditEntry("...on RepoArchivedAuditEntry").also { doInit(it, init) }
    fun `on RepoChangeMergeSettingAuditEntry`(init: RepoChangeMergeSettingAuditEntry.() -> Unit) =
        RepoChangeMergeSettingAuditEntry("...on RepoChangeMergeSettingAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigDisableAnonymousGitAccessAuditEntry`(init: RepoConfigDisableAnonymousGitAccessAuditEntry.() -> Unit) =
        RepoConfigDisableAnonymousGitAccessAuditEntry("...on RepoConfigDisableAnonymousGitAccessAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigDisableCollaboratorsOnlyAuditEntry`(init: RepoConfigDisableCollaboratorsOnlyAuditEntry.() -> Unit) =
        RepoConfigDisableCollaboratorsOnlyAuditEntry("...on RepoConfigDisableCollaboratorsOnlyAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigDisableContributorsOnlyAuditEntry`(init: RepoConfigDisableContributorsOnlyAuditEntry.() -> Unit) =
        RepoConfigDisableContributorsOnlyAuditEntry("...on RepoConfigDisableContributorsOnlyAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigDisableSockpuppetDisallowedAuditEntry`(init: RepoConfigDisableSockpuppetDisallowedAuditEntry.() -> Unit) =
        RepoConfigDisableSockpuppetDisallowedAuditEntry("...on RepoConfigDisableSockpuppetDisallowedAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigEnableAnonymousGitAccessAuditEntry`(init: RepoConfigEnableAnonymousGitAccessAuditEntry.() -> Unit) =
        RepoConfigEnableAnonymousGitAccessAuditEntry("...on RepoConfigEnableAnonymousGitAccessAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigEnableCollaboratorsOnlyAuditEntry`(init: RepoConfigEnableCollaboratorsOnlyAuditEntry.() -> Unit) =
        RepoConfigEnableCollaboratorsOnlyAuditEntry("...on RepoConfigEnableCollaboratorsOnlyAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigEnableContributorsOnlyAuditEntry`(init: RepoConfigEnableContributorsOnlyAuditEntry.() -> Unit) =
        RepoConfigEnableContributorsOnlyAuditEntry("...on RepoConfigEnableContributorsOnlyAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigEnableSockpuppetDisallowedAuditEntry`(init: RepoConfigEnableSockpuppetDisallowedAuditEntry.() -> Unit) =
        RepoConfigEnableSockpuppetDisallowedAuditEntry("...on RepoConfigEnableSockpuppetDisallowedAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigLockAnonymousGitAccessAuditEntry`(init: RepoConfigLockAnonymousGitAccessAuditEntry.() -> Unit) =
        RepoConfigLockAnonymousGitAccessAuditEntry("...on RepoConfigLockAnonymousGitAccessAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigUnlockAnonymousGitAccessAuditEntry`(init: RepoConfigUnlockAnonymousGitAccessAuditEntry.() -> Unit) =
        RepoConfigUnlockAnonymousGitAccessAuditEntry("...on RepoConfigUnlockAnonymousGitAccessAuditEntry").also { doInit(it, init) }
    fun `on RepoCreateAuditEntry`(init: RepoCreateAuditEntry.() -> Unit) =
        RepoCreateAuditEntry("...on RepoCreateAuditEntry").also { doInit(it, init) }
    fun `on RepoDestroyAuditEntry`(init: RepoDestroyAuditEntry.() -> Unit) =
        RepoDestroyAuditEntry("...on RepoDestroyAuditEntry").also { doInit(it, init) }
    fun `on RepoRemoveMemberAuditEntry`(init: RepoRemoveMemberAuditEntry.() -> Unit) =
        RepoRemoveMemberAuditEntry("...on RepoRemoveMemberAuditEntry").also { doInit(it, init) }
    fun `on RepoRemoveTopicAuditEntry`(init: RepoRemoveTopicAuditEntry.() -> Unit) =
        RepoRemoveTopicAuditEntry("...on RepoRemoveTopicAuditEntry").also { doInit(it, init) }
    fun `on TeamAddRepositoryAuditEntry`(init: TeamAddRepositoryAuditEntry.() -> Unit) =
        TeamAddRepositoryAuditEntry("...on TeamAddRepositoryAuditEntry").also { doInit(it, init) }
    fun `on TeamRemoveRepositoryAuditEntry`(init: TeamRemoveRepositoryAuditEntry.() -> Unit) =
        TeamRemoveRepositoryAuditEntry("...on TeamRemoveRepositoryAuditEntry").also { doInit(it, init) }
}

class RepositoryInfo(__name: String = "RepositoryInfo"): ObjectNode(__name) {
    val createdAt get() =
        ScalarNode("createdAt").also { doInit(it) }
    val description get() =
        ScalarNode("description").also { doInit(it) }
    val descriptionHTML get() =
        ScalarNode("descriptionHTML").also { doInit(it) }
    val forkCount get() =
        ScalarNode("forkCount").also { doInit(it) }
    val hasIssuesEnabled get() =
        ScalarNode("hasIssuesEnabled").also { doInit(it) }
    val hasProjectsEnabled get() =
        ScalarNode("hasProjectsEnabled").also { doInit(it) }
    val hasWikiEnabled get() =
        ScalarNode("hasWikiEnabled").also { doInit(it) }
    val homepageUrl get() =
        ScalarNode("homepageUrl").also { doInit(it) }
    val isArchived get() =
        ScalarNode("isArchived").also { doInit(it) }
    val isFork get() =
        ScalarNode("isFork").also { doInit(it) }
    val isInOrganization get() =
        ScalarNode("isInOrganization").also { doInit(it) }
    val isLocked get() =
        ScalarNode("isLocked").also { doInit(it) }
    val isMirror get() =
        ScalarNode("isMirror").also { doInit(it) }
    val isPrivate get() =
        ScalarNode("isPrivate").also { doInit(it) }
    val isTemplate get() =
        ScalarNode("isTemplate").also { doInit(it) }
    fun licenseInfo(init: License.() -> Unit) =
        License("licenseInfo").also { doInit(it, init) }
    val lockReason get() =
        ScalarNode("lockReason").also { doInit(it) }
    val mirrorUrl get() =
        ScalarNode("mirrorUrl").also { doInit(it) }
    val name get() =
        ScalarNode("name").also { doInit(it) }
    val nameWithOwner get() =
        ScalarNode("nameWithOwner").also { doInit(it) }
    val openGraphImageUrl get() =
        ScalarNode("openGraphImageUrl").also { doInit(it) }
    fun owner(init: RepositoryOwner.() -> Unit) =
        RepositoryOwner("owner").also { doInit(it, init) }
    val pushedAt get() =
        ScalarNode("pushedAt").also { doInit(it) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    fun shortDescriptionHTML(limit: Int? = null) =
        ScalarWithArgsNode("shortDescriptionHTML", mapOf("limit" to limit)).also { doInit(it) }
    val shortDescriptionHTML get() =
        ScalarNode("shortDescriptionHTML").also { doInit(it) }
    val updatedAt get() =
        ScalarNode("updatedAt").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    val usesCustomOpenGraphImage get() =
        ScalarNode("usesCustomOpenGraphImage").also { doInit(it) }
    fun `on Repository`(init: Repository.() -> Unit) =
        Repository("...on Repository").also { doInit(it, init) }
}

class RepositoryNode(__name: String = "RepositoryNode"): ObjectNode(__name) {
    fun repository(init: Repository.() -> Unit) =
        Repository("repository").also { doInit(it, init) }
    fun `on CommitComment`(init: CommitComment.() -> Unit) =
        CommitComment("...on CommitComment").also { doInit(it, init) }
    fun `on CommitCommentThread`(init: CommitCommentThread.() -> Unit) =
        CommitCommentThread("...on CommitCommentThread").also { doInit(it, init) }
    fun `on Issue`(init: Issue.() -> Unit) =
        Issue("...on Issue").also { doInit(it, init) }
    fun `on IssueComment`(init: IssueComment.() -> Unit) =
        IssueComment("...on IssueComment").also { doInit(it, init) }
    fun `on PullRequest`(init: PullRequest.() -> Unit) =
        PullRequest("...on PullRequest").also { doInit(it, init) }
    fun `on PullRequestCommitCommentThread`(init: PullRequestCommitCommentThread.() -> Unit) =
        PullRequestCommitCommentThread("...on PullRequestCommitCommentThread").also { doInit(it, init) }
    fun `on PullRequestReview`(init: PullRequestReview.() -> Unit) =
        PullRequestReview("...on PullRequestReview").also { doInit(it, init) }
    fun `on PullRequestReviewComment`(init: PullRequestReviewComment.() -> Unit) =
        PullRequestReviewComment("...on PullRequestReviewComment").also { doInit(it, init) }
    fun `on RepositoryVulnerabilityAlert`(init: RepositoryVulnerabilityAlert.() -> Unit) =
        RepositoryVulnerabilityAlert("...on RepositoryVulnerabilityAlert").also { doInit(it, init) }
}

class RepositoryOwner(__name: String = "RepositoryOwner"): ObjectNode(__name) {
    fun avatarUrl(size: Int? = null) =
        ScalarWithArgsNode("avatarUrl", mapOf("size" to size)).also { doInit(it) }
    val avatarUrl get() =
        ScalarNode("avatarUrl").also { doInit(it) }
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val login get() =
        ScalarNode("login").also { doInit(it) }
    fun repositories(affiliations: RepositoryAffiliation? = null, after: String? = null, before: String? = null, first: Int? = null, isFork: Boolean? = null, isLocked: Boolean? = null, last: Int? = null, orderBy: RepositoryOrder? = null, ownerAffiliations: RepositoryAffiliation? = null, privacy: RepositoryPrivacy? = null, init: RepositoryConnection.() -> Unit) =
        RepositoryConnection("repositories").apply { addArgs("affiliations", affiliations) }.apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("isFork", isFork) }.apply { addArgs("isLocked", isLocked) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.apply { addArgs("ownerAffiliations", ownerAffiliations) }.apply { addArgs("privacy", privacy) }.also { doInit(it, init) }
    fun repository(name: String, init: Repository.() -> Unit) =
        Repository("repository").apply { addArgs("name", name) }.also { doInit(it, init) }
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    fun `on Organization`(init: Organization.() -> Unit) =
        Organization("...on Organization").also { doInit(it, init) }
    fun `on User`(init: User.() -> Unit) =
        User("...on User").also { doInit(it, init) }
}

class Sponsorable(__name: String = "Sponsorable"): ObjectNode(__name) {
    fun sponsorsListing(init: SponsorsListing.() -> Unit) =
        SponsorsListing("sponsorsListing").also { doInit(it, init) }
    fun sponsorshipsAsMaintainer(after: String? = null, before: String? = null, first: Int? = null, includePrivate: Boolean? = null, last: Int? = null, orderBy: SponsorshipOrder? = null, init: SponsorshipConnection.() -> Unit) =
        SponsorshipConnection("sponsorshipsAsMaintainer").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("includePrivate", includePrivate) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun sponsorshipsAsSponsor(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: SponsorshipOrder? = null, init: SponsorshipConnection.() -> Unit) =
        SponsorshipConnection("sponsorshipsAsSponsor").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    fun `on Organization`(init: Organization.() -> Unit) =
        Organization("...on Organization").also { doInit(it, init) }
    fun `on User`(init: User.() -> Unit) =
        User("...on User").also { doInit(it, init) }
}

class Starrable(__name: String = "Starrable"): ObjectNode(__name) {
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val stargazerCount get() =
        ScalarNode("stargazerCount").also { doInit(it) }
    fun stargazers(after: String? = null, before: String? = null, first: Int? = null, last: Int? = null, orderBy: StarOrder? = null, init: StargazerConnection.() -> Unit) =
        StargazerConnection("stargazers").apply { addArgs("after", after) }.apply { addArgs("before", before) }.apply { addArgs("first", first) }.apply { addArgs("last", last) }.apply { addArgs("orderBy", orderBy) }.also { doInit(it, init) }
    val viewerHasStarred get() =
        ScalarNode("viewerHasStarred").also { doInit(it) }
    fun `on Gist`(init: Gist.() -> Unit) =
        Gist("...on Gist").also { doInit(it, init) }
    fun `on Repository`(init: Repository.() -> Unit) =
        Repository("...on Repository").also { doInit(it, init) }
    fun `on Topic`(init: Topic.() -> Unit) =
        Topic("...on Topic").also { doInit(it, init) }
}

class Subscribable(__name: String = "Subscribable"): ObjectNode(__name) {
    val id get() =
        ScalarNode("id").also { doInit(it) }
    val viewerCanSubscribe get() =
        ScalarNode("viewerCanSubscribe").also { doInit(it) }
    val viewerSubscription get() =
        ScalarNode("viewerSubscription").also { doInit(it) }
    fun `on Commit`(init: Commit.() -> Unit) =
        Commit("...on Commit").also { doInit(it, init) }
    fun `on Issue`(init: Issue.() -> Unit) =
        Issue("...on Issue").also { doInit(it, init) }
    fun `on PullRequest`(init: PullRequest.() -> Unit) =
        PullRequest("...on PullRequest").also { doInit(it, init) }
    fun `on Repository`(init: Repository.() -> Unit) =
        Repository("...on Repository").also { doInit(it, init) }
    fun `on Team`(init: Team.() -> Unit) =
        Team("...on Team").also { doInit(it, init) }
    fun `on TeamDiscussion`(init: TeamDiscussion.() -> Unit) =
        TeamDiscussion("...on TeamDiscussion").also { doInit(it, init) }
}

class TeamAuditEntryData(__name: String = "TeamAuditEntryData"): ObjectNode(__name) {
    fun team(init: Team.() -> Unit) =
        Team("team").also { doInit(it, init) }
    val teamName get() =
        ScalarNode("teamName").also { doInit(it) }
    val teamResourcePath get() =
        ScalarNode("teamResourcePath").also { doInit(it) }
    val teamUrl get() =
        ScalarNode("teamUrl").also { doInit(it) }
    fun `on OrgRestoreMemberMembershipTeamAuditEntryData`(init: OrgRestoreMemberMembershipTeamAuditEntryData.() -> Unit) =
        OrgRestoreMemberMembershipTeamAuditEntryData("...on OrgRestoreMemberMembershipTeamAuditEntryData").also { doInit(it, init) }
    fun `on TeamAddMemberAuditEntry`(init: TeamAddMemberAuditEntry.() -> Unit) =
        TeamAddMemberAuditEntry("...on TeamAddMemberAuditEntry").also { doInit(it, init) }
    fun `on TeamAddRepositoryAuditEntry`(init: TeamAddRepositoryAuditEntry.() -> Unit) =
        TeamAddRepositoryAuditEntry("...on TeamAddRepositoryAuditEntry").also { doInit(it, init) }
    fun `on TeamChangeParentTeamAuditEntry`(init: TeamChangeParentTeamAuditEntry.() -> Unit) =
        TeamChangeParentTeamAuditEntry("...on TeamChangeParentTeamAuditEntry").also { doInit(it, init) }
    fun `on TeamRemoveMemberAuditEntry`(init: TeamRemoveMemberAuditEntry.() -> Unit) =
        TeamRemoveMemberAuditEntry("...on TeamRemoveMemberAuditEntry").also { doInit(it, init) }
    fun `on TeamRemoveRepositoryAuditEntry`(init: TeamRemoveRepositoryAuditEntry.() -> Unit) =
        TeamRemoveRepositoryAuditEntry("...on TeamRemoveRepositoryAuditEntry").also { doInit(it, init) }
}

class TopicAuditEntryData(__name: String = "TopicAuditEntryData"): ObjectNode(__name) {
    fun topic(init: Topic.() -> Unit) =
        Topic("topic").also { doInit(it, init) }
    val topicName get() =
        ScalarNode("topicName").also { doInit(it) }
    fun `on RepoAddTopicAuditEntry`(init: RepoAddTopicAuditEntry.() -> Unit) =
        RepoAddTopicAuditEntry("...on RepoAddTopicAuditEntry").also { doInit(it, init) }
    fun `on RepoRemoveTopicAuditEntry`(init: RepoRemoveTopicAuditEntry.() -> Unit) =
        RepoRemoveTopicAuditEntry("...on RepoRemoveTopicAuditEntry").also { doInit(it, init) }
}

class UniformResourceLocatable(__name: String = "UniformResourceLocatable"): ObjectNode(__name) {
    val resourcePath get() =
        ScalarNode("resourcePath").also { doInit(it) }
    val url get() =
        ScalarNode("url").also { doInit(it) }
    fun `on Bot`(init: Bot.() -> Unit) =
        Bot("...on Bot").also { doInit(it, init) }
    fun `on CheckRun`(init: CheckRun.() -> Unit) =
        CheckRun("...on CheckRun").also { doInit(it, init) }
    fun `on ClosedEvent`(init: ClosedEvent.() -> Unit) =
        ClosedEvent("...on ClosedEvent").also { doInit(it, init) }
    fun `on Commit`(init: Commit.() -> Unit) =
        Commit("...on Commit").also { doInit(it, init) }
    fun `on ConvertToDraftEvent`(init: ConvertToDraftEvent.() -> Unit) =
        ConvertToDraftEvent("...on ConvertToDraftEvent").also { doInit(it, init) }
    fun `on CrossReferencedEvent`(init: CrossReferencedEvent.() -> Unit) =
        CrossReferencedEvent("...on CrossReferencedEvent").also { doInit(it, init) }
    fun `on Gist`(init: Gist.() -> Unit) =
        Gist("...on Gist").also { doInit(it, init) }
    fun `on Issue`(init: Issue.() -> Unit) =
        Issue("...on Issue").also { doInit(it, init) }
    fun `on Mannequin`(init: Mannequin.() -> Unit) =
        Mannequin("...on Mannequin").also { doInit(it, init) }
    fun `on MergedEvent`(init: MergedEvent.() -> Unit) =
        MergedEvent("...on MergedEvent").also { doInit(it, init) }
    fun `on Milestone`(init: Milestone.() -> Unit) =
        Milestone("...on Milestone").also { doInit(it, init) }
    fun `on Organization`(init: Organization.() -> Unit) =
        Organization("...on Organization").also { doInit(it, init) }
    fun `on PullRequest`(init: PullRequest.() -> Unit) =
        PullRequest("...on PullRequest").also { doInit(it, init) }
    fun `on PullRequestCommit`(init: PullRequestCommit.() -> Unit) =
        PullRequestCommit("...on PullRequestCommit").also { doInit(it, init) }
    fun `on ReadyForReviewEvent`(init: ReadyForReviewEvent.() -> Unit) =
        ReadyForReviewEvent("...on ReadyForReviewEvent").also { doInit(it, init) }
    fun `on Release`(init: Release.() -> Unit) =
        Release("...on Release").also { doInit(it, init) }
    fun `on Repository`(init: Repository.() -> Unit) =
        Repository("...on Repository").also { doInit(it, init) }
    fun `on RepositoryTopic`(init: RepositoryTopic.() -> Unit) =
        RepositoryTopic("...on RepositoryTopic").also { doInit(it, init) }
    fun `on ReviewDismissedEvent`(init: ReviewDismissedEvent.() -> Unit) =
        ReviewDismissedEvent("...on ReviewDismissedEvent").also { doInit(it, init) }
    fun `on TeamDiscussion`(init: TeamDiscussion.() -> Unit) =
        TeamDiscussion("...on TeamDiscussion").also { doInit(it, init) }
    fun `on TeamDiscussionComment`(init: TeamDiscussionComment.() -> Unit) =
        TeamDiscussionComment("...on TeamDiscussionComment").also { doInit(it, init) }
    fun `on User`(init: User.() -> Unit) =
        User("...on User").also { doInit(it, init) }
}

class Updatable(__name: String = "Updatable"): ObjectNode(__name) {
    val viewerCanUpdate get() =
        ScalarNode("viewerCanUpdate").also { doInit(it) }
    fun `on CommitComment`(init: CommitComment.() -> Unit) =
        CommitComment("...on CommitComment").also { doInit(it, init) }
    fun `on GistComment`(init: GistComment.() -> Unit) =
        GistComment("...on GistComment").also { doInit(it, init) }
    fun `on Issue`(init: Issue.() -> Unit) =
        Issue("...on Issue").also { doInit(it, init) }
    fun `on IssueComment`(init: IssueComment.() -> Unit) =
        IssueComment("...on IssueComment").also { doInit(it, init) }
    fun `on Project`(init: Project.() -> Unit) =
        Project("...on Project").also { doInit(it, init) }
    fun `on PullRequest`(init: PullRequest.() -> Unit) =
        PullRequest("...on PullRequest").also { doInit(it, init) }
    fun `on PullRequestReview`(init: PullRequestReview.() -> Unit) =
        PullRequestReview("...on PullRequestReview").also { doInit(it, init) }
    fun `on PullRequestReviewComment`(init: PullRequestReviewComment.() -> Unit) =
        PullRequestReviewComment("...on PullRequestReviewComment").also { doInit(it, init) }
    fun `on TeamDiscussion`(init: TeamDiscussion.() -> Unit) =
        TeamDiscussion("...on TeamDiscussion").also { doInit(it, init) }
    fun `on TeamDiscussionComment`(init: TeamDiscussionComment.() -> Unit) =
        TeamDiscussionComment("...on TeamDiscussionComment").also { doInit(it, init) }
}

class UpdatableComment(__name: String = "UpdatableComment"): ObjectNode(__name) {
    val viewerCannotUpdateReasons get() =
        ScalarNode("viewerCannotUpdateReasons").also { doInit(it) }
    fun `on CommitComment`(init: CommitComment.() -> Unit) =
        CommitComment("...on CommitComment").also { doInit(it, init) }
    fun `on GistComment`(init: GistComment.() -> Unit) =
        GistComment("...on GistComment").also { doInit(it, init) }
    fun `on Issue`(init: Issue.() -> Unit) =
        Issue("...on Issue").also { doInit(it, init) }
    fun `on IssueComment`(init: IssueComment.() -> Unit) =
        IssueComment("...on IssueComment").also { doInit(it, init) }
    fun `on PullRequest`(init: PullRequest.() -> Unit) =
        PullRequest("...on PullRequest").also { doInit(it, init) }
    fun `on PullRequestReview`(init: PullRequestReview.() -> Unit) =
        PullRequestReview("...on PullRequestReview").also { doInit(it, init) }
    fun `on PullRequestReviewComment`(init: PullRequestReviewComment.() -> Unit) =
        PullRequestReviewComment("...on PullRequestReviewComment").also { doInit(it, init) }
    fun `on TeamDiscussion`(init: TeamDiscussion.() -> Unit) =
        TeamDiscussion("...on TeamDiscussion").also { doInit(it, init) }
    fun `on TeamDiscussionComment`(init: TeamDiscussionComment.() -> Unit) =
        TeamDiscussionComment("...on TeamDiscussionComment").also { doInit(it, init) }
}

class Assignee(__name: String = "Assignee"): ObjectNode(__name) {
    fun `on Bot`(init: Bot.() -> Unit) =
        Bot("...on Bot").also { doInit(it, init) }
    fun `on Mannequin`(init: Mannequin.() -> Unit) =
        Mannequin("...on Mannequin").also { doInit(it, init) }
    fun `on Organization`(init: Organization.() -> Unit) =
        Organization("...on Organization").also { doInit(it, init) }
    fun `on User`(init: User.() -> Unit) =
        User("...on User").also { doInit(it, init) }
}

class AuditEntryActor(__name: String = "AuditEntryActor"): ObjectNode(__name) {
    fun `on Bot`(init: Bot.() -> Unit) =
        Bot("...on Bot").also { doInit(it, init) }
    fun `on Organization`(init: Organization.() -> Unit) =
        Organization("...on Organization").also { doInit(it, init) }
    fun `on User`(init: User.() -> Unit) =
        User("...on User").also { doInit(it, init) }
}

class Closer(__name: String = "Closer"): ObjectNode(__name) {
    fun `on Commit`(init: Commit.() -> Unit) =
        Commit("...on Commit").also { doInit(it, init) }
    fun `on PullRequest`(init: PullRequest.() -> Unit) =
        PullRequest("...on PullRequest").also { doInit(it, init) }
}

class CreatedIssueOrRestrictedContribution(__name: String = "CreatedIssueOrRestrictedContribution"): ObjectNode(__name) {
    fun `on CreatedIssueContribution`(init: CreatedIssueContribution.() -> Unit) =
        CreatedIssueContribution("...on CreatedIssueContribution").also { doInit(it, init) }
    fun `on RestrictedContribution`(init: RestrictedContribution.() -> Unit) =
        RestrictedContribution("...on RestrictedContribution").also { doInit(it, init) }
}

class CreatedPullRequestOrRestrictedContribution(__name: String = "CreatedPullRequestOrRestrictedContribution"): ObjectNode(__name) {
    fun `on CreatedPullRequestContribution`(init: CreatedPullRequestContribution.() -> Unit) =
        CreatedPullRequestContribution("...on CreatedPullRequestContribution").also { doInit(it, init) }
    fun `on RestrictedContribution`(init: RestrictedContribution.() -> Unit) =
        RestrictedContribution("...on RestrictedContribution").also { doInit(it, init) }
}

class CreatedRepositoryOrRestrictedContribution(__name: String = "CreatedRepositoryOrRestrictedContribution"): ObjectNode(__name) {
    fun `on CreatedRepositoryContribution`(init: CreatedRepositoryContribution.() -> Unit) =
        CreatedRepositoryContribution("...on CreatedRepositoryContribution").also { doInit(it, init) }
    fun `on RestrictedContribution`(init: RestrictedContribution.() -> Unit) =
        RestrictedContribution("...on RestrictedContribution").also { doInit(it, init) }
}

class EnterpriseMember(__name: String = "EnterpriseMember"): ObjectNode(__name) {
    fun `on EnterpriseUserAccount`(init: EnterpriseUserAccount.() -> Unit) =
        EnterpriseUserAccount("...on EnterpriseUserAccount").also { doInit(it, init) }
    fun `on User`(init: User.() -> Unit) =
        User("...on User").also { doInit(it, init) }
}

class IpAllowListOwner(__name: String = "IpAllowListOwner"): ObjectNode(__name) {
    fun `on Enterprise`(init: Enterprise.() -> Unit) =
        Enterprise("...on Enterprise").also { doInit(it, init) }
    fun `on Organization`(init: Organization.() -> Unit) =
        Organization("...on Organization").also { doInit(it, init) }
}

class IssueOrPullRequest(__name: String = "IssueOrPullRequest"): ObjectNode(__name) {
    fun `on Issue`(init: Issue.() -> Unit) =
        Issue("...on Issue").also { doInit(it, init) }
    fun `on PullRequest`(init: PullRequest.() -> Unit) =
        PullRequest("...on PullRequest").also { doInit(it, init) }
}

class IssueTimelineItem(__name: String = "IssueTimelineItem"): ObjectNode(__name) {
    fun `on AssignedEvent`(init: AssignedEvent.() -> Unit) =
        AssignedEvent("...on AssignedEvent").also { doInit(it, init) }
    fun `on ClosedEvent`(init: ClosedEvent.() -> Unit) =
        ClosedEvent("...on ClosedEvent").also { doInit(it, init) }
    fun `on Commit`(init: Commit.() -> Unit) =
        Commit("...on Commit").also { doInit(it, init) }
    fun `on CrossReferencedEvent`(init: CrossReferencedEvent.() -> Unit) =
        CrossReferencedEvent("...on CrossReferencedEvent").also { doInit(it, init) }
    fun `on DemilestonedEvent`(init: DemilestonedEvent.() -> Unit) =
        DemilestonedEvent("...on DemilestonedEvent").also { doInit(it, init) }
    fun `on IssueComment`(init: IssueComment.() -> Unit) =
        IssueComment("...on IssueComment").also { doInit(it, init) }
    fun `on LabeledEvent`(init: LabeledEvent.() -> Unit) =
        LabeledEvent("...on LabeledEvent").also { doInit(it, init) }
    fun `on LockedEvent`(init: LockedEvent.() -> Unit) =
        LockedEvent("...on LockedEvent").also { doInit(it, init) }
    fun `on MilestonedEvent`(init: MilestonedEvent.() -> Unit) =
        MilestonedEvent("...on MilestonedEvent").also { doInit(it, init) }
    fun `on ReferencedEvent`(init: ReferencedEvent.() -> Unit) =
        ReferencedEvent("...on ReferencedEvent").also { doInit(it, init) }
    fun `on RenamedTitleEvent`(init: RenamedTitleEvent.() -> Unit) =
        RenamedTitleEvent("...on RenamedTitleEvent").also { doInit(it, init) }
    fun `on ReopenedEvent`(init: ReopenedEvent.() -> Unit) =
        ReopenedEvent("...on ReopenedEvent").also { doInit(it, init) }
    fun `on SubscribedEvent`(init: SubscribedEvent.() -> Unit) =
        SubscribedEvent("...on SubscribedEvent").also { doInit(it, init) }
    fun `on TransferredEvent`(init: TransferredEvent.() -> Unit) =
        TransferredEvent("...on TransferredEvent").also { doInit(it, init) }
    fun `on UnassignedEvent`(init: UnassignedEvent.() -> Unit) =
        UnassignedEvent("...on UnassignedEvent").also { doInit(it, init) }
    fun `on UnlabeledEvent`(init: UnlabeledEvent.() -> Unit) =
        UnlabeledEvent("...on UnlabeledEvent").also { doInit(it, init) }
    fun `on UnlockedEvent`(init: UnlockedEvent.() -> Unit) =
        UnlockedEvent("...on UnlockedEvent").also { doInit(it, init) }
    fun `on UnsubscribedEvent`(init: UnsubscribedEvent.() -> Unit) =
        UnsubscribedEvent("...on UnsubscribedEvent").also { doInit(it, init) }
    fun `on UserBlockedEvent`(init: UserBlockedEvent.() -> Unit) =
        UserBlockedEvent("...on UserBlockedEvent").also { doInit(it, init) }
}

class IssueTimelineItems(__name: String = "IssueTimelineItems"): ObjectNode(__name) {
    fun `on AddedToProjectEvent`(init: AddedToProjectEvent.() -> Unit) =
        AddedToProjectEvent("...on AddedToProjectEvent").also { doInit(it, init) }
    fun `on AssignedEvent`(init: AssignedEvent.() -> Unit) =
        AssignedEvent("...on AssignedEvent").also { doInit(it, init) }
    fun `on ClosedEvent`(init: ClosedEvent.() -> Unit) =
        ClosedEvent("...on ClosedEvent").also { doInit(it, init) }
    fun `on CommentDeletedEvent`(init: CommentDeletedEvent.() -> Unit) =
        CommentDeletedEvent("...on CommentDeletedEvent").also { doInit(it, init) }
    fun `on ConnectedEvent`(init: ConnectedEvent.() -> Unit) =
        ConnectedEvent("...on ConnectedEvent").also { doInit(it, init) }
    fun `on ConvertedNoteToIssueEvent`(init: ConvertedNoteToIssueEvent.() -> Unit) =
        ConvertedNoteToIssueEvent("...on ConvertedNoteToIssueEvent").also { doInit(it, init) }
    fun `on CrossReferencedEvent`(init: CrossReferencedEvent.() -> Unit) =
        CrossReferencedEvent("...on CrossReferencedEvent").also { doInit(it, init) }
    fun `on DemilestonedEvent`(init: DemilestonedEvent.() -> Unit) =
        DemilestonedEvent("...on DemilestonedEvent").also { doInit(it, init) }
    fun `on DisconnectedEvent`(init: DisconnectedEvent.() -> Unit) =
        DisconnectedEvent("...on DisconnectedEvent").also { doInit(it, init) }
    fun `on IssueComment`(init: IssueComment.() -> Unit) =
        IssueComment("...on IssueComment").also { doInit(it, init) }
    fun `on LabeledEvent`(init: LabeledEvent.() -> Unit) =
        LabeledEvent("...on LabeledEvent").also { doInit(it, init) }
    fun `on LockedEvent`(init: LockedEvent.() -> Unit) =
        LockedEvent("...on LockedEvent").also { doInit(it, init) }
    fun `on MarkedAsDuplicateEvent`(init: MarkedAsDuplicateEvent.() -> Unit) =
        MarkedAsDuplicateEvent("...on MarkedAsDuplicateEvent").also { doInit(it, init) }
    fun `on MentionedEvent`(init: MentionedEvent.() -> Unit) =
        MentionedEvent("...on MentionedEvent").also { doInit(it, init) }
    fun `on MilestonedEvent`(init: MilestonedEvent.() -> Unit) =
        MilestonedEvent("...on MilestonedEvent").also { doInit(it, init) }
    fun `on MovedColumnsInProjectEvent`(init: MovedColumnsInProjectEvent.() -> Unit) =
        MovedColumnsInProjectEvent("...on MovedColumnsInProjectEvent").also { doInit(it, init) }
    fun `on PinnedEvent`(init: PinnedEvent.() -> Unit) =
        PinnedEvent("...on PinnedEvent").also { doInit(it, init) }
    fun `on ReferencedEvent`(init: ReferencedEvent.() -> Unit) =
        ReferencedEvent("...on ReferencedEvent").also { doInit(it, init) }
    fun `on RemovedFromProjectEvent`(init: RemovedFromProjectEvent.() -> Unit) =
        RemovedFromProjectEvent("...on RemovedFromProjectEvent").also { doInit(it, init) }
    fun `on RenamedTitleEvent`(init: RenamedTitleEvent.() -> Unit) =
        RenamedTitleEvent("...on RenamedTitleEvent").also { doInit(it, init) }
    fun `on ReopenedEvent`(init: ReopenedEvent.() -> Unit) =
        ReopenedEvent("...on ReopenedEvent").also { doInit(it, init) }
    fun `on SubscribedEvent`(init: SubscribedEvent.() -> Unit) =
        SubscribedEvent("...on SubscribedEvent").also { doInit(it, init) }
    fun `on TransferredEvent`(init: TransferredEvent.() -> Unit) =
        TransferredEvent("...on TransferredEvent").also { doInit(it, init) }
    fun `on UnassignedEvent`(init: UnassignedEvent.() -> Unit) =
        UnassignedEvent("...on UnassignedEvent").also { doInit(it, init) }
    fun `on UnlabeledEvent`(init: UnlabeledEvent.() -> Unit) =
        UnlabeledEvent("...on UnlabeledEvent").also { doInit(it, init) }
    fun `on UnlockedEvent`(init: UnlockedEvent.() -> Unit) =
        UnlockedEvent("...on UnlockedEvent").also { doInit(it, init) }
    fun `on UnmarkedAsDuplicateEvent`(init: UnmarkedAsDuplicateEvent.() -> Unit) =
        UnmarkedAsDuplicateEvent("...on UnmarkedAsDuplicateEvent").also { doInit(it, init) }
    fun `on UnpinnedEvent`(init: UnpinnedEvent.() -> Unit) =
        UnpinnedEvent("...on UnpinnedEvent").also { doInit(it, init) }
    fun `on UnsubscribedEvent`(init: UnsubscribedEvent.() -> Unit) =
        UnsubscribedEvent("...on UnsubscribedEvent").also { doInit(it, init) }
    fun `on UserBlockedEvent`(init: UserBlockedEvent.() -> Unit) =
        UserBlockedEvent("...on UserBlockedEvent").also { doInit(it, init) }
}

class MilestoneItem(__name: String = "MilestoneItem"): ObjectNode(__name) {
    fun `on Issue`(init: Issue.() -> Unit) =
        Issue("...on Issue").also { doInit(it, init) }
    fun `on PullRequest`(init: PullRequest.() -> Unit) =
        PullRequest("...on PullRequest").also { doInit(it, init) }
}

class OrgRestoreMemberAuditEntryMembership(__name: String = "OrgRestoreMemberAuditEntryMembership"): ObjectNode(__name) {
    fun `on OrgRestoreMemberMembershipOrganizationAuditEntryData`(init: OrgRestoreMemberMembershipOrganizationAuditEntryData.() -> Unit) =
        OrgRestoreMemberMembershipOrganizationAuditEntryData("...on OrgRestoreMemberMembershipOrganizationAuditEntryData").also { doInit(it, init) }
    fun `on OrgRestoreMemberMembershipRepositoryAuditEntryData`(init: OrgRestoreMemberMembershipRepositoryAuditEntryData.() -> Unit) =
        OrgRestoreMemberMembershipRepositoryAuditEntryData("...on OrgRestoreMemberMembershipRepositoryAuditEntryData").also { doInit(it, init) }
    fun `on OrgRestoreMemberMembershipTeamAuditEntryData`(init: OrgRestoreMemberMembershipTeamAuditEntryData.() -> Unit) =
        OrgRestoreMemberMembershipTeamAuditEntryData("...on OrgRestoreMemberMembershipTeamAuditEntryData").also { doInit(it, init) }
}

class OrganizationAuditEntry(__name: String = "OrganizationAuditEntry"): ObjectNode(__name) {
    fun `on MembersCanDeleteReposClearAuditEntry`(init: MembersCanDeleteReposClearAuditEntry.() -> Unit) =
        MembersCanDeleteReposClearAuditEntry("...on MembersCanDeleteReposClearAuditEntry").also { doInit(it, init) }
    fun `on MembersCanDeleteReposDisableAuditEntry`(init: MembersCanDeleteReposDisableAuditEntry.() -> Unit) =
        MembersCanDeleteReposDisableAuditEntry("...on MembersCanDeleteReposDisableAuditEntry").also { doInit(it, init) }
    fun `on MembersCanDeleteReposEnableAuditEntry`(init: MembersCanDeleteReposEnableAuditEntry.() -> Unit) =
        MembersCanDeleteReposEnableAuditEntry("...on MembersCanDeleteReposEnableAuditEntry").also { doInit(it, init) }
    fun `on OauthApplicationCreateAuditEntry`(init: OauthApplicationCreateAuditEntry.() -> Unit) =
        OauthApplicationCreateAuditEntry("...on OauthApplicationCreateAuditEntry").also { doInit(it, init) }
    fun `on OrgAddBillingManagerAuditEntry`(init: OrgAddBillingManagerAuditEntry.() -> Unit) =
        OrgAddBillingManagerAuditEntry("...on OrgAddBillingManagerAuditEntry").also { doInit(it, init) }
    fun `on OrgAddMemberAuditEntry`(init: OrgAddMemberAuditEntry.() -> Unit) =
        OrgAddMemberAuditEntry("...on OrgAddMemberAuditEntry").also { doInit(it, init) }
    fun `on OrgBlockUserAuditEntry`(init: OrgBlockUserAuditEntry.() -> Unit) =
        OrgBlockUserAuditEntry("...on OrgBlockUserAuditEntry").also { doInit(it, init) }
    fun `on OrgConfigDisableCollaboratorsOnlyAuditEntry`(init: OrgConfigDisableCollaboratorsOnlyAuditEntry.() -> Unit) =
        OrgConfigDisableCollaboratorsOnlyAuditEntry("...on OrgConfigDisableCollaboratorsOnlyAuditEntry").also { doInit(it, init) }
    fun `on OrgConfigEnableCollaboratorsOnlyAuditEntry`(init: OrgConfigEnableCollaboratorsOnlyAuditEntry.() -> Unit) =
        OrgConfigEnableCollaboratorsOnlyAuditEntry("...on OrgConfigEnableCollaboratorsOnlyAuditEntry").also { doInit(it, init) }
    fun `on OrgCreateAuditEntry`(init: OrgCreateAuditEntry.() -> Unit) =
        OrgCreateAuditEntry("...on OrgCreateAuditEntry").also { doInit(it, init) }
    fun `on OrgDisableOauthAppRestrictionsAuditEntry`(init: OrgDisableOauthAppRestrictionsAuditEntry.() -> Unit) =
        OrgDisableOauthAppRestrictionsAuditEntry("...on OrgDisableOauthAppRestrictionsAuditEntry").also { doInit(it, init) }
    fun `on OrgDisableSamlAuditEntry`(init: OrgDisableSamlAuditEntry.() -> Unit) =
        OrgDisableSamlAuditEntry("...on OrgDisableSamlAuditEntry").also { doInit(it, init) }
    fun `on OrgDisableTwoFactorRequirementAuditEntry`(init: OrgDisableTwoFactorRequirementAuditEntry.() -> Unit) =
        OrgDisableTwoFactorRequirementAuditEntry("...on OrgDisableTwoFactorRequirementAuditEntry").also { doInit(it, init) }
    fun `on OrgEnableOauthAppRestrictionsAuditEntry`(init: OrgEnableOauthAppRestrictionsAuditEntry.() -> Unit) =
        OrgEnableOauthAppRestrictionsAuditEntry("...on OrgEnableOauthAppRestrictionsAuditEntry").also { doInit(it, init) }
    fun `on OrgEnableSamlAuditEntry`(init: OrgEnableSamlAuditEntry.() -> Unit) =
        OrgEnableSamlAuditEntry("...on OrgEnableSamlAuditEntry").also { doInit(it, init) }
    fun `on OrgEnableTwoFactorRequirementAuditEntry`(init: OrgEnableTwoFactorRequirementAuditEntry.() -> Unit) =
        OrgEnableTwoFactorRequirementAuditEntry("...on OrgEnableTwoFactorRequirementAuditEntry").also { doInit(it, init) }
    fun `on OrgInviteMemberAuditEntry`(init: OrgInviteMemberAuditEntry.() -> Unit) =
        OrgInviteMemberAuditEntry("...on OrgInviteMemberAuditEntry").also { doInit(it, init) }
    fun `on OrgInviteToBusinessAuditEntry`(init: OrgInviteToBusinessAuditEntry.() -> Unit) =
        OrgInviteToBusinessAuditEntry("...on OrgInviteToBusinessAuditEntry").also { doInit(it, init) }
    fun `on OrgOauthAppAccessApprovedAuditEntry`(init: OrgOauthAppAccessApprovedAuditEntry.() -> Unit) =
        OrgOauthAppAccessApprovedAuditEntry("...on OrgOauthAppAccessApprovedAuditEntry").also { doInit(it, init) }
    fun `on OrgOauthAppAccessDeniedAuditEntry`(init: OrgOauthAppAccessDeniedAuditEntry.() -> Unit) =
        OrgOauthAppAccessDeniedAuditEntry("...on OrgOauthAppAccessDeniedAuditEntry").also { doInit(it, init) }
    fun `on OrgOauthAppAccessRequestedAuditEntry`(init: OrgOauthAppAccessRequestedAuditEntry.() -> Unit) =
        OrgOauthAppAccessRequestedAuditEntry("...on OrgOauthAppAccessRequestedAuditEntry").also { doInit(it, init) }
    fun `on OrgRemoveBillingManagerAuditEntry`(init: OrgRemoveBillingManagerAuditEntry.() -> Unit) =
        OrgRemoveBillingManagerAuditEntry("...on OrgRemoveBillingManagerAuditEntry").also { doInit(it, init) }
    fun `on OrgRemoveMemberAuditEntry`(init: OrgRemoveMemberAuditEntry.() -> Unit) =
        OrgRemoveMemberAuditEntry("...on OrgRemoveMemberAuditEntry").also { doInit(it, init) }
    fun `on OrgRemoveOutsideCollaboratorAuditEntry`(init: OrgRemoveOutsideCollaboratorAuditEntry.() -> Unit) =
        OrgRemoveOutsideCollaboratorAuditEntry("...on OrgRemoveOutsideCollaboratorAuditEntry").also { doInit(it, init) }
    fun `on OrgRestoreMemberAuditEntry`(init: OrgRestoreMemberAuditEntry.() -> Unit) =
        OrgRestoreMemberAuditEntry("...on OrgRestoreMemberAuditEntry").also { doInit(it, init) }
    fun `on OrgUnblockUserAuditEntry`(init: OrgUnblockUserAuditEntry.() -> Unit) =
        OrgUnblockUserAuditEntry("...on OrgUnblockUserAuditEntry").also { doInit(it, init) }
    fun `on OrgUpdateDefaultRepositoryPermissionAuditEntry`(init: OrgUpdateDefaultRepositoryPermissionAuditEntry.() -> Unit) =
        OrgUpdateDefaultRepositoryPermissionAuditEntry("...on OrgUpdateDefaultRepositoryPermissionAuditEntry").also { doInit(it, init) }
    fun `on OrgUpdateMemberAuditEntry`(init: OrgUpdateMemberAuditEntry.() -> Unit) =
        OrgUpdateMemberAuditEntry("...on OrgUpdateMemberAuditEntry").also { doInit(it, init) }
    fun `on OrgUpdateMemberRepositoryCreationPermissionAuditEntry`(init: OrgUpdateMemberRepositoryCreationPermissionAuditEntry.() -> Unit) =
        OrgUpdateMemberRepositoryCreationPermissionAuditEntry("...on OrgUpdateMemberRepositoryCreationPermissionAuditEntry").also { doInit(it, init) }
    fun `on OrgUpdateMemberRepositoryInvitationPermissionAuditEntry`(init: OrgUpdateMemberRepositoryInvitationPermissionAuditEntry.() -> Unit) =
        OrgUpdateMemberRepositoryInvitationPermissionAuditEntry("...on OrgUpdateMemberRepositoryInvitationPermissionAuditEntry").also { doInit(it, init) }
    fun `on PrivateRepositoryForkingDisableAuditEntry`(init: PrivateRepositoryForkingDisableAuditEntry.() -> Unit) =
        PrivateRepositoryForkingDisableAuditEntry("...on PrivateRepositoryForkingDisableAuditEntry").also { doInit(it, init) }
    fun `on PrivateRepositoryForkingEnableAuditEntry`(init: PrivateRepositoryForkingEnableAuditEntry.() -> Unit) =
        PrivateRepositoryForkingEnableAuditEntry("...on PrivateRepositoryForkingEnableAuditEntry").also { doInit(it, init) }
    fun `on RepoAccessAuditEntry`(init: RepoAccessAuditEntry.() -> Unit) =
        RepoAccessAuditEntry("...on RepoAccessAuditEntry").also { doInit(it, init) }
    fun `on RepoAddMemberAuditEntry`(init: RepoAddMemberAuditEntry.() -> Unit) =
        RepoAddMemberAuditEntry("...on RepoAddMemberAuditEntry").also { doInit(it, init) }
    fun `on RepoAddTopicAuditEntry`(init: RepoAddTopicAuditEntry.() -> Unit) =
        RepoAddTopicAuditEntry("...on RepoAddTopicAuditEntry").also { doInit(it, init) }
    fun `on RepoArchivedAuditEntry`(init: RepoArchivedAuditEntry.() -> Unit) =
        RepoArchivedAuditEntry("...on RepoArchivedAuditEntry").also { doInit(it, init) }
    fun `on RepoChangeMergeSettingAuditEntry`(init: RepoChangeMergeSettingAuditEntry.() -> Unit) =
        RepoChangeMergeSettingAuditEntry("...on RepoChangeMergeSettingAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigDisableAnonymousGitAccessAuditEntry`(init: RepoConfigDisableAnonymousGitAccessAuditEntry.() -> Unit) =
        RepoConfigDisableAnonymousGitAccessAuditEntry("...on RepoConfigDisableAnonymousGitAccessAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigDisableCollaboratorsOnlyAuditEntry`(init: RepoConfigDisableCollaboratorsOnlyAuditEntry.() -> Unit) =
        RepoConfigDisableCollaboratorsOnlyAuditEntry("...on RepoConfigDisableCollaboratorsOnlyAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigDisableContributorsOnlyAuditEntry`(init: RepoConfigDisableContributorsOnlyAuditEntry.() -> Unit) =
        RepoConfigDisableContributorsOnlyAuditEntry("...on RepoConfigDisableContributorsOnlyAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigDisableSockpuppetDisallowedAuditEntry`(init: RepoConfigDisableSockpuppetDisallowedAuditEntry.() -> Unit) =
        RepoConfigDisableSockpuppetDisallowedAuditEntry("...on RepoConfigDisableSockpuppetDisallowedAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigEnableAnonymousGitAccessAuditEntry`(init: RepoConfigEnableAnonymousGitAccessAuditEntry.() -> Unit) =
        RepoConfigEnableAnonymousGitAccessAuditEntry("...on RepoConfigEnableAnonymousGitAccessAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigEnableCollaboratorsOnlyAuditEntry`(init: RepoConfigEnableCollaboratorsOnlyAuditEntry.() -> Unit) =
        RepoConfigEnableCollaboratorsOnlyAuditEntry("...on RepoConfigEnableCollaboratorsOnlyAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigEnableContributorsOnlyAuditEntry`(init: RepoConfigEnableContributorsOnlyAuditEntry.() -> Unit) =
        RepoConfigEnableContributorsOnlyAuditEntry("...on RepoConfigEnableContributorsOnlyAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigEnableSockpuppetDisallowedAuditEntry`(init: RepoConfigEnableSockpuppetDisallowedAuditEntry.() -> Unit) =
        RepoConfigEnableSockpuppetDisallowedAuditEntry("...on RepoConfigEnableSockpuppetDisallowedAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigLockAnonymousGitAccessAuditEntry`(init: RepoConfigLockAnonymousGitAccessAuditEntry.() -> Unit) =
        RepoConfigLockAnonymousGitAccessAuditEntry("...on RepoConfigLockAnonymousGitAccessAuditEntry").also { doInit(it, init) }
    fun `on RepoConfigUnlockAnonymousGitAccessAuditEntry`(init: RepoConfigUnlockAnonymousGitAccessAuditEntry.() -> Unit) =
        RepoConfigUnlockAnonymousGitAccessAuditEntry("...on RepoConfigUnlockAnonymousGitAccessAuditEntry").also { doInit(it, init) }
    fun `on RepoCreateAuditEntry`(init: RepoCreateAuditEntry.() -> Unit) =
        RepoCreateAuditEntry("...on RepoCreateAuditEntry").also { doInit(it, init) }
    fun `on RepoDestroyAuditEntry`(init: RepoDestroyAuditEntry.() -> Unit) =
        RepoDestroyAuditEntry("...on RepoDestroyAuditEntry").also { doInit(it, init) }
    fun `on RepoRemoveMemberAuditEntry`(init: RepoRemoveMemberAuditEntry.() -> Unit) =
        RepoRemoveMemberAuditEntry("...on RepoRemoveMemberAuditEntry").also { doInit(it, init) }
    fun `on RepoRemoveTopicAuditEntry`(init: RepoRemoveTopicAuditEntry.() -> Unit) =
        RepoRemoveTopicAuditEntry("...on RepoRemoveTopicAuditEntry").also { doInit(it, init) }
    fun `on RepositoryVisibilityChangeDisableAuditEntry`(init: RepositoryVisibilityChangeDisableAuditEntry.() -> Unit) =
        RepositoryVisibilityChangeDisableAuditEntry("...on RepositoryVisibilityChangeDisableAuditEntry").also { doInit(it, init) }
    fun `on RepositoryVisibilityChangeEnableAuditEntry`(init: RepositoryVisibilityChangeEnableAuditEntry.() -> Unit) =
        RepositoryVisibilityChangeEnableAuditEntry("...on RepositoryVisibilityChangeEnableAuditEntry").also { doInit(it, init) }
    fun `on TeamAddMemberAuditEntry`(init: TeamAddMemberAuditEntry.() -> Unit) =
        TeamAddMemberAuditEntry("...on TeamAddMemberAuditEntry").also { doInit(it, init) }
    fun `on TeamAddRepositoryAuditEntry`(init: TeamAddRepositoryAuditEntry.() -> Unit) =
        TeamAddRepositoryAuditEntry("...on TeamAddRepositoryAuditEntry").also { doInit(it, init) }
    fun `on TeamChangeParentTeamAuditEntry`(init: TeamChangeParentTeamAuditEntry.() -> Unit) =
        TeamChangeParentTeamAuditEntry("...on TeamChangeParentTeamAuditEntry").also { doInit(it, init) }
    fun `on TeamRemoveMemberAuditEntry`(init: TeamRemoveMemberAuditEntry.() -> Unit) =
        TeamRemoveMemberAuditEntry("...on TeamRemoveMemberAuditEntry").also { doInit(it, init) }
    fun `on TeamRemoveRepositoryAuditEntry`(init: TeamRemoveRepositoryAuditEntry.() -> Unit) =
        TeamRemoveRepositoryAuditEntry("...on TeamRemoveRepositoryAuditEntry").also { doInit(it, init) }
}

class PermissionGranter(__name: String = "PermissionGranter"): ObjectNode(__name) {
    fun `on Organization`(init: Organization.() -> Unit) =
        Organization("...on Organization").also { doInit(it, init) }
    fun `on Repository`(init: Repository.() -> Unit) =
        Repository("...on Repository").also { doInit(it, init) }
    fun `on Team`(init: Team.() -> Unit) =
        Team("...on Team").also { doInit(it, init) }
}

class PinnableItem(__name: String = "PinnableItem"): ObjectNode(__name) {
    fun `on Gist`(init: Gist.() -> Unit) =
        Gist("...on Gist").also { doInit(it, init) }
    fun `on Repository`(init: Repository.() -> Unit) =
        Repository("...on Repository").also { doInit(it, init) }
}

class ProjectCardItem(__name: String = "ProjectCardItem"): ObjectNode(__name) {
    fun `on Issue`(init: Issue.() -> Unit) =
        Issue("...on Issue").also { doInit(it, init) }
    fun `on PullRequest`(init: PullRequest.() -> Unit) =
        PullRequest("...on PullRequest").also { doInit(it, init) }
}

class PullRequestTimelineItem(__name: String = "PullRequestTimelineItem"): ObjectNode(__name) {
    fun `on AssignedEvent`(init: AssignedEvent.() -> Unit) =
        AssignedEvent("...on AssignedEvent").also { doInit(it, init) }
    fun `on BaseRefDeletedEvent`(init: BaseRefDeletedEvent.() -> Unit) =
        BaseRefDeletedEvent("...on BaseRefDeletedEvent").also { doInit(it, init) }
    fun `on BaseRefForcePushedEvent`(init: BaseRefForcePushedEvent.() -> Unit) =
        BaseRefForcePushedEvent("...on BaseRefForcePushedEvent").also { doInit(it, init) }
    fun `on ClosedEvent`(init: ClosedEvent.() -> Unit) =
        ClosedEvent("...on ClosedEvent").also { doInit(it, init) }
    fun `on Commit`(init: Commit.() -> Unit) =
        Commit("...on Commit").also { doInit(it, init) }
    fun `on CommitCommentThread`(init: CommitCommentThread.() -> Unit) =
        CommitCommentThread("...on CommitCommentThread").also { doInit(it, init) }
    fun `on CrossReferencedEvent`(init: CrossReferencedEvent.() -> Unit) =
        CrossReferencedEvent("...on CrossReferencedEvent").also { doInit(it, init) }
    fun `on DemilestonedEvent`(init: DemilestonedEvent.() -> Unit) =
        DemilestonedEvent("...on DemilestonedEvent").also { doInit(it, init) }
    fun `on DeployedEvent`(init: DeployedEvent.() -> Unit) =
        DeployedEvent("...on DeployedEvent").also { doInit(it, init) }
    fun `on DeploymentEnvironmentChangedEvent`(init: DeploymentEnvironmentChangedEvent.() -> Unit) =
        DeploymentEnvironmentChangedEvent("...on DeploymentEnvironmentChangedEvent").also { doInit(it, init) }
    fun `on HeadRefDeletedEvent`(init: HeadRefDeletedEvent.() -> Unit) =
        HeadRefDeletedEvent("...on HeadRefDeletedEvent").also { doInit(it, init) }
    fun `on HeadRefForcePushedEvent`(init: HeadRefForcePushedEvent.() -> Unit) =
        HeadRefForcePushedEvent("...on HeadRefForcePushedEvent").also { doInit(it, init) }
    fun `on HeadRefRestoredEvent`(init: HeadRefRestoredEvent.() -> Unit) =
        HeadRefRestoredEvent("...on HeadRefRestoredEvent").also { doInit(it, init) }
    fun `on IssueComment`(init: IssueComment.() -> Unit) =
        IssueComment("...on IssueComment").also { doInit(it, init) }
    fun `on LabeledEvent`(init: LabeledEvent.() -> Unit) =
        LabeledEvent("...on LabeledEvent").also { doInit(it, init) }
    fun `on LockedEvent`(init: LockedEvent.() -> Unit) =
        LockedEvent("...on LockedEvent").also { doInit(it, init) }
    fun `on MergedEvent`(init: MergedEvent.() -> Unit) =
        MergedEvent("...on MergedEvent").also { doInit(it, init) }
    fun `on MilestonedEvent`(init: MilestonedEvent.() -> Unit) =
        MilestonedEvent("...on MilestonedEvent").also { doInit(it, init) }
    fun `on PullRequestReview`(init: PullRequestReview.() -> Unit) =
        PullRequestReview("...on PullRequestReview").also { doInit(it, init) }
    fun `on PullRequestReviewComment`(init: PullRequestReviewComment.() -> Unit) =
        PullRequestReviewComment("...on PullRequestReviewComment").also { doInit(it, init) }
    fun `on PullRequestReviewThread`(init: PullRequestReviewThread.() -> Unit) =
        PullRequestReviewThread("...on PullRequestReviewThread").also { doInit(it, init) }
    fun `on ReferencedEvent`(init: ReferencedEvent.() -> Unit) =
        ReferencedEvent("...on ReferencedEvent").also { doInit(it, init) }
    fun `on RenamedTitleEvent`(init: RenamedTitleEvent.() -> Unit) =
        RenamedTitleEvent("...on RenamedTitleEvent").also { doInit(it, init) }
    fun `on ReopenedEvent`(init: ReopenedEvent.() -> Unit) =
        ReopenedEvent("...on ReopenedEvent").also { doInit(it, init) }
    fun `on ReviewDismissedEvent`(init: ReviewDismissedEvent.() -> Unit) =
        ReviewDismissedEvent("...on ReviewDismissedEvent").also { doInit(it, init) }
    fun `on ReviewRequestRemovedEvent`(init: ReviewRequestRemovedEvent.() -> Unit) =
        ReviewRequestRemovedEvent("...on ReviewRequestRemovedEvent").also { doInit(it, init) }
    fun `on ReviewRequestedEvent`(init: ReviewRequestedEvent.() -> Unit) =
        ReviewRequestedEvent("...on ReviewRequestedEvent").also { doInit(it, init) }
    fun `on SubscribedEvent`(init: SubscribedEvent.() -> Unit) =
        SubscribedEvent("...on SubscribedEvent").also { doInit(it, init) }
    fun `on UnassignedEvent`(init: UnassignedEvent.() -> Unit) =
        UnassignedEvent("...on UnassignedEvent").also { doInit(it, init) }
    fun `on UnlabeledEvent`(init: UnlabeledEvent.() -> Unit) =
        UnlabeledEvent("...on UnlabeledEvent").also { doInit(it, init) }
    fun `on UnlockedEvent`(init: UnlockedEvent.() -> Unit) =
        UnlockedEvent("...on UnlockedEvent").also { doInit(it, init) }
    fun `on UnsubscribedEvent`(init: UnsubscribedEvent.() -> Unit) =
        UnsubscribedEvent("...on UnsubscribedEvent").also { doInit(it, init) }
    fun `on UserBlockedEvent`(init: UserBlockedEvent.() -> Unit) =
        UserBlockedEvent("...on UserBlockedEvent").also { doInit(it, init) }
}

class PullRequestTimelineItems(__name: String = "PullRequestTimelineItems"): ObjectNode(__name) {
    fun `on AddedToProjectEvent`(init: AddedToProjectEvent.() -> Unit) =
        AddedToProjectEvent("...on AddedToProjectEvent").also { doInit(it, init) }
    fun `on AssignedEvent`(init: AssignedEvent.() -> Unit) =
        AssignedEvent("...on AssignedEvent").also { doInit(it, init) }
    fun `on AutomaticBaseChangeFailedEvent`(init: AutomaticBaseChangeFailedEvent.() -> Unit) =
        AutomaticBaseChangeFailedEvent("...on AutomaticBaseChangeFailedEvent").also { doInit(it, init) }
    fun `on AutomaticBaseChangeSucceededEvent`(init: AutomaticBaseChangeSucceededEvent.() -> Unit) =
        AutomaticBaseChangeSucceededEvent("...on AutomaticBaseChangeSucceededEvent").also { doInit(it, init) }
    fun `on BaseRefChangedEvent`(init: BaseRefChangedEvent.() -> Unit) =
        BaseRefChangedEvent("...on BaseRefChangedEvent").also { doInit(it, init) }
    fun `on BaseRefDeletedEvent`(init: BaseRefDeletedEvent.() -> Unit) =
        BaseRefDeletedEvent("...on BaseRefDeletedEvent").also { doInit(it, init) }
    fun `on BaseRefForcePushedEvent`(init: BaseRefForcePushedEvent.() -> Unit) =
        BaseRefForcePushedEvent("...on BaseRefForcePushedEvent").also { doInit(it, init) }
    fun `on ClosedEvent`(init: ClosedEvent.() -> Unit) =
        ClosedEvent("...on ClosedEvent").also { doInit(it, init) }
    fun `on CommentDeletedEvent`(init: CommentDeletedEvent.() -> Unit) =
        CommentDeletedEvent("...on CommentDeletedEvent").also { doInit(it, init) }
    fun `on ConnectedEvent`(init: ConnectedEvent.() -> Unit) =
        ConnectedEvent("...on ConnectedEvent").also { doInit(it, init) }
    fun `on ConvertToDraftEvent`(init: ConvertToDraftEvent.() -> Unit) =
        ConvertToDraftEvent("...on ConvertToDraftEvent").also { doInit(it, init) }
    fun `on ConvertedNoteToIssueEvent`(init: ConvertedNoteToIssueEvent.() -> Unit) =
        ConvertedNoteToIssueEvent("...on ConvertedNoteToIssueEvent").also { doInit(it, init) }
    fun `on CrossReferencedEvent`(init: CrossReferencedEvent.() -> Unit) =
        CrossReferencedEvent("...on CrossReferencedEvent").also { doInit(it, init) }
    fun `on DemilestonedEvent`(init: DemilestonedEvent.() -> Unit) =
        DemilestonedEvent("...on DemilestonedEvent").also { doInit(it, init) }
    fun `on DeployedEvent`(init: DeployedEvent.() -> Unit) =
        DeployedEvent("...on DeployedEvent").also { doInit(it, init) }
    fun `on DeploymentEnvironmentChangedEvent`(init: DeploymentEnvironmentChangedEvent.() -> Unit) =
        DeploymentEnvironmentChangedEvent("...on DeploymentEnvironmentChangedEvent").also { doInit(it, init) }
    fun `on DisconnectedEvent`(init: DisconnectedEvent.() -> Unit) =
        DisconnectedEvent("...on DisconnectedEvent").also { doInit(it, init) }
    fun `on HeadRefDeletedEvent`(init: HeadRefDeletedEvent.() -> Unit) =
        HeadRefDeletedEvent("...on HeadRefDeletedEvent").also { doInit(it, init) }
    fun `on HeadRefForcePushedEvent`(init: HeadRefForcePushedEvent.() -> Unit) =
        HeadRefForcePushedEvent("...on HeadRefForcePushedEvent").also { doInit(it, init) }
    fun `on HeadRefRestoredEvent`(init: HeadRefRestoredEvent.() -> Unit) =
        HeadRefRestoredEvent("...on HeadRefRestoredEvent").also { doInit(it, init) }
    fun `on IssueComment`(init: IssueComment.() -> Unit) =
        IssueComment("...on IssueComment").also { doInit(it, init) }
    fun `on LabeledEvent`(init: LabeledEvent.() -> Unit) =
        LabeledEvent("...on LabeledEvent").also { doInit(it, init) }
    fun `on LockedEvent`(init: LockedEvent.() -> Unit) =
        LockedEvent("...on LockedEvent").also { doInit(it, init) }
    fun `on MarkedAsDuplicateEvent`(init: MarkedAsDuplicateEvent.() -> Unit) =
        MarkedAsDuplicateEvent("...on MarkedAsDuplicateEvent").also { doInit(it, init) }
    fun `on MentionedEvent`(init: MentionedEvent.() -> Unit) =
        MentionedEvent("...on MentionedEvent").also { doInit(it, init) }
    fun `on MergedEvent`(init: MergedEvent.() -> Unit) =
        MergedEvent("...on MergedEvent").also { doInit(it, init) }
    fun `on MilestonedEvent`(init: MilestonedEvent.() -> Unit) =
        MilestonedEvent("...on MilestonedEvent").also { doInit(it, init) }
    fun `on MovedColumnsInProjectEvent`(init: MovedColumnsInProjectEvent.() -> Unit) =
        MovedColumnsInProjectEvent("...on MovedColumnsInProjectEvent").also { doInit(it, init) }
    fun `on PinnedEvent`(init: PinnedEvent.() -> Unit) =
        PinnedEvent("...on PinnedEvent").also { doInit(it, init) }
    fun `on PullRequestCommit`(init: PullRequestCommit.() -> Unit) =
        PullRequestCommit("...on PullRequestCommit").also { doInit(it, init) }
    fun `on PullRequestCommitCommentThread`(init: PullRequestCommitCommentThread.() -> Unit) =
        PullRequestCommitCommentThread("...on PullRequestCommitCommentThread").also { doInit(it, init) }
    fun `on PullRequestReview`(init: PullRequestReview.() -> Unit) =
        PullRequestReview("...on PullRequestReview").also { doInit(it, init) }
    fun `on PullRequestReviewThread`(init: PullRequestReviewThread.() -> Unit) =
        PullRequestReviewThread("...on PullRequestReviewThread").also { doInit(it, init) }
    fun `on PullRequestRevisionMarker`(init: PullRequestRevisionMarker.() -> Unit) =
        PullRequestRevisionMarker("...on PullRequestRevisionMarker").also { doInit(it, init) }
    fun `on ReadyForReviewEvent`(init: ReadyForReviewEvent.() -> Unit) =
        ReadyForReviewEvent("...on ReadyForReviewEvent").also { doInit(it, init) }
    fun `on ReferencedEvent`(init: ReferencedEvent.() -> Unit) =
        ReferencedEvent("...on ReferencedEvent").also { doInit(it, init) }
    fun `on RemovedFromProjectEvent`(init: RemovedFromProjectEvent.() -> Unit) =
        RemovedFromProjectEvent("...on RemovedFromProjectEvent").also { doInit(it, init) }
    fun `on RenamedTitleEvent`(init: RenamedTitleEvent.() -> Unit) =
        RenamedTitleEvent("...on RenamedTitleEvent").also { doInit(it, init) }
    fun `on ReopenedEvent`(init: ReopenedEvent.() -> Unit) =
        ReopenedEvent("...on ReopenedEvent").also { doInit(it, init) }
    fun `on ReviewDismissedEvent`(init: ReviewDismissedEvent.() -> Unit) =
        ReviewDismissedEvent("...on ReviewDismissedEvent").also { doInit(it, init) }
    fun `on ReviewRequestRemovedEvent`(init: ReviewRequestRemovedEvent.() -> Unit) =
        ReviewRequestRemovedEvent("...on ReviewRequestRemovedEvent").also { doInit(it, init) }
    fun `on ReviewRequestedEvent`(init: ReviewRequestedEvent.() -> Unit) =
        ReviewRequestedEvent("...on ReviewRequestedEvent").also { doInit(it, init) }
    fun `on SubscribedEvent`(init: SubscribedEvent.() -> Unit) =
        SubscribedEvent("...on SubscribedEvent").also { doInit(it, init) }
    fun `on TransferredEvent`(init: TransferredEvent.() -> Unit) =
        TransferredEvent("...on TransferredEvent").also { doInit(it, init) }
    fun `on UnassignedEvent`(init: UnassignedEvent.() -> Unit) =
        UnassignedEvent("...on UnassignedEvent").also { doInit(it, init) }
    fun `on UnlabeledEvent`(init: UnlabeledEvent.() -> Unit) =
        UnlabeledEvent("...on UnlabeledEvent").also { doInit(it, init) }
    fun `on UnlockedEvent`(init: UnlockedEvent.() -> Unit) =
        UnlockedEvent("...on UnlockedEvent").also { doInit(it, init) }
    fun `on UnmarkedAsDuplicateEvent`(init: UnmarkedAsDuplicateEvent.() -> Unit) =
        UnmarkedAsDuplicateEvent("...on UnmarkedAsDuplicateEvent").also { doInit(it, init) }
    fun `on UnpinnedEvent`(init: UnpinnedEvent.() -> Unit) =
        UnpinnedEvent("...on UnpinnedEvent").also { doInit(it, init) }
    fun `on UnsubscribedEvent`(init: UnsubscribedEvent.() -> Unit) =
        UnsubscribedEvent("...on UnsubscribedEvent").also { doInit(it, init) }
    fun `on UserBlockedEvent`(init: UserBlockedEvent.() -> Unit) =
        UserBlockedEvent("...on UserBlockedEvent").also { doInit(it, init) }
}

class PushAllowanceActor(__name: String = "PushAllowanceActor"): ObjectNode(__name) {
    fun `on App`(init: App.() -> Unit) =
        App("...on App").also { doInit(it, init) }
    fun `on Team`(init: Team.() -> Unit) =
        Team("...on Team").also { doInit(it, init) }
    fun `on User`(init: User.() -> Unit) =
        User("...on User").also { doInit(it, init) }
}

class ReferencedSubject(__name: String = "ReferencedSubject"): ObjectNode(__name) {
    fun `on Issue`(init: Issue.() -> Unit) =
        Issue("...on Issue").also { doInit(it, init) }
    fun `on PullRequest`(init: PullRequest.() -> Unit) =
        PullRequest("...on PullRequest").also { doInit(it, init) }
}

class RenamedTitleSubject(__name: String = "RenamedTitleSubject"): ObjectNode(__name) {
    fun `on Issue`(init: Issue.() -> Unit) =
        Issue("...on Issue").also { doInit(it, init) }
    fun `on PullRequest`(init: PullRequest.() -> Unit) =
        PullRequest("...on PullRequest").also { doInit(it, init) }
}

class RequestedReviewer(__name: String = "RequestedReviewer"): ObjectNode(__name) {
    fun `on Mannequin`(init: Mannequin.() -> Unit) =
        Mannequin("...on Mannequin").also { doInit(it, init) }
    fun `on Team`(init: Team.() -> Unit) =
        Team("...on Team").also { doInit(it, init) }
    fun `on User`(init: User.() -> Unit) =
        User("...on User").also { doInit(it, init) }
}

class ReviewDismissalAllowanceActor(__name: String = "ReviewDismissalAllowanceActor"): ObjectNode(__name) {
    fun `on Team`(init: Team.() -> Unit) =
        Team("...on Team").also { doInit(it, init) }
    fun `on User`(init: User.() -> Unit) =
        User("...on User").also { doInit(it, init) }
}

class SearchResultItem(__name: String = "SearchResultItem"): ObjectNode(__name) {
    fun `on App`(init: App.() -> Unit) =
        App("...on App").also { doInit(it, init) }
    fun `on Issue`(init: Issue.() -> Unit) =
        Issue("...on Issue").also { doInit(it, init) }
    fun `on MarketplaceListing`(init: MarketplaceListing.() -> Unit) =
        MarketplaceListing("...on MarketplaceListing").also { doInit(it, init) }
    fun `on Organization`(init: Organization.() -> Unit) =
        Organization("...on Organization").also { doInit(it, init) }
    fun `on PullRequest`(init: PullRequest.() -> Unit) =
        PullRequest("...on PullRequest").also { doInit(it, init) }
    fun `on Repository`(init: Repository.() -> Unit) =
        Repository("...on Repository").also { doInit(it, init) }
    fun `on User`(init: User.() -> Unit) =
        User("...on User").also { doInit(it, init) }
}

class Sponsor(__name: String = "Sponsor"): ObjectNode(__name) {
    fun `on Organization`(init: Organization.() -> Unit) =
        Organization("...on Organization").also { doInit(it, init) }
    fun `on User`(init: User.() -> Unit) =
        User("...on User").also { doInit(it, init) }
}

class StatusCheckRollupContext(__name: String = "StatusCheckRollupContext"): ObjectNode(__name) {
    fun `on CheckRun`(init: CheckRun.() -> Unit) =
        CheckRun("...on CheckRun").also { doInit(it, init) }
    fun `on StatusContext`(init: StatusContext.() -> Unit) =
        StatusContext("...on StatusContext").also { doInit(it, init) }
}

class AcceptEnterpriseAdministratorInvitationInput(val clientMutationId: String? = null, val invitationId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", invitationId: \"$invitationId\" }"
}

class AcceptTopicSuggestionInput(val clientMutationId: String? = null, val name: String, val repositoryId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", name: \"$name\", repositoryId: \"$repositoryId\" }"
}

class AddAssigneesToAssignableInput(val assignableId: ID, val assigneeIds: ID, val clientMutationId: String? = null) {
    override fun toString() = "{ assignableId: \"$assignableId\", assigneeIds: \"$assigneeIds\", clientMutationId: \"$clientMutationId\" }"
}

class AddCommentInput(val body: String, val clientMutationId: String? = null, val subjectId: ID) {
    override fun toString() = "{ body: \"$body\", clientMutationId: \"$clientMutationId\", subjectId: \"$subjectId\" }"
}

class AddLabelsToLabelableInput(val clientMutationId: String? = null, val labelIds: ID, val labelableId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", labelIds: \"$labelIds\", labelableId: \"$labelableId\" }"
}

class AddProjectCardInput(val clientMutationId: String? = null, val contentId: ID? = null, val note: String? = null, val projectColumnId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", contentId: \"$contentId\", note: \"$note\", projectColumnId: \"$projectColumnId\" }"
}

class AddProjectColumnInput(val clientMutationId: String? = null, val name: String, val projectId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", name: \"$name\", projectId: \"$projectId\" }"
}

class AddPullRequestReviewCommentInput(val body: String, val clientMutationId: String? = null, val commitOID: GitObjectID? = null, val inReplyTo: ID? = null, val path: String? = null, val position: Int? = null, val pullRequestId: ID? = null, val pullRequestReviewId: ID? = null) {
    override fun toString() = "{ body: \"$body\", clientMutationId: \"$clientMutationId\", commitOID: \"$commitOID\", inReplyTo: \"$inReplyTo\", path: \"$path\", position: $position, pullRequestId: \"$pullRequestId\", pullRequestReviewId: \"$pullRequestReviewId\" }"
}

class AddPullRequestReviewInput(val body: String? = null, val clientMutationId: String? = null, val comments: DraftPullRequestReviewComment? = null, val commitOID: GitObjectID? = null, val event: PullRequestReviewEvent? = null, val pullRequestId: ID, val threads: DraftPullRequestReviewThread? = null) {
    override fun toString() = "{ body: \"$body\", clientMutationId: \"$clientMutationId\", comments: $comments, commitOID: \"$commitOID\", event: $event, pullRequestId: \"$pullRequestId\", threads: $threads }"
}

class AddPullRequestReviewThreadInput(val body: String, val clientMutationId: String? = null, val line: Int, val path: String, val pullRequestId: ID? = null, val pullRequestReviewId: ID? = null, val side: DiffSide? = null, val startLine: Int? = null, val startSide: DiffSide? = null) {
    override fun toString() = "{ body: \"$body\", clientMutationId: \"$clientMutationId\", line: $line, path: \"$path\", pullRequestId: \"$pullRequestId\", pullRequestReviewId: \"$pullRequestReviewId\", side: $side, startLine: $startLine, startSide: $startSide }"
}

class AddReactionInput(val clientMutationId: String? = null, val content: ReactionContent, val subjectId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", content: $content, subjectId: \"$subjectId\" }"
}

class AddStarInput(val clientMutationId: String? = null, val starrableId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", starrableId: \"$starrableId\" }"
}

class ArchiveRepositoryInput(val clientMutationId: String? = null, val repositoryId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", repositoryId: \"$repositoryId\" }"
}

class AuditLogOrder(val direction: OrderDirection? = null, val field: AuditLogOrderField? = null) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class CancelEnterpriseAdminInvitationInput(val clientMutationId: String? = null, val invitationId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", invitationId: \"$invitationId\" }"
}

class ChangeUserStatusInput(val clientMutationId: String? = null, val emoji: String? = null, val expiresAt: DateTime? = null, val limitedAvailability: Boolean? = null, val message: String? = null, val organizationId: ID? = null) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", emoji: \"$emoji\", expiresAt: \"$expiresAt\", limitedAvailability: $limitedAvailability, message: \"$message\", organizationId: \"$organizationId\" }"
}

class CheckAnnotationData(val annotationLevel: CheckAnnotationLevel, val location: CheckAnnotationRange, val message: String, val path: String, val rawDetails: String? = null, val title: String? = null) {
    override fun toString() = "{ annotationLevel: $annotationLevel, location: $location, message: \"$message\", path: \"$path\", rawDetails: \"$rawDetails\", title: \"$title\" }"
}

class CheckAnnotationRange(val endColumn: Int? = null, val endLine: Int, val startColumn: Int? = null, val startLine: Int) {
    override fun toString() = "{ endColumn: $endColumn, endLine: $endLine, startColumn: $startColumn, startLine: $startLine }"
}

class CheckRunAction(val description: String, val identifier: String, val label: String) {
    override fun toString() = "{ description: \"$description\", identifier: \"$identifier\", label: \"$label\" }"
}

class CheckRunFilter(val appId: Int? = null, val checkName: String? = null, val checkType: CheckRunType? = null, val status: CheckStatusState? = null) {
    override fun toString() = "{ appId: $appId, checkName: \"$checkName\", checkType: $checkType, status: $status }"
}

class CheckRunOutput(val annotations: CheckAnnotationData? = null, val images: CheckRunOutputImage? = null, val summary: String, val text: String? = null, val title: String) {
    override fun toString() = "{ annotations: $annotations, images: $images, summary: \"$summary\", text: \"$text\", title: \"$title\" }"
}

class CheckRunOutputImage(val alt: String, val caption: String? = null, val imageUrl: URI) {
    override fun toString() = "{ alt: \"$alt\", caption: \"$caption\", imageUrl: \"$imageUrl\" }"
}

class CheckSuiteAutoTriggerPreference(val appId: ID, val setting: Boolean) {
    override fun toString() = "{ appId: \"$appId\", setting: $setting }"
}

class CheckSuiteFilter(val appId: Int? = null, val checkName: String? = null) {
    override fun toString() = "{ appId: $appId, checkName: \"$checkName\" }"
}

class ClearLabelsFromLabelableInput(val clientMutationId: String? = null, val labelableId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", labelableId: \"$labelableId\" }"
}

class CloneProjectInput(val body: String? = null, val clientMutationId: String? = null, val includeWorkflows: Boolean, val name: String, val public: Boolean? = null, val sourceId: ID, val targetOwnerId: ID) {
    override fun toString() = "{ body: \"$body\", clientMutationId: \"$clientMutationId\", includeWorkflows: $includeWorkflows, name: \"$name\", public: $public, sourceId: \"$sourceId\", targetOwnerId: \"$targetOwnerId\" }"
}

class CloneTemplateRepositoryInput(val clientMutationId: String? = null, val description: String? = null, val includeAllBranches: Boolean? = null, val name: String, val ownerId: ID, val repositoryId: ID, val visibility: RepositoryVisibility) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", description: \"$description\", includeAllBranches: $includeAllBranches, name: \"$name\", ownerId: \"$ownerId\", repositoryId: \"$repositoryId\", visibility: $visibility }"
}

class CloseIssueInput(val clientMutationId: String? = null, val issueId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", issueId: \"$issueId\" }"
}

class ClosePullRequestInput(val clientMutationId: String? = null, val pullRequestId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", pullRequestId: \"$pullRequestId\" }"
}

class CommitAuthor(val emails: String? = null, val id: ID? = null) {
    override fun toString() = "{ emails: \"$emails\", id: \"$id\" }"
}

class CommitContributionOrder(val direction: OrderDirection, val field: CommitContributionOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class ContributionOrder(val direction: OrderDirection) {
    override fun toString() = "{ direction: $direction }"
}

class ConvertProjectCardNoteToIssueInput(val body: String? = null, val clientMutationId: String? = null, val projectCardId: ID, val repositoryId: ID, val title: String? = null) {
    override fun toString() = "{ body: \"$body\", clientMutationId: \"$clientMutationId\", projectCardId: \"$projectCardId\", repositoryId: \"$repositoryId\", title: \"$title\" }"
}

class CreateBranchProtectionRuleInput(val allowsDeletions: Boolean? = null, val allowsForcePushes: Boolean? = null, val clientMutationId: String? = null, val dismissesStaleReviews: Boolean? = null, val isAdminEnforced: Boolean? = null, val pattern: String, val pushActorIds: ID? = null, val repositoryId: ID, val requiredApprovingReviewCount: Int? = null, val requiredStatusCheckContexts: String? = null, val requiresApprovingReviews: Boolean? = null, val requiresCodeOwnerReviews: Boolean? = null, val requiresCommitSignatures: Boolean? = null, val requiresLinearHistory: Boolean? = null, val requiresStatusChecks: Boolean? = null, val requiresStrictStatusChecks: Boolean? = null, val restrictsPushes: Boolean? = null, val restrictsReviewDismissals: Boolean? = null, val reviewDismissalActorIds: ID? = null) {
    override fun toString() = "{ allowsDeletions: $allowsDeletions, allowsForcePushes: $allowsForcePushes, clientMutationId: \"$clientMutationId\", dismissesStaleReviews: $dismissesStaleReviews, isAdminEnforced: $isAdminEnforced, pattern: \"$pattern\", pushActorIds: \"$pushActorIds\", repositoryId: \"$repositoryId\", requiredApprovingReviewCount: $requiredApprovingReviewCount, requiredStatusCheckContexts: \"$requiredStatusCheckContexts\", requiresApprovingReviews: $requiresApprovingReviews, requiresCodeOwnerReviews: $requiresCodeOwnerReviews, requiresCommitSignatures: $requiresCommitSignatures, requiresLinearHistory: $requiresLinearHistory, requiresStatusChecks: $requiresStatusChecks, requiresStrictStatusChecks: $requiresStrictStatusChecks, restrictsPushes: $restrictsPushes, restrictsReviewDismissals: $restrictsReviewDismissals, reviewDismissalActorIds: \"$reviewDismissalActorIds\" }"
}

class CreateCheckRunInput(val actions: CheckRunAction? = null, val clientMutationId: String? = null, val completedAt: DateTime? = null, val conclusion: CheckConclusionState? = null, val detailsUrl: URI? = null, val externalId: String? = null, val headSha: GitObjectID, val name: String, val output: CheckRunOutput? = null, val repositoryId: ID, val startedAt: DateTime? = null, val status: RequestableCheckStatusState? = null) {
    override fun toString() = "{ actions: $actions, clientMutationId: \"$clientMutationId\", completedAt: \"$completedAt\", conclusion: $conclusion, detailsUrl: \"$detailsUrl\", externalId: \"$externalId\", headSha: \"$headSha\", name: \"$name\", output: $output, repositoryId: \"$repositoryId\", startedAt: \"$startedAt\", status: $status }"
}

class CreateCheckSuiteInput(val clientMutationId: String? = null, val headSha: GitObjectID, val repositoryId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", headSha: \"$headSha\", repositoryId: \"$repositoryId\" }"
}

class CreateContentAttachmentInput(val body: String, val clientMutationId: String? = null, val contentReferenceId: ID, val title: String) {
    override fun toString() = "{ body: \"$body\", clientMutationId: \"$clientMutationId\", contentReferenceId: \"$contentReferenceId\", title: \"$title\" }"
}

class CreateDeploymentInput(val autoMerge: Boolean? = null, val clientMutationId: String? = null, val description: String? = null, val environment: String? = null, val payload: String? = null, val refId: ID, val repositoryId: ID, val requiredContexts: String? = null, val task: String? = null) {
    override fun toString() = "{ autoMerge: $autoMerge, clientMutationId: \"$clientMutationId\", description: \"$description\", environment: \"$environment\", payload: \"$payload\", refId: \"$refId\", repositoryId: \"$repositoryId\", requiredContexts: \"$requiredContexts\", task: \"$task\" }"
}

class CreateDeploymentStatusInput(val autoInactive: Boolean? = null, val clientMutationId: String? = null, val deploymentId: ID, val description: String? = null, val environment: String? = null, val environmentUrl: String? = null, val logUrl: String? = null, val state: DeploymentStatusState) {
    override fun toString() = "{ autoInactive: $autoInactive, clientMutationId: \"$clientMutationId\", deploymentId: \"$deploymentId\", description: \"$description\", environment: \"$environment\", environmentUrl: \"$environmentUrl\", logUrl: \"$logUrl\", state: $state }"
}

class CreateEnterpriseOrganizationInput(val adminLogins: String, val billingEmail: String, val clientMutationId: String? = null, val enterpriseId: ID, val login: String, val profileName: String) {
    override fun toString() = "{ adminLogins: \"$adminLogins\", billingEmail: \"$billingEmail\", clientMutationId: \"$clientMutationId\", enterpriseId: \"$enterpriseId\", login: \"$login\", profileName: \"$profileName\" }"
}

class CreateIpAllowListEntryInput(val allowListValue: String, val clientMutationId: String? = null, val isActive: Boolean, val name: String? = null, val ownerId: ID) {
    override fun toString() = "{ allowListValue: \"$allowListValue\", clientMutationId: \"$clientMutationId\", isActive: $isActive, name: \"$name\", ownerId: \"$ownerId\" }"
}

class CreateIssueInput(val assigneeIds: ID? = null, val body: String? = null, val clientMutationId: String? = null, val issueTemplate: String? = null, val labelIds: ID? = null, val milestoneId: ID? = null, val projectIds: ID? = null, val repositoryId: ID, val title: String) {
    override fun toString() = "{ assigneeIds: \"$assigneeIds\", body: \"$body\", clientMutationId: \"$clientMutationId\", issueTemplate: \"$issueTemplate\", labelIds: \"$labelIds\", milestoneId: \"$milestoneId\", projectIds: \"$projectIds\", repositoryId: \"$repositoryId\", title: \"$title\" }"
}

class CreateLabelInput(val clientMutationId: String? = null, val color: String, val description: String? = null, val name: String, val repositoryId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", color: \"$color\", description: \"$description\", name: \"$name\", repositoryId: \"$repositoryId\" }"
}

class CreateProjectInput(val body: String? = null, val clientMutationId: String? = null, val name: String, val ownerId: ID, val repositoryIds: ID? = null, val template: ProjectTemplate? = null) {
    override fun toString() = "{ body: \"$body\", clientMutationId: \"$clientMutationId\", name: \"$name\", ownerId: \"$ownerId\", repositoryIds: \"$repositoryIds\", template: $template }"
}

class CreatePullRequestInput(val baseRefName: String, val body: String? = null, val clientMutationId: String? = null, val draft: Boolean? = null, val headRefName: String, val maintainerCanModify: Boolean? = null, val repositoryId: ID, val title: String) {
    override fun toString() = "{ baseRefName: \"$baseRefName\", body: \"$body\", clientMutationId: \"$clientMutationId\", draft: $draft, headRefName: \"$headRefName\", maintainerCanModify: $maintainerCanModify, repositoryId: \"$repositoryId\", title: \"$title\" }"
}

class CreateRefInput(val clientMutationId: String? = null, val name: String, val oid: GitObjectID, val repositoryId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", name: \"$name\", oid: \"$oid\", repositoryId: \"$repositoryId\" }"
}

class CreateRepositoryInput(val clientMutationId: String? = null, val description: String? = null, val hasIssuesEnabled: Boolean? = null, val hasWikiEnabled: Boolean? = null, val homepageUrl: URI? = null, val name: String, val ownerId: ID? = null, val teamId: ID? = null, val template: Boolean? = null, val visibility: RepositoryVisibility) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", description: \"$description\", hasIssuesEnabled: $hasIssuesEnabled, hasWikiEnabled: $hasWikiEnabled, homepageUrl: \"$homepageUrl\", name: \"$name\", ownerId: \"$ownerId\", teamId: \"$teamId\", template: $template, visibility: $visibility }"
}

class CreateTeamDiscussionCommentInput(val body: String, val clientMutationId: String? = null, val discussionId: ID) {
    override fun toString() = "{ body: \"$body\", clientMutationId: \"$clientMutationId\", discussionId: \"$discussionId\" }"
}

class CreateTeamDiscussionInput(val body: String, val clientMutationId: String? = null, val private: Boolean? = null, val teamId: ID, val title: String) {
    override fun toString() = "{ body: \"$body\", clientMutationId: \"$clientMutationId\", private: $private, teamId: \"$teamId\", title: \"$title\" }"
}

class DeclineTopicSuggestionInput(val clientMutationId: String? = null, val name: String, val reason: TopicSuggestionDeclineReason, val repositoryId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", name: \"$name\", reason: $reason, repositoryId: \"$repositoryId\" }"
}

class DeleteBranchProtectionRuleInput(val branchProtectionRuleId: ID, val clientMutationId: String? = null) {
    override fun toString() = "{ branchProtectionRuleId: \"$branchProtectionRuleId\", clientMutationId: \"$clientMutationId\" }"
}

class DeleteDeploymentInput(val clientMutationId: String? = null, val id: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", id: \"$id\" }"
}

class DeleteIpAllowListEntryInput(val clientMutationId: String? = null, val ipAllowListEntryId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", ipAllowListEntryId: \"$ipAllowListEntryId\" }"
}

class DeleteIssueCommentInput(val clientMutationId: String? = null, val id: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", id: \"$id\" }"
}

class DeleteIssueInput(val clientMutationId: String? = null, val issueId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", issueId: \"$issueId\" }"
}

class DeleteLabelInput(val clientMutationId: String? = null, val id: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", id: \"$id\" }"
}

class DeletePackageVersionInput(val clientMutationId: String? = null, val packageVersionId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", packageVersionId: \"$packageVersionId\" }"
}

class DeleteProjectCardInput(val cardId: ID, val clientMutationId: String? = null) {
    override fun toString() = "{ cardId: \"$cardId\", clientMutationId: \"$clientMutationId\" }"
}

class DeleteProjectColumnInput(val clientMutationId: String? = null, val columnId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", columnId: \"$columnId\" }"
}

class DeleteProjectInput(val clientMutationId: String? = null, val projectId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", projectId: \"$projectId\" }"
}

class DeletePullRequestReviewCommentInput(val clientMutationId: String? = null, val id: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", id: \"$id\" }"
}

class DeletePullRequestReviewInput(val clientMutationId: String? = null, val pullRequestReviewId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", pullRequestReviewId: \"$pullRequestReviewId\" }"
}

class DeleteRefInput(val clientMutationId: String? = null, val refId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", refId: \"$refId\" }"
}

class DeleteTeamDiscussionCommentInput(val clientMutationId: String? = null, val id: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", id: \"$id\" }"
}

class DeleteTeamDiscussionInput(val clientMutationId: String? = null, val id: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", id: \"$id\" }"
}

class DeploymentOrder(val direction: OrderDirection, val field: DeploymentOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class DismissPullRequestReviewInput(val clientMutationId: String? = null, val message: String, val pullRequestReviewId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", message: \"$message\", pullRequestReviewId: \"$pullRequestReviewId\" }"
}

class DraftPullRequestReviewComment(val body: String, val path: String, val position: Int) {
    override fun toString() = "{ body: \"$body\", path: \"$path\", position: $position }"
}

class DraftPullRequestReviewThread(val body: String, val line: Int, val path: String, val side: DiffSide? = null, val startLine: Int? = null, val startSide: DiffSide? = null) {
    override fun toString() = "{ body: \"$body\", line: $line, path: \"$path\", side: $side, startLine: $startLine, startSide: $startSide }"
}

class EnterpriseAdministratorInvitationOrder(val direction: OrderDirection, val field: EnterpriseAdministratorInvitationOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class EnterpriseMemberOrder(val direction: OrderDirection, val field: EnterpriseMemberOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class EnterpriseServerInstallationOrder(val direction: OrderDirection, val field: EnterpriseServerInstallationOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class EnterpriseServerUserAccountEmailOrder(val direction: OrderDirection, val field: EnterpriseServerUserAccountEmailOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class EnterpriseServerUserAccountOrder(val direction: OrderDirection, val field: EnterpriseServerUserAccountOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class EnterpriseServerUserAccountsUploadOrder(val direction: OrderDirection, val field: EnterpriseServerUserAccountsUploadOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class FollowUserInput(val clientMutationId: String? = null, val userId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", userId: \"$userId\" }"
}

class GistOrder(val direction: OrderDirection, val field: GistOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class ImportProjectInput(val body: String? = null, val clientMutationId: String? = null, val columnImports: ProjectColumnImport, val name: String, val ownerName: String, val public: Boolean? = null) {
    override fun toString() = "{ body: \"$body\", clientMutationId: \"$clientMutationId\", columnImports: $columnImports, name: \"$name\", ownerName: \"$ownerName\", public: $public }"
}

class InviteEnterpriseAdminInput(val clientMutationId: String? = null, val email: String? = null, val enterpriseId: ID, val invitee: String? = null, val role: EnterpriseAdministratorRole? = null) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", email: \"$email\", enterpriseId: \"$enterpriseId\", invitee: \"$invitee\", role: $role }"
}

class IpAllowListEntryOrder(val direction: OrderDirection, val field: IpAllowListEntryOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class IssueFilters(val assignee: String? = null, val createdBy: String? = null, val labels: String? = null, val mentioned: String? = null, val milestone: String? = null, val since: DateTime? = null, val states: IssueState? = null, val viewerSubscribed: Boolean? = null) {
    override fun toString() = "{ assignee: \"$assignee\", createdBy: \"$createdBy\", labels: \"$labels\", mentioned: \"$mentioned\", milestone: \"$milestone\", since: \"$since\", states: $states, viewerSubscribed: $viewerSubscribed }"
}

class IssueOrder(val direction: OrderDirection, val field: IssueOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class LabelOrder(val direction: OrderDirection, val field: LabelOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class LanguageOrder(val direction: OrderDirection, val field: LanguageOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class LinkRepositoryToProjectInput(val clientMutationId: String? = null, val projectId: ID, val repositoryId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", projectId: \"$projectId\", repositoryId: \"$repositoryId\" }"
}

class LockLockableInput(val clientMutationId: String? = null, val lockReason: LockReason? = null, val lockableId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", lockReason: $lockReason, lockableId: \"$lockableId\" }"
}

class MarkFileAsViewedInput(val clientMutationId: String? = null, val path: String, val pullRequestId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", path: \"$path\", pullRequestId: \"$pullRequestId\" }"
}

class MarkPullRequestReadyForReviewInput(val clientMutationId: String? = null, val pullRequestId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", pullRequestId: \"$pullRequestId\" }"
}

class MergeBranchInput(val authorEmail: String? = null, val base: String, val clientMutationId: String? = null, val commitMessage: String? = null, val head: String, val repositoryId: ID) {
    override fun toString() = "{ authorEmail: \"$authorEmail\", base: \"$base\", clientMutationId: \"$clientMutationId\", commitMessage: \"$commitMessage\", head: \"$head\", repositoryId: \"$repositoryId\" }"
}

class MergePullRequestInput(val authorEmail: String? = null, val clientMutationId: String? = null, val commitBody: String? = null, val commitHeadline: String? = null, val expectedHeadOid: GitObjectID? = null, val mergeMethod: PullRequestMergeMethod? = null, val pullRequestId: ID) {
    override fun toString() = "{ authorEmail: \"$authorEmail\", clientMutationId: \"$clientMutationId\", commitBody: \"$commitBody\", commitHeadline: \"$commitHeadline\", expectedHeadOid: \"$expectedHeadOid\", mergeMethod: $mergeMethod, pullRequestId: \"$pullRequestId\" }"
}

class MilestoneOrder(val direction: OrderDirection, val field: MilestoneOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class MinimizeCommentInput(val classifier: ReportedContentClassifiers, val clientMutationId: String? = null, val subjectId: ID) {
    override fun toString() = "{ classifier: $classifier, clientMutationId: \"$clientMutationId\", subjectId: \"$subjectId\" }"
}

class MoveProjectCardInput(val afterCardId: ID? = null, val cardId: ID, val clientMutationId: String? = null, val columnId: ID) {
    override fun toString() = "{ afterCardId: \"$afterCardId\", cardId: \"$cardId\", clientMutationId: \"$clientMutationId\", columnId: \"$columnId\" }"
}

class MoveProjectColumnInput(val afterColumnId: ID? = null, val clientMutationId: String? = null, val columnId: ID) {
    override fun toString() = "{ afterColumnId: \"$afterColumnId\", clientMutationId: \"$clientMutationId\", columnId: \"$columnId\" }"
}

class OrganizationOrder(val direction: OrderDirection, val field: OrganizationOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class PackageFileOrder(val direction: OrderDirection? = null, val field: PackageFileOrderField? = null) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class PackageOrder(val direction: OrderDirection? = null, val field: PackageOrderField? = null) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class PackageVersionOrder(val direction: OrderDirection? = null, val field: PackageVersionOrderField? = null) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class PinIssueInput(val clientMutationId: String? = null, val issueId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", issueId: \"$issueId\" }"
}

class ProjectCardImport(val number: Int, val repository: String) {
    override fun toString() = "{ number: $number, repository: \"$repository\" }"
}

class ProjectColumnImport(val columnName: String, val issues: ProjectCardImport? = null, val position: Int) {
    override fun toString() = "{ columnName: \"$columnName\", issues: $issues, position: $position }"
}

class ProjectOrder(val direction: OrderDirection, val field: ProjectOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class PullRequestOrder(val direction: OrderDirection, val field: PullRequestOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class ReactionOrder(val direction: OrderDirection, val field: ReactionOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class RefOrder(val direction: OrderDirection, val field: RefOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class RefUpdate(val afterOid: GitObjectID, val beforeOid: GitObjectID? = null, val force: Boolean? = null, val name: GitRefname) {
    override fun toString() = "{ afterOid: \"$afterOid\", beforeOid: \"$beforeOid\", force: $force, name: \"$name\" }"
}

class RegenerateEnterpriseIdentityProviderRecoveryCodesInput(val clientMutationId: String? = null, val enterpriseId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", enterpriseId: \"$enterpriseId\" }"
}

class ReleaseOrder(val direction: OrderDirection, val field: ReleaseOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class RemoveAssigneesFromAssignableInput(val assignableId: ID, val assigneeIds: ID, val clientMutationId: String? = null) {
    override fun toString() = "{ assignableId: \"$assignableId\", assigneeIds: \"$assigneeIds\", clientMutationId: \"$clientMutationId\" }"
}

class RemoveEnterpriseAdminInput(val clientMutationId: String? = null, val enterpriseId: ID, val login: String) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", enterpriseId: \"$enterpriseId\", login: \"$login\" }"
}

class RemoveEnterpriseIdentityProviderInput(val clientMutationId: String? = null, val enterpriseId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", enterpriseId: \"$enterpriseId\" }"
}

class RemoveEnterpriseOrganizationInput(val clientMutationId: String? = null, val enterpriseId: ID, val organizationId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", enterpriseId: \"$enterpriseId\", organizationId: \"$organizationId\" }"
}

class RemoveLabelsFromLabelableInput(val clientMutationId: String? = null, val labelIds: ID, val labelableId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", labelIds: \"$labelIds\", labelableId: \"$labelableId\" }"
}

class RemoveOutsideCollaboratorInput(val clientMutationId: String? = null, val organizationId: ID, val userId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", organizationId: \"$organizationId\", userId: \"$userId\" }"
}

class RemoveReactionInput(val clientMutationId: String? = null, val content: ReactionContent, val subjectId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", content: $content, subjectId: \"$subjectId\" }"
}

class RemoveStarInput(val clientMutationId: String? = null, val starrableId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", starrableId: \"$starrableId\" }"
}

class ReopenIssueInput(val clientMutationId: String? = null, val issueId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", issueId: \"$issueId\" }"
}

class ReopenPullRequestInput(val clientMutationId: String? = null, val pullRequestId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", pullRequestId: \"$pullRequestId\" }"
}

class RepositoryInvitationOrder(val direction: OrderDirection, val field: RepositoryInvitationOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class RepositoryOrder(val direction: OrderDirection, val field: RepositoryOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class RequestReviewsInput(val clientMutationId: String? = null, val pullRequestId: ID, val teamIds: ID? = null, val union: Boolean? = null, val userIds: ID? = null) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", pullRequestId: \"$pullRequestId\", teamIds: \"$teamIds\", union: $union, userIds: \"$userIds\" }"
}

class RerequestCheckSuiteInput(val checkSuiteId: ID, val clientMutationId: String? = null, val repositoryId: ID) {
    override fun toString() = "{ checkSuiteId: \"$checkSuiteId\", clientMutationId: \"$clientMutationId\", repositoryId: \"$repositoryId\" }"
}

class ResolveReviewThreadInput(val clientMutationId: String? = null, val threadId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", threadId: \"$threadId\" }"
}

class SavedReplyOrder(val direction: OrderDirection, val field: SavedReplyOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class SecurityAdvisoryIdentifierFilter(val type: SecurityAdvisoryIdentifierType, val value: String) {
    override fun toString() = "{ type: $type, value: \"$value\" }"
}

class SecurityAdvisoryOrder(val direction: OrderDirection, val field: SecurityAdvisoryOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class SecurityVulnerabilityOrder(val direction: OrderDirection, val field: SecurityVulnerabilityOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class SetEnterpriseIdentityProviderInput(val clientMutationId: String? = null, val digestMethod: SamlDigestAlgorithm, val enterpriseId: ID, val idpCertificate: String, val issuer: String? = null, val signatureMethod: SamlSignatureAlgorithm, val ssoUrl: URI) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", digestMethod: $digestMethod, enterpriseId: \"$enterpriseId\", idpCertificate: \"$idpCertificate\", issuer: \"$issuer\", signatureMethod: $signatureMethod, ssoUrl: \"$ssoUrl\" }"
}

class SponsorsTierOrder(val direction: OrderDirection, val field: SponsorsTierOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class SponsorshipOrder(val direction: OrderDirection, val field: SponsorshipOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class StarOrder(val direction: OrderDirection, val field: StarOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class SubmitPullRequestReviewInput(val body: String? = null, val clientMutationId: String? = null, val event: PullRequestReviewEvent, val pullRequestId: ID? = null, val pullRequestReviewId: ID? = null) {
    override fun toString() = "{ body: \"$body\", clientMutationId: \"$clientMutationId\", event: $event, pullRequestId: \"$pullRequestId\", pullRequestReviewId: \"$pullRequestReviewId\" }"
}

class TeamDiscussionCommentOrder(val direction: OrderDirection, val field: TeamDiscussionCommentOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class TeamDiscussionOrder(val direction: OrderDirection, val field: TeamDiscussionOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class TeamMemberOrder(val direction: OrderDirection, val field: TeamMemberOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class TeamOrder(val direction: OrderDirection, val field: TeamOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class TeamRepositoryOrder(val direction: OrderDirection, val field: TeamRepositoryOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}

class TransferIssueInput(val clientMutationId: String? = null, val issueId: ID, val repositoryId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", issueId: \"$issueId\", repositoryId: \"$repositoryId\" }"
}

class UnarchiveRepositoryInput(val clientMutationId: String? = null, val repositoryId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", repositoryId: \"$repositoryId\" }"
}

class UnfollowUserInput(val clientMutationId: String? = null, val userId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", userId: \"$userId\" }"
}

class UnlinkRepositoryFromProjectInput(val clientMutationId: String? = null, val projectId: ID, val repositoryId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", projectId: \"$projectId\", repositoryId: \"$repositoryId\" }"
}

class UnlockLockableInput(val clientMutationId: String? = null, val lockableId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", lockableId: \"$lockableId\" }"
}

class UnmarkFileAsViewedInput(val clientMutationId: String? = null, val path: String, val pullRequestId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", path: \"$path\", pullRequestId: \"$pullRequestId\" }"
}

class UnmarkIssueAsDuplicateInput(val canonicalId: ID, val clientMutationId: String? = null, val duplicateId: ID) {
    override fun toString() = "{ canonicalId: \"$canonicalId\", clientMutationId: \"$clientMutationId\", duplicateId: \"$duplicateId\" }"
}

class UnminimizeCommentInput(val clientMutationId: String? = null, val subjectId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", subjectId: \"$subjectId\" }"
}

class UnpinIssueInput(val clientMutationId: String? = null, val issueId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", issueId: \"$issueId\" }"
}

class UnresolveReviewThreadInput(val clientMutationId: String? = null, val threadId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", threadId: \"$threadId\" }"
}

class UpdateBranchProtectionRuleInput(val allowsDeletions: Boolean? = null, val allowsForcePushes: Boolean? = null, val branchProtectionRuleId: ID, val clientMutationId: String? = null, val dismissesStaleReviews: Boolean? = null, val isAdminEnforced: Boolean? = null, val pattern: String? = null, val pushActorIds: ID? = null, val requiredApprovingReviewCount: Int? = null, val requiredStatusCheckContexts: String? = null, val requiresApprovingReviews: Boolean? = null, val requiresCodeOwnerReviews: Boolean? = null, val requiresCommitSignatures: Boolean? = null, val requiresLinearHistory: Boolean? = null, val requiresStatusChecks: Boolean? = null, val requiresStrictStatusChecks: Boolean? = null, val restrictsPushes: Boolean? = null, val restrictsReviewDismissals: Boolean? = null, val reviewDismissalActorIds: ID? = null) {
    override fun toString() = "{ allowsDeletions: $allowsDeletions, allowsForcePushes: $allowsForcePushes, branchProtectionRuleId: \"$branchProtectionRuleId\", clientMutationId: \"$clientMutationId\", dismissesStaleReviews: $dismissesStaleReviews, isAdminEnforced: $isAdminEnforced, pattern: \"$pattern\", pushActorIds: \"$pushActorIds\", requiredApprovingReviewCount: $requiredApprovingReviewCount, requiredStatusCheckContexts: \"$requiredStatusCheckContexts\", requiresApprovingReviews: $requiresApprovingReviews, requiresCodeOwnerReviews: $requiresCodeOwnerReviews, requiresCommitSignatures: $requiresCommitSignatures, requiresLinearHistory: $requiresLinearHistory, requiresStatusChecks: $requiresStatusChecks, requiresStrictStatusChecks: $requiresStrictStatusChecks, restrictsPushes: $restrictsPushes, restrictsReviewDismissals: $restrictsReviewDismissals, reviewDismissalActorIds: \"$reviewDismissalActorIds\" }"
}

class UpdateCheckRunInput(val actions: CheckRunAction? = null, val checkRunId: ID, val clientMutationId: String? = null, val completedAt: DateTime? = null, val conclusion: CheckConclusionState? = null, val detailsUrl: URI? = null, val externalId: String? = null, val name: String? = null, val output: CheckRunOutput? = null, val repositoryId: ID, val startedAt: DateTime? = null, val status: RequestableCheckStatusState? = null) {
    override fun toString() = "{ actions: $actions, checkRunId: \"$checkRunId\", clientMutationId: \"$clientMutationId\", completedAt: \"$completedAt\", conclusion: $conclusion, detailsUrl: \"$detailsUrl\", externalId: \"$externalId\", name: \"$name\", output: $output, repositoryId: \"$repositoryId\", startedAt: \"$startedAt\", status: $status }"
}

class UpdateCheckSuitePreferencesInput(val autoTriggerPreferences: CheckSuiteAutoTriggerPreference, val clientMutationId: String? = null, val repositoryId: ID) {
    override fun toString() = "{ autoTriggerPreferences: $autoTriggerPreferences, clientMutationId: \"$clientMutationId\", repositoryId: \"$repositoryId\" }"
}

class UpdateEnterpriseAdministratorRoleInput(val clientMutationId: String? = null, val enterpriseId: ID, val login: String, val role: EnterpriseAdministratorRole) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", enterpriseId: \"$enterpriseId\", login: \"$login\", role: $role }"
}

class UpdateEnterpriseAllowPrivateRepositoryForkingSettingInput(val clientMutationId: String? = null, val enterpriseId: ID, val settingValue: EnterpriseEnabledDisabledSettingValue) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", enterpriseId: \"$enterpriseId\", settingValue: $settingValue }"
}

class UpdateEnterpriseDefaultRepositoryPermissionSettingInput(val clientMutationId: String? = null, val enterpriseId: ID, val settingValue: EnterpriseDefaultRepositoryPermissionSettingValue) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", enterpriseId: \"$enterpriseId\", settingValue: $settingValue }"
}

class UpdateEnterpriseMembersCanChangeRepositoryVisibilitySettingInput(val clientMutationId: String? = null, val enterpriseId: ID, val settingValue: EnterpriseEnabledDisabledSettingValue) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", enterpriseId: \"$enterpriseId\", settingValue: $settingValue }"
}

class UpdateEnterpriseMembersCanCreateRepositoriesSettingInput(val clientMutationId: String? = null, val enterpriseId: ID, val membersCanCreateInternalRepositories: Boolean? = null, val membersCanCreatePrivateRepositories: Boolean? = null, val membersCanCreatePublicRepositories: Boolean? = null, val membersCanCreateRepositoriesPolicyEnabled: Boolean? = null, val settingValue: EnterpriseMembersCanCreateRepositoriesSettingValue? = null) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", enterpriseId: \"$enterpriseId\", membersCanCreateInternalRepositories: $membersCanCreateInternalRepositories, membersCanCreatePrivateRepositories: $membersCanCreatePrivateRepositories, membersCanCreatePublicRepositories: $membersCanCreatePublicRepositories, membersCanCreateRepositoriesPolicyEnabled: $membersCanCreateRepositoriesPolicyEnabled, settingValue: $settingValue }"
}

class UpdateEnterpriseMembersCanDeleteIssuesSettingInput(val clientMutationId: String? = null, val enterpriseId: ID, val settingValue: EnterpriseEnabledDisabledSettingValue) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", enterpriseId: \"$enterpriseId\", settingValue: $settingValue }"
}

class UpdateEnterpriseMembersCanDeleteRepositoriesSettingInput(val clientMutationId: String? = null, val enterpriseId: ID, val settingValue: EnterpriseEnabledDisabledSettingValue) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", enterpriseId: \"$enterpriseId\", settingValue: $settingValue }"
}

class UpdateEnterpriseMembersCanInviteCollaboratorsSettingInput(val clientMutationId: String? = null, val enterpriseId: ID, val settingValue: EnterpriseEnabledDisabledSettingValue) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", enterpriseId: \"$enterpriseId\", settingValue: $settingValue }"
}

class UpdateEnterpriseMembersCanMakePurchasesSettingInput(val clientMutationId: String? = null, val enterpriseId: ID, val settingValue: EnterpriseMembersCanMakePurchasesSettingValue) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", enterpriseId: \"$enterpriseId\", settingValue: $settingValue }"
}

class UpdateEnterpriseMembersCanUpdateProtectedBranchesSettingInput(val clientMutationId: String? = null, val enterpriseId: ID, val settingValue: EnterpriseEnabledDisabledSettingValue) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", enterpriseId: \"$enterpriseId\", settingValue: $settingValue }"
}

class UpdateEnterpriseMembersCanViewDependencyInsightsSettingInput(val clientMutationId: String? = null, val enterpriseId: ID, val settingValue: EnterpriseEnabledDisabledSettingValue) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", enterpriseId: \"$enterpriseId\", settingValue: $settingValue }"
}

class UpdateEnterpriseOrganizationProjectsSettingInput(val clientMutationId: String? = null, val enterpriseId: ID, val settingValue: EnterpriseEnabledDisabledSettingValue) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", enterpriseId: \"$enterpriseId\", settingValue: $settingValue }"
}

class UpdateEnterpriseProfileInput(val clientMutationId: String? = null, val description: String? = null, val enterpriseId: ID, val location: String? = null, val name: String? = null, val websiteUrl: String? = null) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", description: \"$description\", enterpriseId: \"$enterpriseId\", location: \"$location\", name: \"$name\", websiteUrl: \"$websiteUrl\" }"
}

class UpdateEnterpriseRepositoryProjectsSettingInput(val clientMutationId: String? = null, val enterpriseId: ID, val settingValue: EnterpriseEnabledDisabledSettingValue) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", enterpriseId: \"$enterpriseId\", settingValue: $settingValue }"
}

class UpdateEnterpriseTeamDiscussionsSettingInput(val clientMutationId: String? = null, val enterpriseId: ID, val settingValue: EnterpriseEnabledDisabledSettingValue) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", enterpriseId: \"$enterpriseId\", settingValue: $settingValue }"
}

class UpdateEnterpriseTwoFactorAuthenticationRequiredSettingInput(val clientMutationId: String? = null, val enterpriseId: ID, val settingValue: EnterpriseEnabledSettingValue) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", enterpriseId: \"$enterpriseId\", settingValue: $settingValue }"
}

class UpdateIpAllowListEnabledSettingInput(val clientMutationId: String? = null, val ownerId: ID, val settingValue: IpAllowListEnabledSettingValue) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", ownerId: \"$ownerId\", settingValue: $settingValue }"
}

class UpdateIpAllowListEntryInput(val allowListValue: String, val clientMutationId: String? = null, val ipAllowListEntryId: ID, val isActive: Boolean, val name: String? = null) {
    override fun toString() = "{ allowListValue: \"$allowListValue\", clientMutationId: \"$clientMutationId\", ipAllowListEntryId: \"$ipAllowListEntryId\", isActive: $isActive, name: \"$name\" }"
}

class UpdateIssueCommentInput(val body: String, val clientMutationId: String? = null, val id: ID) {
    override fun toString() = "{ body: \"$body\", clientMutationId: \"$clientMutationId\", id: \"$id\" }"
}

class UpdateIssueInput(val assigneeIds: ID? = null, val body: String? = null, val clientMutationId: String? = null, val id: ID, val labelIds: ID? = null, val milestoneId: ID? = null, val projectIds: ID? = null, val state: IssueState? = null, val title: String? = null) {
    override fun toString() = "{ assigneeIds: \"$assigneeIds\", body: \"$body\", clientMutationId: \"$clientMutationId\", id: \"$id\", labelIds: \"$labelIds\", milestoneId: \"$milestoneId\", projectIds: \"$projectIds\", state: $state, title: \"$title\" }"
}

class UpdateLabelInput(val clientMutationId: String? = null, val color: String? = null, val description: String? = null, val id: ID, val name: String? = null) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", color: \"$color\", description: \"$description\", id: \"$id\", name: \"$name\" }"
}

class UpdateProjectCardInput(val clientMutationId: String? = null, val isArchived: Boolean? = null, val note: String? = null, val projectCardId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", isArchived: $isArchived, note: \"$note\", projectCardId: \"$projectCardId\" }"
}

class UpdateProjectColumnInput(val clientMutationId: String? = null, val name: String, val projectColumnId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", name: \"$name\", projectColumnId: \"$projectColumnId\" }"
}

class UpdateProjectInput(val body: String? = null, val clientMutationId: String? = null, val name: String? = null, val projectId: ID, val public: Boolean? = null, val state: ProjectState? = null) {
    override fun toString() = "{ body: \"$body\", clientMutationId: \"$clientMutationId\", name: \"$name\", projectId: \"$projectId\", public: $public, state: $state }"
}

class UpdatePullRequestInput(val assigneeIds: ID? = null, val baseRefName: String? = null, val body: String? = null, val clientMutationId: String? = null, val labelIds: ID? = null, val maintainerCanModify: Boolean? = null, val milestoneId: ID? = null, val projectIds: ID? = null, val pullRequestId: ID, val state: PullRequestUpdateState? = null, val title: String? = null) {
    override fun toString() = "{ assigneeIds: \"$assigneeIds\", baseRefName: \"$baseRefName\", body: \"$body\", clientMutationId: \"$clientMutationId\", labelIds: \"$labelIds\", maintainerCanModify: $maintainerCanModify, milestoneId: \"$milestoneId\", projectIds: \"$projectIds\", pullRequestId: \"$pullRequestId\", state: $state, title: \"$title\" }"
}

class UpdatePullRequestReviewCommentInput(val body: String, val clientMutationId: String? = null, val pullRequestReviewCommentId: ID) {
    override fun toString() = "{ body: \"$body\", clientMutationId: \"$clientMutationId\", pullRequestReviewCommentId: \"$pullRequestReviewCommentId\" }"
}

class UpdatePullRequestReviewInput(val body: String, val clientMutationId: String? = null, val pullRequestReviewId: ID) {
    override fun toString() = "{ body: \"$body\", clientMutationId: \"$clientMutationId\", pullRequestReviewId: \"$pullRequestReviewId\" }"
}

class UpdateRefInput(val clientMutationId: String? = null, val force: Boolean? = null, val oid: GitObjectID, val refId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", force: $force, oid: \"$oid\", refId: \"$refId\" }"
}

class UpdateRefsInput(val clientMutationId: String? = null, val refUpdates: RefUpdate, val repositoryId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", refUpdates: $refUpdates, repositoryId: \"$repositoryId\" }"
}

class UpdateRepositoryInput(val clientMutationId: String? = null, val description: String? = null, val hasIssuesEnabled: Boolean? = null, val hasProjectsEnabled: Boolean? = null, val hasWikiEnabled: Boolean? = null, val homepageUrl: URI? = null, val name: String? = null, val repositoryId: ID, val template: Boolean? = null) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", description: \"$description\", hasIssuesEnabled: $hasIssuesEnabled, hasProjectsEnabled: $hasProjectsEnabled, hasWikiEnabled: $hasWikiEnabled, homepageUrl: \"$homepageUrl\", name: \"$name\", repositoryId: \"$repositoryId\", template: $template }"
}

class UpdateSubscriptionInput(val clientMutationId: String? = null, val state: SubscriptionState, val subscribableId: ID) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", state: $state, subscribableId: \"$subscribableId\" }"
}

class UpdateTeamDiscussionCommentInput(val body: String, val bodyVersion: String? = null, val clientMutationId: String? = null, val id: ID) {
    override fun toString() = "{ body: \"$body\", bodyVersion: \"$bodyVersion\", clientMutationId: \"$clientMutationId\", id: \"$id\" }"
}

class UpdateTeamDiscussionInput(val body: String? = null, val bodyVersion: String? = null, val clientMutationId: String? = null, val id: ID, val pinned: Boolean? = null, val title: String? = null) {
    override fun toString() = "{ body: \"$body\", bodyVersion: \"$bodyVersion\", clientMutationId: \"$clientMutationId\", id: \"$id\", pinned: $pinned, title: \"$title\" }"
}

class UpdateTeamReviewAssignmentInput(val algorithm: TeamReviewAssignmentAlgorithm? = null, val clientMutationId: String? = null, val enabled: Boolean, val excludedTeamMemberIds: ID? = null, val id: ID, val notifyTeam: Boolean? = null, val teamMemberCount: Int? = null) {
    override fun toString() = "{ algorithm: $algorithm, clientMutationId: \"$clientMutationId\", enabled: $enabled, excludedTeamMemberIds: \"$excludedTeamMemberIds\", id: \"$id\", notifyTeam: $notifyTeam, teamMemberCount: $teamMemberCount }"
}

class UpdateTopicsInput(val clientMutationId: String? = null, val repositoryId: ID, val topicNames: String) {
    override fun toString() = "{ clientMutationId: \"$clientMutationId\", repositoryId: \"$repositoryId\", topicNames: \"$topicNames\" }"
}

class UserStatusOrder(val direction: OrderDirection, val field: UserStatusOrderField) {
    override fun toString() = "{ direction: $direction, field: $field }"
}
