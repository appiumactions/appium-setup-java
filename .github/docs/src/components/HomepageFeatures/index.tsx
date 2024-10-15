import clsx from 'clsx';
import Heading from '@theme/Heading';
import styles from './styles.module.css';

type FeatureItem = {
  title: string;
  Svg: React.ComponentType<React.ComponentProps<'svg'>>;
  description: JSX.Element;
};

const FeatureList: FeatureItem[] = [
  {
    title: 'Capabilities File',
    Svg: require('@site/static/img/undraw_setup.svg').default,
    description: (
      <>
        Configuration of capabilities for the test session outside of the java code.
      </>
    ),
  },
  {
    title: 'Parameterized Files',
    Svg: require('@site/static/img/undraw_select.svg').default,
    description: (
      <>
        Possibility of having different capacity files with simple management.
      </>
    ),
  },
  {
    title: 'Test Suite',
    Svg: require('@site/static/img/undraw_browser_stats.svg').default,
    description: (
      <>
        Capacity management for creating test suites.
      </>
    ),
  }
];

function Feature({title, Svg, description}: FeatureItem) {
  return (
    <div className={clsx('col col--4')}>
      <div className="text--center">
        <Svg className={styles.featureSvg} role="img" />
      </div>
      <div className="text--center padding-horiz--md">
        <Heading as="h3">{title}</Heading>
        <p>{description}</p>
      </div>
    </div>
  );
}

export default function HomepageFeatures(): JSX.Element {
  return (
    <section className={styles.features}>
      <div className="container">
        <div className="row">
          {FeatureList.map((props, idx) => (
            <Feature key={idx} {...props} />
          ))}
        </div>
      </div>
    </section>
  );
}
