package blue.starry.scriptextender

import org.gradle.api.Project
import java.net.URI

private const val MavenCentralStagingRepositoryUrl = "https://oss.sonatype.org/service/local/staging/deploy/maven2"
val Project.MavenCentralStagingRepositoryUri: URI
    get() = uri(MavenCentralStagingRepositoryUrl)

private const val MavenCentralSnapshotRepositoryUrl = "https://oss.sonatype.org/content/repositories/snapshots"
val Project.MavenCentralSnapshotRepositoryUri: URI
    get() = uri(MavenCentralSnapshotRepositoryUrl)
