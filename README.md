bungee-statsd-client
==================

[![Build Status](https://ci.minotopia.me/buildStatus/icon?job=public~bungee-statsd-client)](https://ci.minotopia.me/job/public~bungee-statsd-client)

A statsd client library implemented in Java.  Allows for Java applications to easily communicate with statsd. This is
a fork adapted to use the BungeeCord Scheduler, because that one gets jealous of other executors very quickly.

Downloads
---------
The client jar is distributed via a custom Maven repository.

```xml
<repository>
    <id>xxyy-public</id>
    <url>https://repo.l1t.li/xxyy-public/</url>
</repository>
```

```xml
<dependency>
    <groupId>me.minotopia</groupId>
    <artifactId>bungee-statsd-client</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

Usage
-----
```java
import net.md_5.bungee.api.plugin.Plugin;
import com.timgroup.statsd.StatsDClient;
import com.timgroup.statsd.NonBlockingStatsDClient;

public class Foo extends Plugin {
  private final StatsDClient statsd = new NonBlockingStatsDClient("my.prefix", "statsd-host", 8125, this);

  @Override
  public void onEnable() {
    statsd.incrementCounter("bar");
    statsd.recordGaugeValue("baz", 100);
    statsd.recordExecutionTime("bag", 25);
    statsd.recordSetEvent("qux", "one");
  }
}
```

