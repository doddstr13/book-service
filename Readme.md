# Book Service

Simple spring boot application which pre-loads books into repository and then
offers a rest interface for data access.

## CI/CD Pipelines

Inspired by: https://github.com/alexandreroman/cloud-native-pipelines

fly -t lab set-pipeline -p build-book-service -c ci/pipeline.yaml -l ci/values.yaml -n

Create ci/values.yml with appropriate values.

```yaml
git-uri: https://github.com/doddatpivotal/book-service.git
git-branch: master
git-username:
git-password:
slack-webhook: CHANGEME
app-java-version: '17'
app: book-service
build-cli-version: 0.0.4
build-project: book-service
build-image: harbor.lab.winterfell.live/book-service/book-service
build-username: lannister-ci
build-password: CHANGEME
build-target: https://pbs.lab.winterfell.live
slack-channel: dpfeffer-ci
```

## Pack CNB Build

```bash
pack build book-service --builder cloudfoundry/cnb:cflinuxfs3
```