
## Set Credentials in settings.xml

#### Edit ~/.m2/settings.xml (Linux/Mac) or %USERPROFILE%\.m2\settings.xml (Windows) and add:

```xml
<settings>
  <servers>
    <server>
      <id>myreleaserepo</id>
      <username>testuser</username>
      <password>testpass</password>
    </server>
    <server>
      <id>mysnapshotrepo</id>
      <username>testuser</username>
      <password>testpass</password>
    </server>
  </servers>
</settings>
```
